package com.email.emailservicerest.applicationCore.ports;

import com.email.emailservicerest.applicationCore.entities.Email;
import org.springframework.mail.SimpleMailMessage;

public interface EmailServiceSend {

    void send(SimpleMailMessage message);

    void sendEmail(Email email);
}
