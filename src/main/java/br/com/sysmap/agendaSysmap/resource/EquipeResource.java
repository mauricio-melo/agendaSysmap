package br.com.sysmap.agendaSysmap.resource;

import br.com.sysmap.agendaSysmap.dto.EquipeDTO;
import br.com.sysmap.agendaSysmap.dto.request.EquipeRequestDTO;
import br.com.sysmap.agendaSysmap.dto.response.EquipeResponseDTO;
import br.com.sysmap.agendaSysmap.model.Equipe;
import br.com.sysmap.agendaSysmap.service.EquipeService;

import br.com.sysmap.agendaSysmap.translate.EquipeTranslator;
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
@RequestMapping(value = "/api/equipe")
@Api(value = "Equipe", description = "Operações disponíveis para o recurso equipe")
public class EquipeResource {

    @Autowired
    private EquipeService service;

    @Autowired
    private EquipeTranslator translator;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Criação de um novo recurso equipe", responseReference = "Novo recurso criado.")
    public ResponseEntity<Void> create(@Valid @RequestBody EquipeRequestDTO requestDTO) {

        // Traduzindo a request recebida para DTO
        final EquipeDTO equipeDTO = translator.toDTO(requestDTO);

        // Acionando service create
        final Equipe entity = service.save(equipeDTO);

        // Gerando novo URI criado
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity.getId())
                .toUri();

        // Retornando a responseActivity com o status created
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Atualização de um recurso equipe", responseReference = "200 = Recurso atualizado com sucesso.")
    public ResponseEntity<Void> update(@Valid @RequestBody final EquipeRequestDTO requestDTO) {

        //Traduzindo requisição recebida para DTO
        final EquipeDTO equipeDTO = translator.toDTO(requestDTO);

        //Acionando service update
        final Equipe entity = service.update(equipeDTO);

        //retornando a responseActivity com o status ok
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Pesquisa em especifico de um recurso equipe", response = EquipeResponseDTO.class)
    public ResponseEntity<EquipeResponseDTO> findById(@PathVariable final Long id) {

        //Efetuando busca da entidade na base dados pelo id
        final Equipe entity = service.findById(id);

        //Traduzindo Entity para Response
        final EquipeResponseDTO responseDTO = translator.toResponse(entity);

        //Retornando a responseEntity com o response com o status ok
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Lista todos as equipes", response = EquipeResponseDTO.class, responseContainer = "List")
    public ResponseEntity<List<EquipeResponseDTO>> list() {

        //Buscando todos os recursos
        final List<Equipe> entityList = service.findAll();

        //Traduzindo entity para response
        final List<EquipeResponseDTO> responseList = translator.toResponse(entityList);

        //Retornando a responseEntity com o response com status ok
        return ResponseEntity.ok(responseList);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Delete de um recurso equipe", responseReference = "Recurso excluído.")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        // Acionando service delete
        service.delete(id);

        // Retornando a responseEntity com o response com status ok
        return ResponseEntity.ok().build();
    }


}