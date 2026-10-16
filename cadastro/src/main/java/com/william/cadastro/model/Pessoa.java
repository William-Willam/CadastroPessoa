package com.william.cadastro.model;

import jakarta.persistence.*;

@Entity // Avisa ao JPA/Hibernate que esta classe vira uma tabela.
@Table(name = "pessoa") // Define o nome da tabela. Sem ela, usaria o nome da classe.
public class Pessoa {

    @Id // Marca o campo que é a chave primária.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O próprio MySQL gera o id (AUTO_INCREMENT)
    private Long id;

    /*
        @Column
    *  Configura a coluna: nullable = false é NOT NULL,
    *  unique = true não permite repetir, length é o tamanho do VARCHAR.
    */

    @Column(nullable = false,length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(length = 20)
    private String telefone;

    public Pessoa() {
        //O construtor vazio é obrigatório:
        //o Hibernate cria objetos com ele e depois preenche os campos pelos setters.
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
