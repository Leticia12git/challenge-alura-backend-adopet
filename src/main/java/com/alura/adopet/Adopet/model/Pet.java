package com.alura.adopet.Adopet.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Pet {

    private String nome;
    private String telefone;
    private String nomeDoAnimal;
    private String mensagem;

}
