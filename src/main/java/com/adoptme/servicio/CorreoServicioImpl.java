package com.adoptme.servicio;

import com.adoptme.modelo.Correo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class CorreoServicioImpl implements CorreoServicio {
    @Autowired
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String sender;

    @Override
    public String enviarCorreo(Correo correo) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(correo.getSender());
        message.setTo(sender);
        message.setSubject(correo.getSubject());
        message.setText(correo.getMsgBody());

        mailSender.send(message);
        return "Correo enviado";
    }
}
