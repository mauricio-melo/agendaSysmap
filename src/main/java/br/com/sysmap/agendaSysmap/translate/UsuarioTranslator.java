package br.com.sysmap.agendaSysmap.translate;

import br.com.sysmap.agendaSysmap.dto.UsuarioDTO;
import br.com.sysmap.agendaSysmap.dto.request.UsuarioRequestDTO;
import br.com.sysmap.agendaSysmap.dto.response.UsuarioResponseDTO;
import br.com.sysmap.agendaSysmap.model.Usuario;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioTranslator {

    //Traduz o que veio do request para o DTO
    public UsuarioDTO toDTO(@NonNull final UsuarioRequestDTO requestDTO){
        return UsuarioDTO.builder()
                .id(requestDTO.getId())
                .nome(requestDTO.getNome())
                .perfil(requestDTO.getPerfil())
                .idEquipe(requestDTO.getIdEquipe())
                .build();
    }


    //Traduz o DTO para entity
    public Usuario toEntity(UsuarioDTO dto){
        return toEntity(dto, Usuario.builder().build());
    }


    //Traduz o DTO para a entity, recebendo um DTO e um entity por parametro
    public Usuario toEntity(UsuarioDTO dto, Usuario usuario) {
        usuario.setId(dto.getId());
        usuario.setNome(dto.getNome());
        usuario.setPerfil(dto.getPerfil());

        return usuario;

    }


    //Traduz a entity para a o response
    public UsuarioResponseDTO toResponse(@NonNull final Usuario usuario){
        return UsuarioResponseDTO.builder()
                .id(usuario.getId())
                .idEquipe(usuario.getEquipe().getId())
                .nome(usuario.getNome())
                .perfil(usuario.getPerfil())
                .build();

    }


    //Traduz uma lista de entity para uma lista de response
    public List<UsuarioResponseDTO> toResponse(List<Usuario> usuarioList){
        List<UsuarioResponseDTO> responseDTOList = new ArrayList<UsuarioResponseDTO>();
        usuarioList.forEach(usuario -> responseDTOList.add(toResponse(usuario)));

        return responseDTOList;

    }


}
