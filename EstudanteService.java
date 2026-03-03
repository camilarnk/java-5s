package com.bn.school.services;

import com.bn.school.models.EstudanteModel;
import com.bn.school.repositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // sempre colocar anotaçao service em classes /Service
public class EstudanteService {

    @Autowired // injeçao de dependencia
    private EstudanteRepository estudanteRepository;

    public List<EstudanteModel> findAll() {
        return estudanteRepository.findAll(); // busca tudo presente no banco
    }

    public EstudanteModel criarEstudante(EstudanteModel estudanteModel) { // necessario passar o parametro a ser salvo
        return estudanteRepository.save(estudanteModel); // salvar o model no banco
    }

    public void deletarEstudante(Long id) { // receber o id para nao precisar passar a entidade inteira
        estudanteRepository.deleteById(id); // deletar o model do banco
    }

}
