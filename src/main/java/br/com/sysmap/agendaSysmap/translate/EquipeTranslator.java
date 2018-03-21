package br.com.sysmap.agendaSysmap.translate;

import br.com.sysmap.agendaSysmap.dto.EquipeDTO;
import br.com.sysmap.agendaSysmap.dto.request.EquipeRequestDTO;
import br.com.sysmap.agendaSysmap.dto.response.EquipeResponseDTO;
import br.com.sysmap.agendaSysmap.model.Equipe;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EquipeTranslator {

    //Traduz o que veio do request para o DTO
    public EquipeDTO toDTO(@NonNull final EquipeRequestDTO requestDTO){
        return EquipeDTO.builder()
                .id(requestDTO.getId())
                .descricao(requestDTO.getDescricao())
                .idUsuarioLider(requestDTO.getIdUsuarioLider())
                .build();
    }

    //Traduz o DTO para entity
    public Equipe toEntity(EquipeDTO dto){
        return toEntity(dto, Equipe.builder().build());
    }


    //Traduz o DTO para a entity, recebendo um DTO e um entity por parametro
    public Equipe toEntity(EquipeDTO dto, Equipe equipe) {
        equipe.setId(dto.getId());
        equipe.setDescricao(dto.getDescricao());

        return equipe;
    }


    //Traduz a entity para a o response
    public EquipeResponseDTO toResponse(@NonNull final Equipe equipe){
        return EquipeResponseDTO.builder()
                .id(equipe.getId())
                .descricao(equipe.getDescricao())
                .idUsuarioLider(equipe.getLider().getId())
                .build();
    }


    //Traduz uma lista de entity para uma lista de response


    public List<EquipeResponseDTO> toResponse(List<Equipe> equipeList){
        List<EquipeResponseDTO> responseDTOList = new ArrayList<EquipeResponseDTO>();
        equipeList.forEach(equipe -> responseDTOList.add(toResponse(equipe)));

        return responseDTOList;

    }
}
