package br.com.sysmap.agendaSysmap.service;

import br.com.sysmap.agendaSysmap.dto.CompromissoDTO;
import br.com.sysmap.agendaSysmap.exception.ResourceNotFoundException;
import br.com.sysmap.agendaSysmap.model.Compromisso;
import br.com.sysmap.agendaSysmap.repository.CompromissoRepository;
import br.com.sysmap.agendaSysmap.translate.CompromissoTranslator;
import lombok.NonNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompromissoService {

    @Autowired
    private CompromissoRepository repository;

    @Autowired
    private CompromissoTranslator translator;

    @Autowired
    private UsuarioService usuarioService;

    // Serviço de criaçao
    public Compromisso save(@NonNull final CompromissoDTO dto){

        // Efetuando tradução de DTO para Entity
        Compromisso entity = translator.toEntity(dto);

        // Setando valores identificadores para a entity;
        entity.setUsuario(usuarioService.findById(dto.getIdUsuario()));

        // Salvando no banco
        entity = repository.save(entity);

        return entity;
    }

    // Serviço de alteração
    public Compromisso update(@NonNull final CompromissoDTO dto){

        // Obtendo a entity pelo id
        Compromisso entity = findById(dto.getId());

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
    public Compromisso findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Compromisso", "id", id));
    }

    // Serviço de listar todos
    public List<Compromisso> findAll() {
        return repository.findAll();
    }


    // Serviço para listar compromissos por cliente
    public List<Compromisso> findCompromissoPorUsuario(final Long idUsuario){
        return repository.findCompromissoPorUsuario(idUsuario);
    }

    // Serviço para listar compromissos por equipe
    public List<Compromisso> findCompromissoPorEquipe(final Long idEquipe){
        return repository.findCompromissoPorEquipe(idEquipe);
    }

}
