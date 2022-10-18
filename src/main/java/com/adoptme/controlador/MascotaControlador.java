package com.adoptme.controlador;

import com.adoptme.dto.ActualizarMascotaSolicitud;
import com.adoptme.dto.MascotaRespuesta;
import com.adoptme.dto.MascotaSolicitud;
import com.adoptme.modelo.Mascota;
import com.adoptme.servicio.MascotaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaControlador {
    @Autowired
    private MascotaServicio mascotaServicio;

    @PostMapping
    public ResponseEntity<MascotaSolicitud> crearMascota(@RequestBody MascotaSolicitud mascotaSolicitud) {
        mascotaServicio.crearMascota(mascotaSolicitud);
        return ResponseEntity.ok(mascotaSolicitud);
    }

    @GetMapping
    public ResponseEntity<List<MascotaRespuesta>> obtenerMascotas() {
        return ResponseEntity.ok(mascotaServicio.obtenerMascotas());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Mascota> obtenerMascotaPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(mascotaServicio.obtenerMascotaPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mascota> eliminarMascota(@PathVariable Integer id) {
        mascotaServicio.eliminarMascota(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Mascota> actualizarMascota(@RequestBody ActualizarMascotaSolicitud actualizarMascotaSolicitud) {
        mascotaServicio.actualizarMascota(actualizarMascotaSolicitud);
        return ResponseEntity.ok().build();
    }
}
