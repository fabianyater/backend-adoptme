package com.adoptme.repositorio;

import com.adoptme.modelo.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitudRepositorio extends JpaRepository<Solicitud, Integer> {
    List<Solicitud> findByMascota_Id(Integer id);
}
