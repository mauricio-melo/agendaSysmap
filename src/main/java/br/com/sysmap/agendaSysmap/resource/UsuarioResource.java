package br.com.sysmap.agendaSysmap.resource;

import br.com.sysmap.agendaSysmap.dto.UsuarioDTO;
import br.com.sysmap.agendaSysmap.dto.request.UsuarioRequestDTO;
import br.com.sysmap.agendaSysmap.dto.response.UsuarioResponseDTO;
import br.com.sysmap.agendaSysmap.model.Perfil;
import br.com.sysmap.agendaSysmap.model.Usuario;
import br.com.sysmap.agendaSysmap.service.UsuarioService;
import br.com.sysmap.agendaSysmap.translate.UsuarioTranslator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/usuario")
@Api(value = "Usuario", description = "Operações disponíveis para o recurso usuario")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;

    @Autowired
    private UsuarioTranslator translator;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Criação de um novo recurso usuario", responseReference = "Novo recurso criado.")
    public ResponseEntity<Void> create(@Valid @RequestBody UsuarioRequestDTO requestDTO) {

        // Traduzindo a request recebida para DTO
        final UsuarioDTO usuarioDTO = translator.toDTO(requestDTO);

        // Acionando service create
        final Usuario entity = service.save(usuarioDTO);

        // Gerando novo URI criado
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity.getId())
                .toUri();

        // Retornando a responseActivity com o status created
        return ResponseEntity.created(uri).build();
    }


    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Atualização de um recurso usuario", responseReference = "200 = Recurso atualizado com sucesso.")
    public ResponseEntity<Void> update(@Valid @RequestBody final UsuarioRequestDTO requestDTO) {

        //Traduzindo requisição recebida para DTO
        final UsuarioDTO usuarioDTO = translator.toDTO(requestDTO);

        //Acionando service update
        final Usuario entity = service.update(usuarioDTO);

        //retornando a responseActivity com o status ok
        return ResponseEntity.ok().build();
    }



    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Pesquisa em especifico de um recurso usuario", response = UsuarioResponseDTO.class)
    public ResponseEntity<UsuarioResponseDTO> findById(@PathVariable final Long id) {

        //Efetuando busca da entidade na base dados pelo id
        final Usuario entity = service.findById(id);

        //Traduzindo Entity para Response
        final UsuarioResponseDTO responseDTO = translator.toResponse(entity);

        //Retornando a responseEntity com o response com o status ok
        return ResponseEntity.ok(responseDTO);
    }


    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Lista todos os usuarios", response = UsuarioResponseDTO.class, responseContainer = "List")
    public ResponseEntity<List<UsuarioResponseDTO>> list() {

        //Buscando todos os recursos
        final List<Usuario> entityList = service.findAll();

        //Traduzindo entity para response
        final List<UsuarioResponseDTO> responseList = translator.toResponse(entityList);

        //Retornando a responseEntity com o response com status ok
        return ResponseEntity.ok(responseList);
    }


    @DeleteMapping("{id}")
    @ApiOperation(value = "Delete de um recurso usuario", responseReference = "Recurso excluído.")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {

        // Acionando service delete
        service.delete(id);

        // Retornando a responseEntity com o response com status ok
        return ResponseEntity.ok().build();
    }

    // --------------------------------------------------------------


    @GetMapping(path = "/perfil/{perfil}", produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Lista todos os usuarios com determinado perfil", response = UsuarioResponseDTO.class, responseContainer = "List")
    public ResponseEntity<List<UsuarioResponseDTO>> findUsuariosPorPerfil(
            @PathVariable final String perfil) {

        //Buscando todos os recursos
        final List<Usuario> entityList = service.findUsuariosPorPerfil(Perfil.fromCode(perfil));

        //Traduzindo entity para response
        final List<UsuarioResponseDTO> responseList = translator.toResponse(entityList);

        return ResponseEntity.ok(responseList);
    }


}

