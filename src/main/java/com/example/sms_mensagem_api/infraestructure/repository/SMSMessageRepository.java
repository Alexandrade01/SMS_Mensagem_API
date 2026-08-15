package com.example.sms_mensagem_api.infraestructure.repository;

import com.example.sms_mensagem_api.infraestructure.entity.SMSMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SMSMessageRepository extends JpaRepository<SMSMessageEntity, Long> {



}
