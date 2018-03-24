package br.com.sysmap.agendaSysmap.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Calendar;
import java.util.Date;

@Builder
@Data
public class CompromissoResponseDTO {

    @ApiModelProperty(notes = "ID do compromisso.", example = "1", required = true, position = 0)
    private Long id;

    @ApiModelProperty(notes = "ID do usuario dono do compromisso.", example = "1", required = true, position = 1)
    private Long idUsuario;

    @ApiModelProperty(notes = "Nome do usuario dono do compromisso.", example = "Lionel Messi", required = true, position = 2)
    private String nomeUsuario;

    @ApiModelProperty(notes = "Data e hora de inicio do compromisso.", example = "2016-10-24 11:34:49", required = true, position = 3)
    private Date inicio;

    @ApiModelProperty(notes = "Data e hora de termino do compromisso.", example = "2016-10-24 13:34:49", required = true, position = 4)
    private Date termino;

    @ApiModelProperty(notes = "Descrição do compromisso", example = "Reunião para alinhar o aporte financeiro do Itaú", required = true, position = 5)
    private String descricao;

    @ApiModelProperty(notes = "Local do compromisso", example = "Sala 08", required = true, position = 6)
    private String local;
}
