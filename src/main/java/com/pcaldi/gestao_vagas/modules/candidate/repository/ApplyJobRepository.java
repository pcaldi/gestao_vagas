package com.pcaldi.gestao_vagas.modules.candidate.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pcaldi.gestao_vagas.modules.candidate.entity.ApplyJobEntity;

public interface ApplyJobRepository extends JpaRepository<ApplyJobEntity, UUID> {

}
