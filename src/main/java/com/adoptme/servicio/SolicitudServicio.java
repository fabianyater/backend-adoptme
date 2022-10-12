package com.adoptme.servicio;

import com.adoptme.modelo.Solicitud;
import com.adoptme.modelo.Usuario;

import java.util.List;

public interface SolicitudServicio {
    void crearSolicitud(Solicitud solicitud, String telefono);

    Solicitud obtenerSolicitudPorId(Long id);

    List<Solicitud> obtenerSolicitudes();

}
