package com.pcaldi.gestao_vagas.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessageDTO {
    private String message;
    private String filed;
}
