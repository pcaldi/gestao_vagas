package com.pcaldi.gestao_vagas.modules.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "company")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Campo obrigatório")
    @Schema(example = "Javalin")
    private String name;

    @NotBlank(message = "Campo obrigatório")
    @Schema(example = "javalin")
    private String username;

    @Email
    @Schema(example = "javalin@javalin.com.br")
    private String email;

    @Length(min = 10, max = 100, message = "O campo [senha] deve conter entre 10 e 100 caracteres")
    @Schema(example = "1234567890", minLength = 10, maxLength = 100, requiredMode = RequiredMode.REQUIRED, description = "Senha da company")
    private String password;

    @Schema(example = "https://www.javalin.com.br")
    private String website;

    @Schema(example = "Empresa de desenvolvimento java")
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
