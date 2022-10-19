package com.adoptme.servicio;

import com.adoptme.dto.UsuarioRegistro;
import com.adoptme.dto.UsuarioSolicitud;
import com.adoptme.modelo.Usuario;
import com.adoptme.repositorio.UsuarioRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServicioImpl implements UsuarioServicio, UserDetailsService {

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
    public void registrarUsuario(UsuarioRegistro usuarioRegistro) {
        Usuario usuario = modelMapper.map(usuarioRegistro, Usuario.class);
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

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByCorreo(email);
        return new User(usuario.getCorreo(), usuario.getContrasenia(), new ArrayList<>());
    }
}
