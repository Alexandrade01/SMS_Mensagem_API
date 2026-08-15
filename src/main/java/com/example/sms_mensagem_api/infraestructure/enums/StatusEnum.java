package com.example.sms_mensagem_api.infraestructure.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusEnum {

    ENVIADO,
    RECEBIDO,
    ERRO_DE_ENVIO;
}
