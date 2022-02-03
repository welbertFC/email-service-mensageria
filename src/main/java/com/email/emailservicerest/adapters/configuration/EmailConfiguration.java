package com.email.emailservicerest.adapters.configuration;

import com.email.emailservicerest.applicationCore.ports.EmailServiceSend;
import com.email.emailservicerest.adapters.outbound.email.SmtpGmailServiceStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailConfiguration {

    @Bean
    public EmailServiceSend emailService() {
        return new SmtpGmailServiceStrategy();
    }


}
