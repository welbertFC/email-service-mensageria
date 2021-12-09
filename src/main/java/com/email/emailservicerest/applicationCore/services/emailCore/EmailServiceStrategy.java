package com.email.emailservicerest.applicationCore.services.emailCore;

import com.email.emailservicerest.applicationCore.entities.EmailModel;
import org.springframework.mail.SimpleMailMessage;

public interface EmailServiceStrategy {

    void send(SimpleMailMessage message);

    void sendEmail(EmailModel emailModel);
}
