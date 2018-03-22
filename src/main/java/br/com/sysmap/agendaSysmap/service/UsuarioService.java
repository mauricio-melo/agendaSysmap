package br.com.sysmap.agendaSysmap.service;

import br.com.sysmap.agendaSysmap.dto.UsuarioDTO;
import br.com.sysmap.agendaSysmap.dto.response.UsuarioResponseDTO;
import br.com.sysmap.agendaSysmap.exception.ResourceNotFoundException;
import br.com.sysmap.agendaSysmap.model.Perfil;
import br.com.sysmap.agendaSysmap.model.Usuario;
import br.com.sysmap.agendaSysmap.repository.UsuarioRepository;
import br.com.sysmap.agendaSysmap.translate.UsuarioTranslator;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private EquipeService equipeService;

    @Autowired
    private UsuarioTranslator translator;

    // Serviço de criaçao
    public Usuario save(@NonNull final UsuarioDTO dto){

        // Efetuando tradução de DTO para Entity
        Usuario entity = translator.toEntity(dto);

        // Setando valores identificadores para a entity;
        entity.setEquipe(equipeService.findById(dto.getIdEquipe()));

        // Salvando no banco
        entity = repository.save(entity);

        return entity;
    }


    // Serviço de alteração
    public Usuario update(@NonNull final UsuarioDTO dto){

        // Obtendo a entity pelo id
        Usuario entity = findById(dto.getId());

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
    public Usuario findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", id));
    }

    // Serviço de listar todos
    public List<Usuario> findAll() {
        return repository.findAll();
    }


    // Serviço para encontrar usuarios por perfil
    public List<Usuario> findUsuariosPorPerfil(final Perfil perfil){
        return repository.findUsuariosPorPerfil(perfil);
    }

}
