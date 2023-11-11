package com.pcaldi.gestao_vagas.modules.compony.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcaldi.gestao_vagas.exceptions.UserFoundExcption;
import com.pcaldi.gestao_vagas.modules.compony.entities.CompanyEntity;
import com.pcaldi.gestao_vagas.modules.compony.repositories.CompanyRepository;

@Service
public class CreateCompanyUseCase {

    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntity execute(CompanyEntity companyEntity) {
        this.companyRepository.findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundExcption();
                });

        return this.companyRepository.save(companyEntity);
    }
}
