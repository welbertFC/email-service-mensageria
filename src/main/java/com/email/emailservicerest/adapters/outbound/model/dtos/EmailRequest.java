package com.email.emailservicerest.adapters.outbound.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailRequest {

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String emailTo;

    @NotBlank
    private String subject;

    @NotBlank
    private String text;

}
