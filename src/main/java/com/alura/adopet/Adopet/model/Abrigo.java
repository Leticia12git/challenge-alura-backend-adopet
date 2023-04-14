package com.alura.adopet.Adopet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Abrigo {

    private String urlImage;
    private String nome;
    private String telefone;
    private String cidade;
    private String sobre;

    @ManyToOne()
    private Abrigo = new Abrigo();



}
