package com.adoptme.controlador;

import com.adoptme.dto.UsuarioRespuesta;
import com.adoptme.dto.UsuarioSolicitud;
import com.adoptme.modelo.Usuario;
import com.adoptme.servicio.UsuarioServicio;
import lombok.RequiredArgsConstructor;
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

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostMapping
    public ResponseEntity<String> registrarUsuario(@RequestBody UsuarioSolicitud usuarioSolicitud) {
        Usuario telefono = usuarioServicio.obtenerUsuarioPorTelefono(usuarioSolicitud.getTelefono());
        if (telefono == null) {
            usuarioServicio.registrarUsuario(usuarioSolicitud);
            return ResponseEntity.ok().build();
        } else {
            if (telefono.getTelefono().equals(usuarioSolicitud.getTelefono())) {
                return ResponseEntity.ok("Este usuario ya se encutra registrado");
            }
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerUsuarios() {
        List<Usuario> usuarios = usuarioServicio.obtenerUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/telefono/{telefono}")
    public ResponseEntity<Usuario> obtenerUsuarioPorTelefono(@PathVariable String telefono) {
        Usuario usuario = usuarioServicio.obtenerUsuarioPorTelefono(telefono);
        return ResponseEntity.ok(usuario);
    }
}
