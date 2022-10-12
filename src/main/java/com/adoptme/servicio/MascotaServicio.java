package com.adoptme.servicio;

import com.adoptme.dto.MascotaRespuesta;
import com.adoptme.dto.MascotaSolicitud;
import com.adoptme.dto.UsuarioSolicitud;
import com.adoptme.modelo.Mascota;
import com.adoptme.modelo.Usuario;

import java.util.List;

public interface MascotaServicio {
    void crearMascota(MascotaSolicitud mascotaSolicitud);

    List<MascotaRespuesta> obtenerMascotas();

    Mascota obtenerMascotaPorId(Integer id);

    void actualizarMascota(Integer id);

    void eliminarMascota(Integer id);
}
