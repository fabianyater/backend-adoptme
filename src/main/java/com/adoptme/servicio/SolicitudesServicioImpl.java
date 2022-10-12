package com.adoptme.servicio;

import com.adoptme.modelo.Solicitud;
import com.adoptme.modelo.Usuario;
import com.adoptme.repositorio.SolicitudRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class SolicitudesServicioImpl implements SolicitudServicio{
    @Autowired
    private SolicitudRepositorio solicitudRepositorio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Override
    public void crearSolicitud(Solicitud solicitud, String telefono) {
        Usuario usuario = usuarioServicio.obtenerUsuarioPorTelefono(telefono);
        if (usuario != null){
            solicitud.setUsuario(usuario);
        }

        solicitud.setFechaSolicitud(new Date(System.currentTimeMillis()));

        solicitudRepositorio.save(solicitud);
    }

    @Override
    public Solicitud obtenerSolicitudPorId(Long id) {
        return solicitudRepositorio.findById(id).orElse(null);
    }

    @Override
    public List<Solicitud> obtenerSolicitudes() {
        return solicitudRepositorio.findAll();
    }
}
