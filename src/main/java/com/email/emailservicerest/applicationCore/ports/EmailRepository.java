package com.email.emailservicerest.applicationCore.ports;

import com.email.emailservicerest.applicationCore.entities.EmailModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface EmailRepository  {

    EmailModel save(EmailModel emailModel);
}
