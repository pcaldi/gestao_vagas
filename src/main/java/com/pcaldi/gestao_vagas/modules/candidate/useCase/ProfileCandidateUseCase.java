package com.pcaldi.gestao_vagas.modules.candidate.useCase;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcaldi.gestao_vagas.exceptions.UserNotFoundException;
import com.pcaldi.gestao_vagas.modules.candidate.CandidateRepository;
import com.pcaldi.gestao_vagas.modules.candidate.dto.ProfileCandidateResponseDTO;

@Service
public class ProfileCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public ProfileCandidateResponseDTO execute(UUID IdCandidate) {
        var candidate = this.candidateRepository.findById(IdCandidate)
                .orElseThrow(() -> {
                    throw new UserNotFoundException();
                });

        var candidateDTO = ProfileCandidateResponseDTO
                .builder()
                .description(candidate.getDescription())
                .email(candidate.getEmail())
                .name(candidate.getName())
                .username(candidate.getUsername())
                .id(candidate.getId())
                .build();
        return candidateDTO;
    }
}
