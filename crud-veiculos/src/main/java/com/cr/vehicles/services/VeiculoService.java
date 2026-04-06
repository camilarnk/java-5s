package com.cr.vehicles.services;

import com.cr.vehicles.models.Veiculo;
import com.cr.vehicles.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo create(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    public Optional<Veiculo> findById(Long id) {
        return veiculoRepository.findById(id);
    }

    public Optional<Veiculo> update(Long id, Veiculo veiculo) {
        Optional<Veiculo> request = veiculoRepository.findById(id);

        if(request.isPresent()) {
            Veiculo novoVeiculo = request.get();

            novoVeiculo.setAno(veiculo.getAno());
            novoVeiculo.setMarca(veiculo.getMarca());
            novoVeiculo.setModelo(veiculo.getModelo());
            novoVeiculo.setPreco(veiculo.getPreco());
            novoVeiculo.setStatus(veiculo.getStatus());

            return Optional.of(veiculoRepository.save(novoVeiculo));
        }
        return Optional.empty();
    }

    public void deleteByid(Long id) {
        veiculoRepository.deleteById(id);
    }
}
