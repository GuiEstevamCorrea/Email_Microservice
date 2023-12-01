package com.gc.emailmicroservice.consumers;

import com.gc.emailmicroservice.dto.EmailRecordDTO;
import com.gc.emailmicroservice.model.EmailModel;
import com.gc.emailmicroservice.service.EmailService;
import org.jetbrains.annotations.NotNull;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    EmailService emailService;

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload @NotNull EmailRecordDTO emailRecordDTO){
        var emailModel = new EmailModel();
        BeanUtils.copyProperties(emailRecordDTO, emailModel);
        emailService.sendEmail(emailModel);
    }
}
