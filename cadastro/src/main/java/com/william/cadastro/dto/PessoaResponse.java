package com.william.cadastro.dto;

import com.william.cadastro.model.Pessoa;

public record PessoaResponse(Long id, String nome, String email, String telefone) {
    public static PessoaResponse fromEntity(Pessoa pessoa) {
        return new PessoaResponse(
                pessoa.getId(),
                pessoa.getNome(),
                pessoa.getEmail(),
                pessoa.getTelefone()
        );
    }
}
