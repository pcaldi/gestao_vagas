package com.pcaldi.gestao_vagas.modules.company.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcaldi.gestao_vagas.exceptions.JobNotFoundException;
import com.pcaldi.gestao_vagas.exceptions.UserNotFoundException;
import com.pcaldi.gestao_vagas.modules.candidate.CandidateRepository;
import com.pcaldi.gestao_vagas.modules.candidate.entity.ApplyJobEntity;
import com.pcaldi.gestao_vagas.modules.candidate.repository.ApplyJobRepository;
import com.pcaldi.gestao_vagas.modules.company.repositories.JobRepository;

@Service
public class ApplyJobCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplyJobRepository applyJobRepository;

    // ID do candidato
    // ID da vaga
    public ApplyJobEntity execute(UUID idCandidate, UUID idJob) {

        // Validar se o candidato existe
        this.candidateRepository.findById(idCandidate).orElseThrow(() -> {
            throw new UserNotFoundException();
        });

        // Validar se o vaga existe
        this.jobRepository.findById(idJob).orElseThrow(() -> {
            throw new JobNotFoundException();
        });

        // Validar se candidato se inscreveu na vaga

        var applyJob = ApplyJobEntity.builder()
                .candidateId(idCandidate)
                .jobId(idJob).build();

        applyJob = applyJobRepository.save(applyJob);
        return applyJob;

    }
}
