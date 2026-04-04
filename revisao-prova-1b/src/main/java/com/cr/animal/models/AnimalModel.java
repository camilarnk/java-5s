package com.cr.animal.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AnimalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String animalType;
    private String animalBreed;

}
