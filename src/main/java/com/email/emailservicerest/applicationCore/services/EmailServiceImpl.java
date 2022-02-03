package com.email.emailservicerest.applicationCore.services;

import com.email.emailservicerest.applicationCore.entities.Email;
import com.email.emailservicerest.applicationCore.entities.enums.StatusEmail;
import com.email.emailservicerest.applicationCore.ports.EmailRepository;
import com.email.emailservicerest.applicationCore.ports.EmailService;
import com.email.emailservicerest.applicationCore.ports.EmailServiceSend;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    @Value("${default.sender}")
    private String emailFrom;

    private final EmailRepository repository;

    private final EmailServiceSend emailServiceSend;

    @Override
    public Email save(Email email) {
        email.setEmailFrom(emailFrom);
        email.generateId();
        email.setCreatedDate(LocalDateTime.now());

        try {
            emailServiceSend.sendEmail(email);
            email.setStatusEmail(StatusEmail.SEND);
        } catch (MailException exception) {
            email.setStatusEmail(StatusEmail.ERROR);
        }
        return repository.save(email);
    }

    @Override
    public Email findByIs(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<Email> findAll() {
        return repository.findAll();
    }


}
