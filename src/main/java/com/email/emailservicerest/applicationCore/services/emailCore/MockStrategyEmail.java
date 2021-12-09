package com.email.emailservicerest.applicationCore.services.emailCore;

import com.email.emailservicerest.applicationCore.services.emailCore.AbstractEmailServiceStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;

@Slf4j
public class MockStrategyEmail extends AbstractEmailServiceStrategy {

    @Override
    public void send(SimpleMailMessage message) {
        log.info("enviando email.......");
        log.info(message.toString());
        log.info("email enviado.......");


    }
}
