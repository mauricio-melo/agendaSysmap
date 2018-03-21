package br.com.sysmap.agendaSysmap.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EquipeResponseDTO {

    @ApiModelProperty(notes = "ID da equipe.", example = "1", required = true, position = 0)
    private Long id;

    @ApiModelProperty(notes = "Descrição da equipe.", example = "1", required = true, position = 1)
    private String descricao;

    @ApiModelProperty(notes = "ID do usuario lider da equipe.", example = "1", required = true, position = 2)
    private Long idUsuarioLider;

}
