package com.alura.adopet.Adopet.service;

import com.alura.adopet.Adopet.model.Tutor;
import com.alura.adopet.Adopet.repository.TutorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
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

    /**
     * metodo para buscar um tutor po id
     *
     * @param id
     * @return Optional
     */
    public Optional<Tutor> findById(Long id)  {
        return tutorRepository.findById(id);
    }

    /**
     * metodo para cadastrar um tutor
     *
     * @param tutor
     * @return
     */

    @Transactional()
    public Tutor create( Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    /**
     * metodo para atualizar um tutor
     *
     * @param tutor
     * @return
     */
    public Tutor update(Long id, Tutor tutor) {
        Tutor entity = tutorRepository.findById(id).get();
        updateData(entity, tutor);
        return tutorRepository.save(entity);
    }

    private void updateData(Tutor entity, Tutor tutor) {
        entity.setNome(tutor.getNome());
        entity.setEmail(tutor.getEmail());
        entity.setSenha(tutor.getSenha());
    }

    /**
     * metodo para deletar um tutor
     *
     * @param id
     */
    public void delete(Long id) {
        tutorRepository.deleteById(id);
    }
}
