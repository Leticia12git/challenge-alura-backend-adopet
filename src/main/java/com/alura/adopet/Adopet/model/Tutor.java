package com.alura.adopet.Adopet.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tutores")
public class Tutor implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "O Campo nome é obrigatório")
    private String nome;
    @NotEmpty(message = "O Campo email é obrigatório")
    private String email;
    @NotEmpty(message = "O Campo senha é obrigatório")
    private String senha;
}
