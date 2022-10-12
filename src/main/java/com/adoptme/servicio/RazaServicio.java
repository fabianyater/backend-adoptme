package com.adoptme.servicio;

import com.adoptme.dto.RazaDto;
import com.adoptme.modelo.Raza;

import java.util.List;

public interface RazaServicio {
    void registrarRaza(RazaDto razaDto);

    List<Raza> obtenerRazas();
}
