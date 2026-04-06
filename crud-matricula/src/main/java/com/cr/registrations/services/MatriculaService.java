package com.cr.registrations.services;

import com.cr.registrations.models.Aluno;
import com.cr.registrations.models.Matricula;
import com.cr.registrations.repositories.AlunoRepository;
import com.cr.registrations.repositories.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Matricula> findAll() {
        return matriculaRepository.findAll();
    }

    public Optional<Matricula> findById(Long id) {
        return matriculaRepository.findById(id);
    }

    public Optional<Matricula> update(Long id, Matricula matricula) {
        Optional<Matricula> request = matriculaRepository.findById(id);

        if(request.isPresent()) {
            Matricula novaMatricula = request.get();

            novaMatricula.setCurso(matricula.getCurso());
            novaMatricula.setDataMatricula(matricula.getDataMatricula());
            novaMatricula.setStatus(matricula.getStatus());
            novaMatricula.setAluno(matricula.getAluno());

            return Optional.of(matriculaRepository.save(novaMatricula));
        }
        return Optional.empty();
    }

    public void delete(Long id){
        matriculaRepository.deleteById(id);
    }

}
