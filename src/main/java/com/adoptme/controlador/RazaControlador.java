package com.adoptme.controlador;

import com.adoptme.dto.RazaDto;
import com.adoptme.modelo.Raza;
import com.adoptme.servicio.RazaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/razas/")
public class RazaControlador {
    @Autowired
    private RazaServicio razaServicio;

    @PostMapping
    public ResponseEntity<Void> registrarRaza(@RequestBody RazaDto razaDto) {
        razaServicio.registrarRaza(razaDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Raza>> obtenerRazas() {
        return ResponseEntity.ok(razaServicio.obtenerRazas());
    }
}
