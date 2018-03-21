package br.com.sysmap.agendaSysmap.dto;

import br.com.sysmap.agendaSysmap.model.Perfil;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UsuarioDTO {

    private Long id;
    private String nome;
    private Perfil perfil;
    private Long idEquipe;
}
