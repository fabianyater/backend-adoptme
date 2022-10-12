package com.adoptme.repositorio;

import com.adoptme.modelo.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MascotaRepositorio extends JpaRepository<Mascota, Integer> {

}
