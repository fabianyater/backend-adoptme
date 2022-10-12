package com.adoptme.repositorio;

import com.adoptme.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
    Usuario findByTelefono(String telefono);

}
