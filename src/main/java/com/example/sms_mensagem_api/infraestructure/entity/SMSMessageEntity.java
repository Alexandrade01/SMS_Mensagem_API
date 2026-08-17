package com.example.sms_mensagem_api.infraestructure.entity;

import com.example.sms_mensagem_api.infraestructure.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "SMSMENSAGENS")
public class SMSMessageEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NUMERO_TELEFONE", nullable = false)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private StatusEnum status; // ENVIADO, RECEBIDO, ERRO DE ENVIO

    @Column(name = "HORA_ENVIO", nullable = false)
    private LocalDateTime sentAt;
}
