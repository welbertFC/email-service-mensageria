package com.email.emailservicerest.adapters.outbound.persistence;

import com.email.emailservicerest.applicationCore.entities.EmailModel;
import com.email.emailservicerest.applicationCore.ports.EmailRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PostgresEmailRepository implements EmailRepository {

    private final SpringDataMongoEmailRepository emailRepository;

    public PostgresEmailRepository(SpringDataMongoEmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Override
    public EmailModel save(EmailModel emailModel) {
        return emailRepository.save(emailModel);
    }
}
