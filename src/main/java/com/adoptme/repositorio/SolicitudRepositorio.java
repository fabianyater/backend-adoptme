package com.adoptme.repositorio;

import com.adoptme.modelo.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepositorio extends JpaRepository<Solicitud, Long> {

}
