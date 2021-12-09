package com.email.emailservicerest.applicationCore.services;

import com.email.emailservicerest.applicationCore.entities.EmailModel;
import com.email.emailservicerest.applicationCore.entities.enums.StatusEmail;
import com.email.emailservicerest.applicationCore.ports.EmailRepository;
import com.email.emailservicerest.applicationCore.ports.EmailService;
import com.email.emailservicerest.applicationCore.services.emailCore.EmailServiceStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    @Value("${default.sender}")
    private String emailFrom;

    private final EmailRepository repository;

    private final EmailServiceStrategy emailServiceStrategy;

    public EmailModel save(EmailModel emailModel) {
        emailModel.setEmailFrom(emailFrom);
        emailModel.generateId();
        emailModel.setCreatedDate(LocalDateTime.now());

        try {
            emailServiceStrategy.sendEmail(emailModel);
            emailModel.setStatusEmail(StatusEmail.SEND);
        } catch (MailException exception) {
            emailModel.setStatusEmail(StatusEmail.ERROR);
        }
        return repository.save(emailModel);
    }

}
