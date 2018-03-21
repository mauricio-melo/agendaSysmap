package br.com.sysmap.agendaSysmap.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EquipeDTO {

    private Long id;
    private String descricao;
    private Long idUsuarioLider;

}
