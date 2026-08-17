package com.example.sms_mensagem_api.controller;

import com.example.sms_mensagem_api.business.dto.SMSMessageInDTO;
import com.example.sms_mensagem_api.business.dto.SMSMessageOutDTO;
import com.example.sms_mensagem_api.infraestructure.enums.StatusEnum;
import com.example.sms_mensagem_api.infraestructure.service.SMSMessageService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("SMS_Message")
public class SMSMessageController {

    private final SMSMessageService smsMessageService;

    public SMSMessageController(SMSMessageService smsMessageService) {this.smsMessageService = smsMessageService;}

    @Operation(
            summary = "Salvar registro",
            description = "Salvar um registro de SMS enviado e seu status.",
            tags = {"Mensagens SMS"}
    )
    @PostMapping
    public ResponseEntity<SMSMessageOutDTO> save(@RequestBody SMSMessageInDTO dto) {

        return ResponseEntity.ok(smsMessageService.save(dto));

    }

    @Operation(
            summary = "Atualizar status",
            description = "Atualizar o status de um SMS existente pelo número de telefone.",
            tags = {"Mensagens SMS"}
    )
    @PutMapping
    public ResponseEntity<SMSMessageOutDTO> updateStatus(@RequestBody SMSMessageInDTO dto) {

        return ResponseEntity.ok(smsMessageService.updateStatus(dto));

    }

    @Operation(
            summary = "Buscar mensagens por status e últimas 24 horas",
            description = "Buscar mensagens SMS pelo status e que foram enviadas nas últimas 24 horas.",
            tags = {"Buscar lista SMS"}
    )
    @GetMapping("status_and_last24hours")
    public ResponseEntity<List<SMSMessageOutDTO>> findByStatusAndTimeAfter24hours(@RequestParam StatusEnum status) {

        return ResponseEntity.ok(smsMessageService.findByStatusAndTimeAfter24hours(status));

    }
}
