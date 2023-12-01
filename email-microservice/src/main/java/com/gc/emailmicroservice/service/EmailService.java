package com.gc.emailmicroservice.service;

import com.gc.emailmicroservice.enums.StatusEmail;
import com.gc.emailmicroservice.model.EmailModel;
import com.gc.emailmicroservice.repository.EmailRepository;
import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    JavaMailSender javaMailSender;

    @Value(value = "${spring.mail.username}")
    private String emailFrom;

    @Transactional
    public EmailModel sendEmail(@NotNull EmailModel emailModel){
        try {
            emailModel.setSendDateEmail(LocalDateTime.now());
            emailModel.setEmailFrom(emailFrom);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            javaMailSender.send(message);

            emailModel.setStatusEmail(StatusEmail.ENVIADO);
        } catch (MailException e){
            emailModel.setStatusEmail(StatusEmail.ERRO);
        } finally {
            return emailRepository.save(emailModel);
        }
    }
}
