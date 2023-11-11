package com.pcaldi.gestao_vagas.modules.exceptions;

public class UserFoundExcption extends RuntimeException {
    public UserFoundExcption() {
        super("Usuário já cadastrado!");
    }
}
