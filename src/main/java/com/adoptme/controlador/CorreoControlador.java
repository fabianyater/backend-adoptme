package com.adoptme.controlador;

import com.adoptme.modelo.Correo;
import com.adoptme.servicio.CorreoServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/correos")
@AllArgsConstructor
public class CorreoControlador {
    private final CorreoServicio correoServicio;

    @PostMapping
    public ResponseEntity<String> enviarCorreo(@RequestBody Correo correo) {
        correoServicio.enviarCorreo(correo);
        return ResponseEntity.ok().build();
    }

}
