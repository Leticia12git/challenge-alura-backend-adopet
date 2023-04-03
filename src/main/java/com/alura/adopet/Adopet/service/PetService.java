package com.alura.adopet.Adopet.service;

import com.alura.adopet.Adopet.exception.ValidationException;
import com.alura.adopet.Adopet.model.Pet;
import com.alura.adopet.Adopet.model.Tutor;
import com.alura.adopet.Adopet.repository.PetRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    /**
     * metodo para listar todos os pets
     *
     * @return List<Abrigo>
     */
    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    /**
     * metodo para buscar um pet por id
     *
     * @param id
     * @return Optional
     */
    public Optional<Pet> findById(Long id)  {
        return petRepository.findById(id);
    }

    /**
     * metodo para cadastrar um pet
     *
     * @param pet
     * @return
     */

    @Transactional()
    public Pet create( Pet pet) throws ValidationException {
        return petRepository.save(pet);

    }

    /**
     * metodo para atualizar um pet
     *
     * @param pet
     * @return
     */
    public Pet update(Long id, Pet pet) {
        Pet entity = petRepository.findById(id).get();
        updateData(entity, pet);
        return petRepository.save(entity);
    }

    private void updateData(Pet entity, Pet pet) {
        entity.setNome(pet.getNome());
        entity.setEmail(pet.getEmail());
        entity.setSenha(pet.getSenha());
    }

    /**
     * metodo para deletar um tutor
     *
     * @param id
     */
    public void delete(Long id) {
        petRepository.deleteById(id);
    }
}
