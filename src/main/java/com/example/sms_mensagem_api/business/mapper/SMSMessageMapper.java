package com.example.sms_mensagem_api.business.mapper;

import com.example.sms_mensagem_api.business.dto.SMSMessageInDTO;
import com.example.sms_mensagem_api.business.dto.SMSMessageOutDTO;
import com.example.sms_mensagem_api.infraestructure.entity.SMSMessageEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SMSMessageMapper {

    SMSMessageEntity  toEntity(SMSMessageInDTO dto);

    SMSMessageOutDTO toOutDTO(SMSMessageEntity entity);

}
