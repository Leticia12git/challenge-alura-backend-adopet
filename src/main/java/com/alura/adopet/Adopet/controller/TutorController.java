package com.alura.adopet.Adopet.controller;

import com.alura.adopet.Adopet.model.Tutor;
import com.alura.adopet.Adopet.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tutores")
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @GetMapping
    public ResponseEntity<List<Tutor>> findAll(){
        tutorService.findAll();
        return ResponseEntity.of(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Tutor> findById(@PathVariable Long id){
        tutorService.findById(id);
        return ResponseEntity.ok().body(id);
    }

    @PostMapping(value = "/tutores")
    public ResponseEntity<Tutor> create(@RequestBody Tutor tutor){
        return tutorService.save(tutor);
    }

    @PutMapping
    public ResponseEntity<Tutor> update@PathVariable Long id,@RequestBody Tutor tutor){
        return tutorService.update(tutor);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        tutorService.deleteById(id);
    }
}
