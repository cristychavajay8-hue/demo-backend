package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ContactoController {

    @Autowired
    private com.example.demo.service.EmailService emailService;

    @PostMapping("/contacto")
    public ResponseEntity<String> recibirContacto(@RequestBody Map<String, String> datos) {
        System.out.println("Formulario recibido con éxito.");
        System.out.println("Nombre: " + datos.get("nombre"));
        System.out.println("Correo: " + datos.get("email"));
        System.out.println("Mensaje: " + datos.get("mensaje"));

        // Se llama al servicio de envío de correo
        emailService.enviarCorreoContacto(datos);

        return ResponseEntity.ok("¡Mensaje recibido correctamente en Spring Boot!");
    }
}