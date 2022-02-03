package com.email.emailservicerest.adapters.outbound.email;

import com.email.emailservicerest.adapters.outbound.email.AbstractEmailServiceStrategy;
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
