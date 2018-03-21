package br.com.sysmap.agendaSysmap.service;

import br.com.sysmap.agendaSysmap.dto.EquipeDTO;
import br.com.sysmap.agendaSysmap.exception.ResourceNotFoundException;
import br.com.sysmap.agendaSysmap.model.Equipe;
import br.com.sysmap.agendaSysmap.repository.EquipeRepository;
import br.com.sysmap.agendaSysmap.translate.EquipeTranslator;
import lombok.NonNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeService {

    @Autowired
    private EquipeRepository repository;

    @Autowired
    private EquipeTranslator translator;

    @Autowired
    private UsuarioService usuarioService;

    // Serviço de criaçao
    public Equipe save(@NonNull final EquipeDTO dto){

        // Efetuando tradução de DTO para Entity
        Equipe entity = translator.toEntity(dto);

        // Setando valores identificadores para a entity;
        entity.setLider(usuarioService.findById(dto.getIdUsuarioLider()));

        // Salvando no banco
        entity = repository.save(entity);

        return entity;
    }

    // Serviço de alteração
    public Equipe update(@NonNull final EquipeDTO dto){

        // Obtendo a entity pelo id
        Equipe entity = findById(dto.getId());

        // Traduzindo DTO para Entity
        entity = translator.toEntity(dto, entity);

        // Salvando no banco
        entity = repository.save(entity);

        return entity;
    }


    // Serviço de delete por id
    public void delete(Long id){
        repository.deleteById(id);
    }

    // Serviço de encontrar por id
    public Equipe findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipe", "id", id));
    }

    // Serviço de listar todos
    public List<Equipe> findAll() {
        return repository.findAll();
    }

}
