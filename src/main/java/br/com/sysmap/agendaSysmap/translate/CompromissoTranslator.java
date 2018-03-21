package br.com.sysmap.agendaSysmap.translate;


import br.com.sysmap.agendaSysmap.dto.CompromissoDTO;
import br.com.sysmap.agendaSysmap.dto.request.CompromissoRequestDTO;
import br.com.sysmap.agendaSysmap.dto.response.CompromissoResponseDTO;
import br.com.sysmap.agendaSysmap.model.Compromisso;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class CompromissoTranslator {

    //Traduz o que veio do request para o DTO
    public CompromissoDTO toDTO(@NonNull final CompromissoRequestDTO requestDTO){
        return CompromissoDTO.builder()
                .id(requestDTO.getId())
                .idUsuario(requestDTO.getIdUsuario())
                .inicio(requestDTO.getInicio())
                .termino(requestDTO.getTermino())
                .descricao(requestDTO.getDescricao())
                .local(requestDTO.getLocal())
                .build();
    }

    //Traduz o DTO para entity
    public Compromisso toEntity(CompromissoDTO dto){
        return toEntity(dto, Compromisso.builder().build());
    }


    //Traduz o DTO para a entity, recebendo um DTO e um entity por parametro
    public Compromisso toEntity(CompromissoDTO dto, Compromisso compromisso) {
        compromisso.setId(dto.getId());
        compromisso.setInicio(dto.getInicio());
        compromisso.setTermino(dto.getTermino());
        compromisso.setDescricao(dto.getDescricao());
        compromisso.setLocal(dto.getDescricao());

        return compromisso;
    }

    //Traduz a entity para a o response
    public CompromissoResponseDTO toResponse(@NonNull final Compromisso compromisso){
        return CompromissoResponseDTO.builder()
                .id(compromisso.getId())
                .idUsuario(compromisso.getUsuario().getId())
                .inicio(compromisso.getInicio())
                .termino(compromisso.getTermino())
                .descricao(compromisso.getDescricao())
                .local(compromisso.getLocal())
                .build();

    }


    //Traduz uma lista de entity para uma lista de response
    public List<CompromissoResponseDTO> toResponse(List<Compromisso> compromissoList){
        List<CompromissoResponseDTO> responseDTOList = new ArrayList<CompromissoResponseDTO>();
        compromissoList.forEach(compromisso -> responseDTOList.add(toResponse(compromisso)));

        return responseDTOList;

    }

}
