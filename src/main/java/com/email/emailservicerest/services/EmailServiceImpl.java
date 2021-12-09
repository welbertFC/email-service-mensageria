package com.email.emailservicerest.services;

import com.email.emailservicerest.models.EmailModel;
import com.email.emailservicerest.models.enums.StatusEmail;
import com.email.emailservicerest.repositorys.EmailRepository;
import com.email.emailservicerest.services.email.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl {

    @Value("${default.sender}")
    private String emailFrom;

    private final EmailRepository repository;

    private final EmailService emailService;

    public EmailModel save(EmailModel emailModel) {
        emailModel.setEmailFrom(emailFrom);
        emailModel.generateId();
        emailModel.setCreatedDate(LocalDateTime.now());

        try {
            emailService.sendEmail(emailModel);
            emailModel.setStatusEmail(StatusEmail.SEND);
        } catch (MailException exception) {
            emailModel.setStatusEmail(StatusEmail.ERROR);
        }
        return repository.save(emailModel);
    }

}
