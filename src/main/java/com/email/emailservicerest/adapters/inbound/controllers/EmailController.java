package com.email.emailservicerest.adapters.inbound.controllers;

import com.email.emailservicerest.adapters.outbound.mappers.EmailMapper;
import com.email.emailservicerest.adapters.outbound.model.dtos.EmailResponse;
import com.email.emailservicerest.applicationCore.ports.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService service;

    @GetMapping("/{id}")
    public ResponseEntity<EmailResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(EmailMapper.convertToResponse(service.findByIs(id)));
    }

    @GetMapping
    public List<EmailResponse> listAll() {
        return service.findAll()
                .stream()
                .map(EmailMapper::convertToResponse)
                .collect(Collectors.toList());

    }
}
