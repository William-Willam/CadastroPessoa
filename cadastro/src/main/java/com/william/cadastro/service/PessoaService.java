package com.william.cadastro.service;

import com.william.cadastro.dto.PessoaRequest;
import com.william.cadastro.dto.PessoaResponse;
import com.william.cadastro.model.Pessoa;
import com.william.cadastro.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Marca a classe como componente da camada de serviço.
        // A @ComponentScan a encontra e o Spring cria uma instância dela.
public class PessoaService {

    // private final = O campo não muda depois de criado: boa prática.
    private final PessoaRepository pessoaRepository;

    // Construtor
    public PessoaService(PessoaRepository pessoaRepository) {
        //É a injeção de dependência: o Spring entrega o repository pronto.
        //Você não escreve new.
        this.pessoaRepository = pessoaRepository;
    }

    // 1ºcreate
    public PessoaResponse criar(PessoaRequest request) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(request.nome());
        pessoa.setEmail(request.email());
        pessoa.setTelefone(request.telefone());

        //save =Faz INSERT (ou UPDATE, se já tiver id) e devolve a entidade com o id preenchido.
        Pessoa salva = pessoaRepository.save(pessoa);
        return PessoaResponse.fromEntity(salva);
    }

    // 2º Read
    public List<PessoaResponse> listarTodas() {

        // findAll = "Faz select * from" e devolve uma lista de pessoa
        return pessoaRepository.findAll()
                //stream = converte cada pessoa da lista em um response
                .stream()
                .map(PessoaResponse::fromEntity)
                .toList();
    }
    //2.1º buscar por id
    
    //3º update
    //4º Delete
}