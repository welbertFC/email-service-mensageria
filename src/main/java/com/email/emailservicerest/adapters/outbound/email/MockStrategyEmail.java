package com.email.emailservicerest.adapters.outbound.email;

import com.email.emailservicerest.adapters.outbound.email.AbstractEmailServiceStrategy;
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
