package com.example.sms_mensagem_api.infraestructure.enums;

import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusEnum {

    ENVIADO,
    RECEBIDO,
    ERRO_DE_ENVIO;

    public static boolean validStatus(StatusEnum status) {

        if (status.equals(ENVIADO) || status.equals(RECEBIDO) || status.equals(ERRO_DE_ENVIO)) {

            return true;

        } else {
            return false;
        }

    }
}
