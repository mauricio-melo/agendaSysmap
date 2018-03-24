package br.com.sysmap.agendaSysmap.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Calendar;
import java.util.Date;

@Builder
@Data
public class CompromissoDTO {

    private Long id;
    private Long idUsuario;
    private String nomeUsuario;
    private Date inicio;
    private Date termino;
    private String descricao;
    private String local;
}
