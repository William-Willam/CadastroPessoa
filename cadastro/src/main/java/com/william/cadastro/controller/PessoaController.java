package com.william.cadastro.controller;

import com.william.cadastro.dto.PessoaRequest;
import com.william.cadastro.dto.PessoaResponse;
import com.william.cadastro.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//Marca a classe como Controller de API:
// o retorno dos métodos vira JSON no corpo da resposta (e não uma página HTML).
@RequestMapping("/pessoas")
//Define o caminho base: todos os endpoints desta classe começam em /pessoas.
public class PessoaController {

    //chamado da camada Service.
    private PessoaService pessoaService;

    //construtor
    public PessoaController(PessoaService pessoaService) {
        //injeção
        this.pessoaService = pessoaService;
    }

    // Metodos HTTP
    /*
    GET = Consultar dados, busca informações sem criar, alterar ou excluir
    POST = Cadastrar dados, envia informações para criar um registro.
    PUT = atualizar os dados, substitui a representação do registro existente pelos dados enviados.
    DELETE = excluir dados, solicita a remoção de um registro.
    */

    @GetMapping
    //Esse método responde a requisições GET em /pessoas (listar).
    public ResponseEntity<List<PessoaResponse>>listar(){
        return ResponseEntity.ok(pessoaService.listarTodas());
    }

    @PostMapping
    //Esse método responde a requisições POST em /pessoas (criar).
    //@RequestBody = Pega o JSON do corpo da requisição e o converte em um objeto PessoaRequest.
    //ResponseEntity = Permite controlar o status HTTP e o corpo da resposta.
    public ResponseEntity<PessoaResponse> criar(@RequestBody PessoaRequest request){
        PessoaResponse response = pessoaService.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
