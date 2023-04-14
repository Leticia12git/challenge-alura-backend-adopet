package com.alura.adopet.Adopet.controller;

import com.alura.adopet.Adopet.exception.ValidationException;
import com.alura.adopet.Adopet.model.Pet;
import com.alura.adopet.Adopet.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Endpoints relacionados ao Tutor
 */

@RestController
@RequestMapping(value = "/tutor")
@AllArgsConstructor
public class PetController {

    @Autowired
    private PetService petService;


    /**
     * Endpoint para buscar todos os tutores
     *
     * @return List Tutor
     */
    @GetMapping
    public ResponseEntity<Page<Pet>> findAll(Pageable pageable) {
        return ResponseEntity.ok(petService.findAll(pageable)) ;

    }

    /**
     * Endpoint para buscar um tutor por id
     *
     * @param id
     * @return Optional<Tutor>
     */

    @GetMapping(value = "/{id}")
    public Optional<Pet> findById(@PathVariable Long id) {
        return petService.findById(id);
    }

    /**
     * Endpoint para cadastrar um tutor
     *
     * @param pet
     * @return Abrigo
     */
    @PostMapping(value = "/tutores")
    public ResponseEntity<Pet> create(@RequestBody Pet pet) throws ValidationException {
        petService.create(pet);
        return ResponseEntity.ok().body(pet);
    }

    /**
     * Endpoint para atualizar um tutor
     *
     * @param id
     * @param pet
     * @return Pet
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<Pet> update(@PathVariable Long id, @RequestBody Pet pet) {
        pet = petService.update(id, pet);
        return ResponseEntity.ok().body(pet);
    }

    /**
     * Endpoint para deletar um Pet
     *
     * @param id
     */

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        petService.delete(id);

    }
}
