package br.com.sysmap.agendaSysmap.resource;

import br.com.sysmap.agendaSysmap.dto.CompromissoDTO;
import br.com.sysmap.agendaSysmap.dto.request.CompromissoRequestDTO;
import br.com.sysmap.agendaSysmap.dto.response.CompromissoResponseDTO;
import br.com.sysmap.agendaSysmap.model.Compromisso;
import br.com.sysmap.agendaSysmap.service.CompromissoService;
import br.com.sysmap.agendaSysmap.translate.CompromissoTranslator;
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
@RequestMapping(value = "/api/compromisso")
@Api(value = "Compromisso", description = "Operações disponíveis para o recurso compromisso")
public class CompromissoResource {

    @Autowired
    private CompromissoService service;

    @Autowired
    private CompromissoTranslator translator;


    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Criação de um novo recurso compromisso", responseReference = "Novo recurso criado.")
    public ResponseEntity<Void> create(@Valid @RequestBody CompromissoRequestDTO requestDTO) {

        // Traduzindo a request recebida para DTO
        final CompromissoDTO compromissoDTO = translator.toDTO(requestDTO);

        // Acionando service create
        final Compromisso entity = service.save(compromissoDTO);

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
    @ApiOperation(value = "Atualização de um recurso compromisso", responseReference = "200 = Recurso atualizado com sucesso.")
    public ResponseEntity<Void> update(@Valid @RequestBody final CompromissoRequestDTO requestDTO) {

        //Traduzindo requisição recebida para DTO
        final CompromissoDTO compromissoDTO = translator.toDTO(requestDTO);

        //Acionando service update
        final Compromisso entity = service.update(compromissoDTO);

        //retornando a responseActivity com o status ok
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Pesquisa em especifico de um recurso compromisso", response = CompromissoResponseDTO.class)
    public ResponseEntity<CompromissoResponseDTO> findById(@PathVariable final Long id) {

        //Efetuando busca da entidade na base dados pelo id
        final Compromisso entity = service.findById(id);

        //Traduzindo Entity para Response
        final CompromissoResponseDTO responseDTO = translator.toResponse(entity);

        //Retornando a responseEntity com o response com o status ok
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Lista todos os compromissos", response = CompromissoResponseDTO.class, responseContainer = "List")
    public ResponseEntity<List<CompromissoResponseDTO>> list() {

        //Buscando todos os recursos
        final List<Compromisso> entityList = service.findAll();

        //Traduzindo entity para response
        final List<CompromissoResponseDTO> responseList = translator.toResponse(entityList);

        //Retornando a responseEntity com o response com status ok
        return ResponseEntity.ok(responseList);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Delete de um recurso compromisso", responseReference = "Recurso excluído.")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        // Acionando service delete
        service.delete(id);

        // Retornando a responseEntity com o response com status ok
        return ResponseEntity.ok().build();
    }


}