package com.cr.registrations.services;

import com.cr.registrations.models.Aluno;
import com.cr.registrations.models.Matricula;
import com.cr.registrations.repositories.AlunoRepository;
import com.cr.registrations.repositories.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    public Matricula create(Matricula matricula, Long idAluno) {
        Optional<Aluno> aluno = alunoRepository.findById(idAluno);

        if(aluno.isPresent()) {
            matricula.setAluno(aluno.get());
            return matriculaRepository.save(matricula);
        }
        return null;
    }
}
