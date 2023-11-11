package com.pcaldi.gestao_vagas.exceptions;

public class UserFoundExcption extends RuntimeException {
    public UserFoundExcption() {
        super("Usuário já cadastrado!");
    }
}
