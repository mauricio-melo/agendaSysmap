package br.com.sysmap.agendaSysmap.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class    CompromissoRequestDTO {

    @ApiModelProperty(notes = "ID do compromisso. ", example = "1", required = true, position = 1)
    private Long id;

    @NotNull(message = "Campo \"idUsuario\" precisa ser informado.")
    @ApiModelProperty(notes = "ID do usuario dono do compromisso.", example = "1", required = true, position = 2)
    private Long idUsuario;

    @NotNull(message = "Campo \"inicio\" precisa ser informado.")
    @ApiModelProperty(notes = "Data e hora de inicio do compromisso.", example = "2016-10-24", required = true, position = 3)
    private Date inicio;

    @NotNull(message = "Campo \"temrino\" precisa ser informado.")
    @ApiModelProperty(notes = "Data e hora de termino do compromisso.", example = "2016-10-24", required = true, position = 4)
    private Date termino;

    @NotNull(message = "Campo \"descricao\" precisa ser informado.")
    @ApiModelProperty(notes = "Descrição do compromisso", example = "Reunião para alinhar o aporte financeiro do Itaú", required = true, position = 5)
    private String descricao;

    @NotNull(message = "Campo \"local\" precisa ser informado.")
    @ApiModelProperty(notes = "Local do compromisso", example = "Sala 08", required = true, position = 6)
    private String local;
}
