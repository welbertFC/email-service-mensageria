package com.email.emailservicerest.mappers;

import com.email.emailservicerest.models.EmailModel;
import com.email.emailservicerest.models.dtos.EmailRequest;
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
