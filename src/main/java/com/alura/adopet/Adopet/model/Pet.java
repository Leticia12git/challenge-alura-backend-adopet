package com.alura.adopet.Adopet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Pet {

    private String nome;
    private String telefone;
    private String nomeDoAnimal;
    private String mensagem;

    @OneToMany(mappedBy = "")
    private List<Pet> pets = new ArrayList<>();


}
