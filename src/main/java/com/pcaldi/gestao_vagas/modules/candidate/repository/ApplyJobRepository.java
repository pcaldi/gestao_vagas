package com.pcaldi.gestao_vagas.modules.candidate.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplyJobRepository extends JpaRepository<ApplyJobRepository, UUID> {

}
