package com.alura.adopet.Adopet.controller;

import com.alura.adopet.Adopet.exception.ValidationException;
import com.alura.adopet.Adopet.model.Abrigo;
import com.alura.adopet.Adopet.service.AbrigoService;
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
@RequestMapping(value = "/abrigos")
@AllArgsConstructor
public class AbrigoController {

    @Autowired
    private AbrigoService abrigoService;

    /**
     * Endpoint para buscar todos os tutores
     *
     * @return List Tutor
     */
    @GetMapping
    public ResponseEntity<List<Abrigo>> findAll() {
        List<Abrigo> list = abrigoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    /**
     * Endpoint para buscar um tutor por id
     *
     * @param id
     * @return Optional<Tutor>
     */

    @GetMapping(value = "/{id}")
    public Optional<Abrigo> findById(@PathVariable Long id) {
        return abrigoService.findById(id);
    }

    /**
     * Endpoint para cadastrar um tutor
     *
     * @param abrigo
     * @return Abrigo
     */
    @PostMapping(value = "/tutores")
    public ResponseEntity<Abrigo> create(@RequestBody Abrigo abrigo) throws ValidationException {
        abrigoService.create(abrigo);
        return ResponseEntity.ok().body(abrigo);
    }

    /**
     * Endpoint para atualizar um abrigo
     *
     * @param id
     * @param abrigo
     * @return Abrigo
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<Abrigo> update(@PathVariable Long id, @RequestBody Abrigo abrigo) {
        abrigo = abrigoService.update(id, abrigo);
        return ResponseEntity.ok().body(abrigo);
    }

    /**
     * Endpoint para deletar um Abrigo
     *
     * @param id
     */

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        abrigoService.delete(id);

    }
}
