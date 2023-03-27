package com.alura.adopet.Adopet.service;

import com.alura.adopet.Adopet.model.Tutor;
import com.alura.adopet.Adopet.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    /**
     * metodo para listar todos os tutores
     *
     * @return List<Tutor>
     */
    public List<Tutor> findAll() {
        return tutorRepository.findAll();
    }

    public Optional findById(Long id){
        return tutorRepository.findById(id);
    }
    public Tutor create(Tutor tutor){
        return tutorRepository.save(tutor);
    }
    public Tutor update(Tutor tutor){
        return tutorRepository.save(tutor);
    }
    public void delete(Long id){
        tutorRepository.deleteById(id);
    }
}
