package com.alura.adopet.Adopet.controller;

import com.alura.adopet.Adopet.model.Tutor;
import com.alura.adopet.Adopet.service.TutorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/tutor")
@AllArgsConstructor
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @GetMapping
    public ResponseEntity<List<Tutor>> findAll(){
        List<Tutor> list = tutorService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public Optional<Tutor> findById(@PathVariable Long id){
        return tutorService.findById(id);
    }

    @PostMapping(value = "/tutores")
    public Tutor create(@RequestBody Tutor tutor){
        return tutorService.create(tutor);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Tutor> update(@PathVariable Long id , @RequestBody Tutor tutor) {
        tutor = tutorService.update(id, tutor);
       return ResponseEntity.ok().body(tutor);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        tutorService.delete(id);

    }
}
