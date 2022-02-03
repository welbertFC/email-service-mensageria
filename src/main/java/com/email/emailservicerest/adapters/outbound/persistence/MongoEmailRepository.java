package com.email.emailservicerest.adapters.outbound.persistence;

import com.email.emailservicerest.adapters.outbound.mappers.EmailMapper;
import com.email.emailservicerest.applicationCore.entities.Email;
import com.email.emailservicerest.applicationCore.ports.EmailRepository;
import com.sun.jdi.ObjectCollectedException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@Primary
public class MongoEmailRepository implements EmailRepository {

    private final SpringDataMongoEmailRepository emailRepository;

    public MongoEmailRepository(SpringDataMongoEmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Override
    public Email save(Email email) {
        var emailModel = EmailMapper.convertToEmailModel(email);
        return EmailMapper.convertToEmail(emailRepository.save(emailModel));
    }

    @Override
    public Email findById(UUID id) {
        return EmailMapper.convertToEmail(
                emailRepository.findById(id).orElseThrow(ObjectCollectedException::new));
    }

    @Override
    public List<Email> findAll() {
        var emails = emailRepository.findAll();
        return emails.stream().map(EmailMapper::convertToEmail).collect(Collectors.toList());
    }
}
