package com.pcaldi.gestao_vagas.modules.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateJobDTO {

    @Schema(example = "Vaga de estágio para React Native", requiredMode = RequiredMode.REQUIRED)
    private String description;

    @Schema(example = "GYMPass, VA/VT, Day off no aniversário", requiredMode = RequiredMode.REQUIRED)
    private String benefits;

    @Schema(example = "ESTÁGIO", requiredMode = RequiredMode.REQUIRED)
    private String level;
}
