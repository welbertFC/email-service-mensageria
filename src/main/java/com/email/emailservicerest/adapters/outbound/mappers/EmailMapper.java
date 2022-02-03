package com.email.emailservicerest.adapters.outbound.mappers;

import com.email.emailservicerest.adapters.outbound.model.EmailModel;
import com.email.emailservicerest.applicationCore.entities.Email;
import com.email.emailservicerest.adapters.outbound.model.dtos.EmailRequest;
import com.email.emailservicerest.adapters.outbound.model.dtos.EmailResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EmailMapper {

    private static final ModelMapper mapper = new ModelMapper();

    private EmailMapper() {
    }

    public static Email convertResquestToEmail(EmailRequest emailRequest) {
        return mapper.map(emailRequest, Email.class);
    }

    public static EmailResponse convertToResponse(Email email) {
        return mapper.map(email, EmailResponse.class);
    }

    public static Email convertToEmail(EmailModel emailModel){
        return mapper.map(emailModel, Email.class);
    }

    public static EmailModel convertToEmailModel(Email email){
        return mapper.map(email, EmailModel.class);
    }


    
}
