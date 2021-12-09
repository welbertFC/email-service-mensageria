package com.email.emailservicerest.applicationCore.services.emailCore;

import com.email.emailservicerest.applicationCore.services.emailCore.AbstractEmailServiceStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class SmtpGmailServiceStrategy extends AbstractEmailServiceStrategy {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void send(SimpleMailMessage message) {
        javaMailSender.send(message);

    }
}
