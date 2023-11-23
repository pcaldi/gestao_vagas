package com.pcaldi.gestao_vagas.modules.candidate.useCases;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pcaldi.gestao_vagas.exceptions.JobNotFoundException;
import com.pcaldi.gestao_vagas.exceptions.UserNotFoundException;
import com.pcaldi.gestao_vagas.modules.candidate.CandidateEntity;
import com.pcaldi.gestao_vagas.modules.candidate.CandidateRepository;
import com.pcaldi.gestao_vagas.modules.candidate.entity.ApplyJobEntity;
import com.pcaldi.gestao_vagas.modules.candidate.repository.ApplyJobRepository;
import com.pcaldi.gestao_vagas.modules.company.entities.JobEntity;
import com.pcaldi.gestao_vagas.modules.company.repositories.JobRepository;
import com.pcaldi.gestao_vagas.modules.company.useCases.ApplyJobCandidateUseCase;

@ExtendWith(MockitoExtension.class)
public class ApplyJobCandidateUseCaseTest {

    @InjectMocks
    private ApplyJobCandidateUseCase applyJobCandidateUseCase;

    @Mock
    private CandidateRepository candidateRepository;

    @Mock
    private JobRepository jobRepository;

    @Mock
    private ApplyJobRepository applyJobRepository;

    @Test
    @DisplayName("Should not be able to apply job with candidate not found")
    public void should_not_be_able_to_apply_job_with_candidate_not_found() {
        try {
            applyJobCandidateUseCase.execute(null, null);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(UserNotFoundException.class);
        }
    }

    @Test
    @DisplayName("Should not be able to apply job with job not found")
    public void should_not_be_able_to_apply_job_with_job_not_found() {
        var idCandidate = UUID.randomUUID();

        var candidate = new CandidateEntity();
        candidate.setId(idCandidate);

        when(candidateRepository.findById(idCandidate)).thenReturn(Optional.of(candidate));

        try {
            applyJobCandidateUseCase.execute(idCandidate, null);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(JobNotFoundException.class);
        }
    }

    @Test
    @DisplayName("Should be able to create a new apply job")
    public void should_be_able_to_create_a_new_apply_job() {
        var idCandidate = UUID.randomUUID();
        var jobId = UUID.randomUUID();

        var applyJob = ApplyJobEntity.builder()
                .candidateId(idCandidate)
                .jobId(jobId)
                .build();

        // applyJob.setId(UUID.randomUUID());

        var applyJobCreated = ApplyJobEntity.builder().id(UUID.randomUUID()).build();

        when(candidateRepository.findById(idCandidate)).thenReturn(Optional.of(new CandidateEntity()));

        when(jobRepository.findById(jobId)).thenReturn(Optional.of(new JobEntity()));

        when(applyJobRepository.save(applyJob)).thenReturn(applyJobCreated);

        var result = applyJobCandidateUseCase.execute(idCandidate, jobId);

        assertThat(result).hasFieldOrProperty("id");
        assertNotNull(result.getId());
    }
}
