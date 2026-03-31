package com.cr.animal.controller;

import com.cr.animal.models.AnimalModel;
import com.cr.animal.services.AnimalService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @PostMapping
    public ResponseEntity<AnimalModel> save(@RequestBody AnimalModel animalModel) {
        AnimalModel animal = animalService.save(animalModel);;
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(animal.getId()).toUri();
        return ResponseEntity.created(uri).body(animal);
    }

    @GetMapping
    public ResponseEntity<List<AnimalModel>> findAll() {
        List<AnimalModel> animal = animalService.findAll();
        return ResponseEntity.ok().body(animal);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AnimalModel>> findById(@PathVariable Long id) {
        Optional<AnimalModel> animal = animalService.findById(id);
        return ResponseEntity.ok().body(animal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimalModel> update(@RequestBody AnimalModel animalModel, @PathVariable Long id) {
        AnimalModel animal = animalService.update(animalModel, id);
        return ResponseEntity.ok().body(animal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        animalService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
