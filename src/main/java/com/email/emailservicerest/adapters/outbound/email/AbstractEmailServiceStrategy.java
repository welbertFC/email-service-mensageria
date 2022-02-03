package com.email.emailservicerest.adapters.outbound.email;

import com.email.emailservicerest.applicationCore.entities.Email;
import com.email.emailservicerest.applicationCore.ports.EmailServiceSend;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

public abstract class AbstractEmailServiceStrategy implements EmailServiceSend {

    @Value("${default.sender}")
    private String emailFrom;

    @Override
    public void sendEmail(Email emailModel) {
        var email = prepareEmail(emailModel);
        send(email);
    }

    private SimpleMailMessage prepareEmail(Email email) {
        var message = new SimpleMailMessage();
        message.setFrom(emailFrom);
        message.setTo(email.getEmailTo());
        message.setSubject(email.getSubject());
        message.setText(email.getText());
        return message;
    }
}
