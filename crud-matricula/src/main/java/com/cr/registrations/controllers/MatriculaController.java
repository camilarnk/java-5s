package com.cr.registrations.controllers;

import com.cr.registrations.models.Matricula;
import com.cr.registrations.services.MatriculaService;
import jakarta.servlet.Servlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @PostMapping("/aluno/{idAluno}")
    public ResponseEntity<Matricula> create (@RequestBody Matricula matricula, @PathVariable Long idAluno) {
        Matricula request = matriculaService.create(matricula, idAluno);

        if(request!=null) {
            URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(request.getId())
                    .toUri();
            return ResponseEntity.created(uri).body(request);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
