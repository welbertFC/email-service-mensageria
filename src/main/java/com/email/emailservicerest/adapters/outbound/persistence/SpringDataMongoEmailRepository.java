package com.email.emailservicerest.adapters.outbound.persistence;

import com.email.emailservicerest.applicationCore.entities.EmailModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataMongoEmailRepository extends MongoRepository<EmailModel, UUID> {

}
