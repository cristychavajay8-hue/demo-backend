package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.EmailService;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ContactoController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/contacto")
    public ResponseEntity<String> recibirContacto(@RequestBody Map<String, String> datos) {
       
        emailService.enviarCorreoContacto(datos);
        return ResponseEntity.ok("¡Mensaje recibido correctamente!");
    }
}