package com.pcaldi.gestao_vagas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PrimeiroTeste {

    @Test
    public void deve_ser_possivel_calcular_dois_numeros() {

        var result = calculate(5, 2);
        assertEquals(result, 10);
    }

    private static int calculate(int num1, int num2) {
        return num1 * num2;
    }

}
