package com.email.emailservicerest.repositorys;

import com.email.emailservicerest.models.EmailModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface EmailRepository extends MongoRepository<EmailModel, UUID> {
}
