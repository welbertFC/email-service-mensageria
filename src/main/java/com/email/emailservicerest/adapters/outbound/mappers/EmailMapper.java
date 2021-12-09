package com.email.emailservicerest.adapters.outbound.mappers;

import com.email.emailservicerest.applicationCore.entities.EmailModel;
import com.email.emailservicerest.applicationCore.entities.dtos.EmailRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EmailMapper {

    private static final ModelMapper mapper = new ModelMapper();

    private EmailMapper() {
    }

    public static EmailModel convertToModel(EmailRequest emailRequest) {
        return mapper.map(emailRequest, EmailModel.class);
    }
}
