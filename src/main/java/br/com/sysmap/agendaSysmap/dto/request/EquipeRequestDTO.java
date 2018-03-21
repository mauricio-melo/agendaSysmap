package br.com.sysmap.agendaSysmap.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EquipeRequestDTO {

    @ApiModelProperty(notes = "ID do equipe. ", example = "1", required = true, position = 1)
    private Long id;

    @NotNull(message = "Campo \"descricao\" precisa ser informado.")
    @ApiModelProperty(notes = "Descrição da equipe.", example = "Equipe 1", required = true, position = 2)
    private String descricao;

    @NotNull(message = "Campo \"idUsuarioLider\" precisa ser informado.")
    @ApiModelProperty(notes = "ID do usuario lider da equipe.", example = "1", required = true, position = 3)
    private Long idUsuarioLider;
}
