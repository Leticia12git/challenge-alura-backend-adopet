package com.alura.adopet.Adopet.service;

import com.alura.adopet.Adopet.exception.ValidationException;
import com.alura.adopet.Adopet.model.Abrigo;
import com.alura.adopet.Adopet.repository.AbrigoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AbrigoService {

    @Autowired
    private AbrigoRepository abrigoRepository;

    /**
     * metodo para listar todos os abrigos
     *
     * @return List<Abrigo>
     */
    public List<Abrigo> findAll() {
        return abrigoRepository.findAll();
    }

    /**
     * metodo para buscar um abrigo po id
     *
     * @param id
     * @return Optional
     */
    public Optional<Abrigo> findById(Long id)  {
        return abrigoRepository.findById(id);
    }

    /**
     * metodo para cadastrar um abrigo
     *
     * @param abrigo
     * @return
     */

    @Transactional()
    public Abrigo create( Abrigo abrigo) throws ValidationException {
        return abrigoRepository.save(abrigo);

    }

    /**
     * metodo para atualizar um abrigo
     *
     * @param abrigo
     * @return
     */
    public Abrigo update(Long id, Abrigo abrigo) {
        Abrigo entity = abrigoRepository.findById(id).get();
        updateData(entity, abrigo);
        return abrigoRepository.save(entity);
    }

    private void updateData(Abrigo entity, Abrigo abrigo) {
        entity.setNome(abrigo.getNome());
        entity.setEmail(abrigo.getEmail());
        entity.setSenha(abrigo.getSenha());
    }

    /**
     * metodo para deletar um abrigo
     *
     * @param id
     */
    public void delete(Long id) {
        abrigoRepository.deleteById(id);
    }
}
