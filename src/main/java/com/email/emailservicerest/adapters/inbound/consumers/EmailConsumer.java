package com.email.emailservicerest.adapters.inbound.consumers;

import com.email.emailservicerest.adapters.outbound.model.dtos.EmailRequest;
import com.email.emailservicerest.applicationCore.ports.EmailService;
import com.email.emailservicerest.adapters.outbound.mappers.EmailMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    EmailService service;

    @RabbitListener(queues = "${spring.rabbitmq.template.default-receive-queue}")
    public void listen(@Payload EmailRequest emailRequest) {
        service.save(EmailMapper.convertResquestToEmail(emailRequest));
    }


}
