package com.adoptme.controlador;

import com.adoptme.modelo.Solicitud;
import com.adoptme.servicio.SolicitudServicio;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudControlador {
    @Autowired
    private SolicitudServicio solicitudServicio;

    @PostMapping("/{telefono}")
    public ResponseEntity<Solicitud> crearSolicitud(@RequestBody Solicitud solicitud, @PathVariable String telefono) {
        solicitudServicio.crearSolicitud(solicitud, telefono);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Solicitud>> obtenerSolicitudes() {
        return ResponseEntity.ok(solicitudServicio.obtenerSolicitudes());
    }
}
