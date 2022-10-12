package com.adoptme.servicio;

import com.adoptme.dto.UsuarioRespuesta;
import com.adoptme.dto.UsuarioSolicitud;
import com.adoptme.modelo.Usuario;

import java.util.List;

public interface UsuarioServicio {
    void registrarUsuario(UsuarioSolicitud usuarioSolicitud);

    List<Usuario> obtenerUsuarios();

    Usuario obtenerUsuarioPorTelefono(String telefono);

}
