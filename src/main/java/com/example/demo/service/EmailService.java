package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarCorreoContacto(Map<String, String> datos) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("cristychavajay8@gmail.com"); // Tu correo
        message.setSubject("Nuevo mensaje de contacto: " + datos.get("asunto"));
        message.setText("Nombre: " + datos.get("nombre") + "\n" +
                        "Correo: " + datos.get("email") + "\n" +
                        "Teléfono: " + datos.get("telefono") + "\n\n" +
                        "Mensaje: " + datos.get("mensaje"));
        mailSender.send(message);
    }
}