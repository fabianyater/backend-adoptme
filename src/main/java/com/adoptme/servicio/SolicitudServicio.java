package com.adoptme.servicio;

import com.adoptme.modelo.Solicitud;
import com.adoptme.modelo.Usuario;

import java.util.List;

public interface SolicitudServicio {
    void crearSolicitud(Solicitud solicitud, String telefono);

    Solicitud obtenerSolicitudPorId(Integer id);

    List<Solicitud> obtenerSolicitudes();

    List<Solicitud> obtenerSolicitudPorMascotaId(Integer id);

    void eliminarSolicitud(Integer id);

}
