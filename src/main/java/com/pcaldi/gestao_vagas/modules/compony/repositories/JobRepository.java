package com.pcaldi.gestao_vagas.modules.compony.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pcaldi.gestao_vagas.modules.compony.entities.JobEntity;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {

}
