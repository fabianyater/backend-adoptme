package com.adoptme.servicio;

import com.adoptme.dto.UsuarioSolicitud;
import com.adoptme.modelo.Usuario;
import com.adoptme.repositorio.UsuarioRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;


    @Override
    public void registrarUsuario(UsuarioSolicitud usuarioSolicitud) {
        Usuario usuario = modelMapper.map(usuarioSolicitud, Usuario.class);
        usuarioRepositorio.save(usuario);
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        List<Usuario> usuarios = usuarioRepositorio.findAll();
        return usuarios;
    }

    @Override
    public Usuario obtenerUsuarioPorTelefono(String telefono) {
        return usuarioRepositorio.findByTelefono(telefono);
    }
}
