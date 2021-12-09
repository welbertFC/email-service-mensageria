package com.email.emailservicerest.consumers;

import com.email.emailservicerest.mappers.EmailMapper;
import com.email.emailservicerest.models.dtos.EmailRequest;
import com.email.emailservicerest.services.EmailServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    EmailServiceImpl service;

    @RabbitListener(queues = "${spring.rabbitmq.template.default-receive-queue}")
    public void listen(@Payload EmailRequest emailRequest) {
        service.save(EmailMapper.convertToModel(emailRequest));
    }


}
