package com.email.emailservicerest.adapters.outbound.model.dtos;

import com.email.emailservicerest.applicationCore.entities.enums.StatusEmail;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailResponse {

    private UUID id;

    private String name;

    private String emailFrom;

    private String emailTo;

    private String subject;

    private String text;

    private StatusEmail statusEmail;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime createdDate;

}
