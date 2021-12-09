package com.email.emailservicerest.models;

import com.email.emailservicerest.models.enums.StatusEmail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Document(collation = "email")
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


    public void generateId() {
        this.id = UUID.randomUUID();
    }

}
