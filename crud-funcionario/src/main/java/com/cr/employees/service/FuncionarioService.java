package com.cr.employees.service;

import com.cr.employees.models.Funcionario;
import com.cr.employees.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario create(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> findById(Long id) {
        return funcionarioRepository.findById(id);
    }

    public Optional<Funcionario> update(Long id, Funcionario funcionario) {
        Optional<Funcionario> request = funcionarioRepository.findById(id);

        if(request.isPresent()) {
            Funcionario novoFunc = request.get();

            novoFunc.setNome(funcionario.getNome());
            novoFunc.setCargo(funcionario.getCargo());
            novoFunc.setSalario(funcionario.getSalario());
            novoFunc.setStatus(funcionario.getStatus());

            return Optional.of(funcionarioRepository.save(novoFunc));
        }

        return Optional.empty();
    }

    public void deleteById(Long id) {
        funcionarioRepository.deleteById(id);
    }

}
