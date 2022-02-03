package com.email.emailservicerest.adapters.outbound.model;

import com.email.emailservicerest.applicationCore.entities.enums.StatusEmail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Document(collection =  "email")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailModel implements Serializable {

    @Id
    private UUID id;

    private String name;

    private String emailFrom;

    private String emailTo;

    private String subject;

    private String text;

    private StatusEmail statusEmail;

    private LocalDateTime createdDate;

}
