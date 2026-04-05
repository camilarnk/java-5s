package com.cr.registrations.services;

import com.cr.registrations.models.Aluno;
import com.cr.registrations.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno create(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> findById(Long id) {
        return alunoRepository.findById(id);
    }

    public Optional<Aluno> update(Long id, Aluno aluno) {
        Optional<Aluno> request = alunoRepository.findById(id);

        if(request.isPresent()) {
            Aluno novoAluno = request.get();

            novoAluno.setNome(aluno.getNome());
            novoAluno.setEmail(aluno.getEmail());

            return Optional.of(alunoRepository.save(novoAluno));
        }
        return Optional.empty();
    }

    public void deleteById(Long id) {
        alunoRepository.deleteById(id);
    }

}
