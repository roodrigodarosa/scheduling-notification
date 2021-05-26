package com.luizalabs.agendamento.controller.converter;

import java.util.ArrayList;
import java.util.List;

import com.luizalabs.agendamento.controller.builder.SchedulingBuilder;
import com.luizalabs.agendamento.controller.builder.SchedulingDTOBuilder;
import com.luizalabs.agendamento.controller.dto.SchedulingDTO;
import com.luizalabs.agendamento.domain.Scheduling;
import com.luizalabs.agendamento.enums.RecipientTypeEnum;
import com.luizalabs.agendamento.exception.SchedulingBadRequestException;

public class SchedulingConverter {

    public static Scheduling dtoToEntity(SchedulingDTO dto) throws SchedulingBadRequestException {
        return SchedulingBuilder.of()
                .id(dto.getId())
                .dateToSend(dto.getDateToSend())
                .recipient(dto.getRecipient())
                .recipientType(converterRecipientType(dto.getRecipientType()))
                .message(dto.getMessage())
                .build();
    }

    public static SchedulingDTO entityToDto(Scheduling scheduling) {
        return SchedulingDTOBuilder.of()
                .id(scheduling.getId())
                .dateToSend(scheduling.getDateToSend())
                .recipient(scheduling.getRecipient())
                .recipientType(scheduling.getRecipientType() != null ? scheduling.getRecipientType().name() : null)
                .status(scheduling.getStatus() != null ? scheduling.getStatus().name() : null)
                .message(scheduling.getMessage())
                .build();
    }

    public static List<SchedulingDTO> entityListToDtoList(List<Scheduling> schedulingList) {
        List<SchedulingDTO> listDTO = new ArrayList<>();
        if (schedulingList != null) {
            schedulingList.forEach(scheduling ->
                    listDTO.add(entityToDto(scheduling)));
        }
        return listDTO;
    }


    private static RecipientTypeEnum converterRecipientType(String type) throws SchedulingBadRequestException {
        try {
            return RecipientTypeEnum.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new SchedulingBadRequestException("Tipo de destinatário inválido: " + type);
        }
    }
}
