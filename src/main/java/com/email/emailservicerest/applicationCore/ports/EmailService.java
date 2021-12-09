package com.email.emailservicerest.applicationCore.ports;

import com.email.emailservicerest.applicationCore.entities.EmailModel;

public interface EmailService {

    EmailModel save(EmailModel emailModel);
}
