package com.example.sms_mensagem_api.infraestructure.service;

import com.example.sms_mensagem_api.business.dto.SMSMessageInDTO;
import com.example.sms_mensagem_api.business.dto.SMSMessageOutDTO;
import com.example.sms_mensagem_api.business.mapper.SMSMessageMapper;
import com.example.sms_mensagem_api.infraestructure.entity.SMSMessageEntity;
import com.example.sms_mensagem_api.infraestructure.enums.StatusEnum;
import com.example.sms_mensagem_api.infraestructure.repository.SMSMessageRepository;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
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

        if(Objects.isNull(dto)) {
            throw new IllegalArgumentException("Os dados recebidos são nulos");
        }

        if(!smsMessageRepository.findByPhoneNumber(dto.getPhoneNumber()).isEmpty()){
            throw new IllegalArgumentException("Número de telefone já existe");
        }

        dto.setSentAt(LocalDateTime.now());

        SMSMessageEntity entity = smsMessageMapper.toEntity(dto);
        SMSMessageEntity savedEntity = smsMessageRepository.save(entity);
        return smsMessageMapper.toOutDTO(savedEntity);
    }

    public SMSMessageOutDTO updateStatus(SMSMessageInDTO dto) {

        if(!StatusEnum.validStatus(dto.getStatus())) {
            throw new IllegalArgumentException("Status inválido");
        }

        SMSMessageEntity entity = smsMessageRepository.findByPhoneNumber(dto.getPhoneNumber()).stream().findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Número de telefone não encontrado"));

        entity.setStatus(dto.getStatus());
        entity.setSentAt(LocalDateTime.now());

        SMSMessageEntity savedEntity = smsMessageRepository.save(entity);

        return smsMessageMapper.toOutDTO(savedEntity);
    }

    public List<SMSMessageOutDTO> findByStatusAndTimeAfter24hours(StatusEnum status) {

        if(!StatusEnum.validStatus(status)) {
            throw new IllegalArgumentException("Status inválido");
        }

        LocalDateTime last24hours =  LocalDateTime.now().minusHours(24);

        List<SMSMessageEntity> entities = smsMessageRepository.findByStatusLast24Hours(status, last24hours);

        return entities.stream()
                .map(smsMessageMapper::toOutDTO)
                .toList();

    }
}
