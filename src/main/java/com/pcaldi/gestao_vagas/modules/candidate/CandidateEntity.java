package com.pcaldi.gestao_vagas.modules.candidate;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CandidateEntity {

    private UUID id;
    private String name;

    @Pattern(regexp = "(\\S+)", message = "O campo [username] não deve conter espaços")
    private String username;

    @Email(message = "O campo [e-mail] deve conter um e-mail válido")
    private String email;

    @Length(min = 10, max = 100)
    private String password;

    private String description;
    private String curriculun;

    private LocalDateTime createdAt;

}
