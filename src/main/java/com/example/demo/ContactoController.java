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

    String correo = datos.get("correo");
    String telefono = datos.get("telefono");
    String empresa = datos.get("empresa");
    String asunto = datos.get("asunto");
    String mensaje = datos.get("mensaje");

    String contenido = "Nuevo mensaje de contacto:\n\n" +
            "Correo: " + correo + "\n" +
            "Teléfono: " + telefono + "\n" +
            "Empresa: " + empresa + "\n" +
            "Asunto: " + asunto + "\n" +
            "Mensaje: " + mensaje;

    emailService.enviarCorreo("cristychavajay8@gmail.com", "Nuevo mensaje: " + asunto, contenido);

    return ResponseEntity.ok("Formulario enviado con éxito");
}