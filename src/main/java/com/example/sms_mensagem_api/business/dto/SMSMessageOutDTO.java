package com.example.sms_mensagem_api.business.dto;

import com.example.sms_mensagem_api.infraestructure.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SMSMessageOutDTO {

    private Long id;
    private String phoneNumber;
    private StatusEnum status; // ENVIADO, RECEBIDO, ERRO DE ENVIO

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime sentAt;
}
