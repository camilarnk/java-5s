package com.bn.school.controllers;

import com.bn.school.models.EstudanteModel;
import com.bn.school.services.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // informar que a classe sera o controlador - receber a url
@RequestMapping("/estudantes") // mapeamento a ser feito na rota - localhost:8080/estudantes
// server.port = 80*0 no application properties caso precise alterar a porta
public class EstudanteController {

    @Autowired // injeçao de dependencia
    private EstudanteService estudanteService;

    @GetMapping // informar que sera apenas uma busca
    public List<EstudanteModel> findAll() {
        return estudanteService.findAll();
    }

    @GetMapping("/{id}")
    // optional é necessario para uma busca onde pode ter um resultado ou nao
    public Optional<EstudanteModel> buscarPorId(@PathVariable Long id) {
        return estudanteService.buscarPorId(id);
    }

    @PostMapping // informar que é um metodo de criaçao
    public EstudanteModel criarEstudante(@RequestBody EstudanteModel estudanteModel) { // RequestBody para informar que a requisicao HTTP sera pelo corpo
        return estudanteService.criarEstudante(estudanteModel);
    }

    @PutMapping("/{id}")
    public EstudanteModel atualizarEstudante(@PathVariable Long id, @RequestBody EstudanteModel estudanteModel) { // o estudante sera passado pelo body
        return estudanteService.atualizarEstudante(id, estudanteModel);
    }

    @DeleteMapping("/{id}")
    // PathVariable para extrair valores da **URL** e passar como parametro para o metodo
    public void deletarEstudante(@PathVariable Long id) {
        estudanteService.deletarEstudante(id);
    }

}
