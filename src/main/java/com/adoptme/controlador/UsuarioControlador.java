package com.adoptme.controlador;

import com.adoptme.dto.UsuarioLogin;
import com.adoptme.dto.UsuarioRegistro;
import com.adoptme.dto.UsuarioRespuesta;
import com.adoptme.dto.UsuarioSolicitud;
import com.adoptme.modelo.Usuario;
import com.adoptme.servicio.UsuarioServicio;
import com.adoptme.utils.GeneralResponse;
import com.adoptme.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios/")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/solicitud")
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

    @PostMapping("/register")
    public ResponseEntity<String> registrarUsuario2(@RequestBody UsuarioRegistro usuarioRegistro) {
        usuarioRegistro.setContrasenia(bCryptPasswordEncoder.encode(usuarioRegistro.getContrasenia()));
        usuarioServicio.registrarUsuario(usuarioRegistro);
        return ResponseEntity.ok().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Usuario>> obtenerUsuarios() {
        List<Usuario> usuarios = usuarioServicio.obtenerUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/telefono/{telefono}")
    public ResponseEntity<Usuario> obtenerUsuarioPorTelefono(@PathVariable String telefono) {
        Usuario usuario = usuarioServicio.obtenerUsuarioPorTelefono(telefono);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<GeneralResponse<Usuario>> login(@RequestBody UsuarioLogin user) {
        GeneralResponse<Usuario> response = new GeneralResponse<>();
        HttpStatus status = null;
        String messageResult = "";
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getCorreo(), user.getContrasenia()));
            user.setJwt(jwtUtils.generateToken(user.getCorreo()));
            user.setContrasenia(null);
            messageResult = "Login successfull for user: " + user.getCorreo() + ".";

            response.setToken(user.getJwt());
            response.setMessage("Operation successfull");
            response.setData(user);
            status = HttpStatus.CREATED;

        } catch (AuthenticationException authex) {
            String message = "Incorrect user or password.";
            status = HttpStatus.FORBIDDEN;
            response.setMessage(message);
        } catch (Exception e) {
            String message = "Something went wrong. Please contact support.";
            status = HttpStatus.FORBIDDEN;
            response.setMessage(message);
        }

        return new ResponseEntity<>(response, status);
    }

}
