package com.alura.adopet.Adopet.controller;

import com.alura.adopet.Adopet.exception.ValidationException;
import com.alura.adopet.Adopet.model.Tutor;
import com.alura.adopet.Adopet.service.TutorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TutorController {

    @Autowired
    private TutorService tutorService;

    /**
     * Endpoint para buscar todos os tutores
     *
     * @return List Tutor
     */
    @GetMapping
    public ResponseEntity<List<Tutor>> findAll() {
        List<Tutor> list = tutorService.findAll();
        return ResponseEntity.ok().body(list);
    }

    /**
     * Endpoint para buscar um tutor por id
     *
     * @param id
     * @return Optional<Tutor>
     */

    @GetMapping(value = "/{id}")
    public Optional<Tutor> findById(@PathVariable Long id) {
        return tutorService.findById(id);
    }

    /**
     * Endpoint para cadastrar um tutor
     *
     * @param tutor
     * @return Tutor
     */
    @PostMapping(value = "/tutores")
    public ResponseEntity<Tutor> create(@RequestBody Tutor tutor) throws ValidationException {
        tutorService.create(tutor);
        return ResponseEntity.ok().body(tutor);
    }

    /**
     * Endpoint para atualizar um tutor
     *
     * @param id
     * @param tutor
     * @return Tutor
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<Tutor> update(@PathVariable Long id, @RequestBody Tutor tutor) {
        tutor = tutorService.update(id, tutor);
        return ResponseEntity.ok().body(tutor);
    }

    /**
     * Endpoint para deletar um Tutor
     *
     * @param id
     */

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        tutorService.delete(id);

    }
}
