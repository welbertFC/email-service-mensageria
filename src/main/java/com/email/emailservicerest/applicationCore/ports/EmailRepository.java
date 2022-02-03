package com.email.emailservicerest.applicationCore.ports;

import com.email.emailservicerest.applicationCore.entities.Email;

import java.util.List;
import java.util.UUID;

public interface EmailRepository {

    Email save(Email email);

    Email findById(UUID id);

    List<Email> findAll();

    void deleteAll();
}
