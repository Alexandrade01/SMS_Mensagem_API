package com.example.sms_mensagem_api.infraestructure.service;

import com.example.sms_mensagem_api.business.dto.SMSMessageInDTO;
import com.example.sms_mensagem_api.business.dto.SMSMessageOutDTO;
import com.example.sms_mensagem_api.business.mapper.SMSMessageMapper;
import com.example.sms_mensagem_api.infraestructure.entity.SMSMessageEntity;
import com.example.sms_mensagem_api.infraestructure.repository.SMSMessageRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SMSMessageService {

    private final SMSMessageRepository smsMessageRepository;
    private final SMSMessageMapper smsMessageMapper;

    public SMSMessageService(SMSMessageRepository smsMessageRepository, SMSMessageMapper smsMessageMapper) {
        this.smsMessageRepository = smsMessageRepository;
        this.smsMessageMapper = smsMessageMapper;
    }

    public SMSMessageOutDTO save(SMSMessageInDTO dto) {

        if(Objects.isNull(dto)){
            throw new IllegalArgumentException("DTO is null");
        }

        SMSMessageEntity entity = smsMessageMapper.toEntity(dto);
        SMSMessageEntity savedEntity = smsMessageRepository.save(entity);
        return smsMessageMapper.toOutDTO(savedEntity);
    }
}
