package com.email.emailservicerest.adapters.configuration;

import com.email.emailservicerest.applicationCore.services.emailCore.EmailServiceStrategy;
import com.email.emailservicerest.applicationCore.services.emailCore.SmtpGmailServiceStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailConfiguration {

    @Bean
    public EmailServiceStrategy emailService() {
        return new SmtpGmailServiceStrategy();
    }


}
