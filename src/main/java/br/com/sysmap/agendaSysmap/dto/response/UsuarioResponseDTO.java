package br.com.sysmap.agendaSysmap.dto.response;

import br.com.sysmap.agendaSysmap.model.Perfil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioResponseDTO {

    @ApiModelProperty(notes = "ID do usuario.", example = "1", required = true, position = 1)
    private Long id;

    @ApiModelProperty(notes = "Nome do usuario.", example = "Jose da Silva", required = true, position = 2)
    private String nome;

    @ApiModelProperty(notes = "Perfil do usuario.", example = "DESENVOLVEDOR", required = true, position = 3)
    private Perfil perfil;

    @ApiModelProperty(notes = "ID da equipe que o usuario pertence.", required = true, example = "1", position = 4)
    private Long idEquipe;

}
