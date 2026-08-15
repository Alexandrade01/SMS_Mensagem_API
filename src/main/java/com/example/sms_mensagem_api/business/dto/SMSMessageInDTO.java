package com.example.sms_mensagem_api.business.dto;

import com.example.sms_mensagem_api.infraestructure.enums.StatusEnum;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SMSMessageInDTO implements Serializable {

    private Long id;
    private String phoneNumber;
    private StatusEnum status; // ENVIADO, RECEBIDO, ERRO DE ENVIO

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime sentAt;
}
