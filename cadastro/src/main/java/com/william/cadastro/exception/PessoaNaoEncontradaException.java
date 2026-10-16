package com.william.cadastro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PessoaNaoEncontradaException extends RuntimeException{
    public PessoaNaoEncontradaException(Long id){
        super("Pessoa não encontrada com id " + id);
    }
}
