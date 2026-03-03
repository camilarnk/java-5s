package com.bn.school.controllers;

import com.bn.school.models.EstudanteModel;
import com.bn.school.services.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // informar que a classe sera o controlador - receber a url
@RequestMapping("/estudantes") // mapeamento a ser feito na rota - localhost:8080/estudantes
// server.port = 8090 no application properties caso precise alterar a porta
public class EstudanteController {

    @Autowired // injeçao de dependencia
    private EstudanteService estudanteService;

    @GetMapping // informar que sera apenas uma busca
    public List<EstudanteModel> findAll() {
        return estudanteService.findAll();
    }

    @PostMapping // informar que é um metodo de criaçao
    // RequestBody necessario para informar que a requisicao HTTP sera pelo corpo
    public EstudanteModel criarEstudante(@RequestBody EstudanteModel estudanteModel) {
        return estudanteService.criarEstudante(estudanteModel);
    }

    @DeleteMapping("/{id}")
    // PathVariable para extrair valores da URL e passar como parametro para o metodo
    public void deletarEstudante(@PathVariable Long id) {
        estudanteService.deletarEstudante(id);
    }

}
