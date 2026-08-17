package com.example.sms_mensagem_api.business.dto;

import com.example.sms_mensagem_api.infraestructure.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SMSMessageInDTO implements Serializable {

    private Long id;

    @NotNull(message = "Número de telefone é obrigatório")
    @Pattern(regexp = "^\\+[1-9]\\d{10,14}$", message = "Formato inválido")
    private String phoneNumber;

    @NotNull(message = "Status é obrigatório")
    private StatusEnum status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @PastOrPresent(message = "Data não pode ser futura")
    private LocalDateTime sentAt;
}