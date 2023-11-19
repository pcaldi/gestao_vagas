package com.pcaldi.gestao_vagas.modules.candidate.dto;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileCandidateResponseDTO {

    @Schema(example = "Desenvolvedor Mobile")
    private String description;

    @Schema(example = "loiro")
    private String username;

    @Schema(example = "loiro@gmail.com")
    private String email;

    @Schema(example = "Loiro Caldi")
    private String name;
    private UUID id;
}
