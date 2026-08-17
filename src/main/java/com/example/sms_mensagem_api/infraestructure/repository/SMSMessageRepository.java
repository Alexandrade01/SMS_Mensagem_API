package com.example.sms_mensagem_api.infraestructure.repository;

import com.example.sms_mensagem_api.infraestructure.entity.SMSMessageEntity;
import com.example.sms_mensagem_api.infraestructure.enums.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface SMSMessageRepository extends JpaRepository<SMSMessageEntity, Long> {

    List<SMSMessageEntity> findByPhoneNumber(String phoneNumber);

    @Query("SELECT s FROM SMSMessageEntity s WHERE s.status = :status AND s.sentAt >= :sentAt")
    List<SMSMessageEntity> findByStatusLast24Hours(@Param("status") StatusEnum status, @Param("sentAt") LocalDateTime sentAt);

}
