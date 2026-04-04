package com.cr.animal.services;

import com.cr.animal.models.AnimalModel;
import com.cr.animal.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public AnimalModel save(AnimalModel animalModel) {
        return animalRepository.save(animalModel);
    }

    public List<AnimalModel> findAll() {
        return animalRepository.findAll();
    }

    public Optional<AnimalModel> findById(Long id) {
        return animalRepository.findById(id);
    }

    public AnimalModel update(AnimalModel animalModel, Long id) {
        AnimalModel response = animalRepository.findById(id).get();

        response.setNome(animalModel.getNome());
        response.setAnimalType(animalModel.getAnimalType());

        return animalRepository.save(response);
    }

    public void deleteById(Long id) {
        animalRepository.deleteById(id);
    }

}
