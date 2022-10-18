package com.adoptme.servicio;

import com.adoptme.dto.ActualizarMascotaSolicitud;
import com.adoptme.dto.CategoriaDto;
import com.adoptme.dto.MascotaRespuesta;
import com.adoptme.dto.MascotaSolicitud;
import com.adoptme.dto.RazaDto;
import com.adoptme.modelo.Categoria;
import com.adoptme.modelo.Mascota;
import com.adoptme.modelo.Solicitud;
import com.adoptme.repositorio.MascotaRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class MascotaServicioImpl implements MascotaServicio {
    @Autowired
    private MascotaRepositorio mascotaRepositorio;

    @Autowired
    private SolicitudServicio solicitudServicio;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void crearMascota(MascotaSolicitud mascotaSolicitud) {

        mascotaRepositorio.save(convertirMascotaSolicitud(mascotaSolicitud));
    }

    @Override
    public List<MascotaRespuesta> obtenerMascotas() {
        List<Mascota> mascotas = mascotaRepositorio.findAll();
        return convertirMascotasAListaMascotaRespuesta(mascotas);
    }

    @Override
    public Mascota obtenerMascotaPorId(Integer id) {
        return mascotaRepositorio.findById(id).orElse(null);
    }

    @Override
    public void actualizarMascota(ActualizarMascotaSolicitud actualizarMascotaSolicitud) {
        Mascota mascota = obtenerMascotaPorId(actualizarMascotaSolicitud.getId());
        mascota.setNombre(actualizarMascotaSolicitud.getNombre());
        mascota.setDescripcion(actualizarMascotaSolicitud.getDescripcion());
        mascota.setEstado(actualizarMascotaSolicitud.getEstado());
        mascota.setEdad(actualizarMascotaSolicitud.getEdad());
        mascota.setFoto(convertirImagen(actualizarMascotaSolicitud.getFoto()));
        mascota.setPeso(actualizarMascotaSolicitud.getPeso());
        mascota.setSexo(actualizarMascotaSolicitud.getSexo());
        mascota.setCategoria(actualizarMascotaSolicitud.getCategoriaId());
        mascota.setRaza(actualizarMascotaSolicitud.getRazaId());
        mascotaRepositorio.save(mascota);
    }

    @Override
    public void eliminarMascota(Integer id) {
        List<Solicitud> solicitudes = solicitudServicio.obtenerSolicitudPorMascotaId(id);
        if (solicitudes.size() > 0){
            for (Solicitud solicitud : solicitudes){
                solicitudServicio.eliminarSolicitud(solicitud.getId());
            }
        }else{
            mascotaRepositorio.deleteById(id);
        }
    }

    private byte[] convertirImagen(String imagen) {
        return Base64.getDecoder().decode(imagen);
    }

    //Convert byte array to Base64 String
    private String convertirImagen(byte[] imagen) {
        return Base64.getEncoder().encodeToString(imagen);
    }

    static String byteArrayToBase64(byte[] byteArrayPhoto) {
        return Base64.getEncoder().encodeToString(byteArrayPhoto);
    }




    private Mascota convertirMascotaSolicitud(MascotaSolicitud mascotaSolicitud) {
        Mascota mascota = new Mascota();
        mascota.setNombre(mascotaSolicitud.getNombre());
        mascota.setDescripcion(mascotaSolicitud.getDescripcion());
        mascota.setEstado(mascotaSolicitud.getEstado());
        mascota.setEdad(mascotaSolicitud.getEdad());
        mascota.setFoto(convertirImagen(mascotaSolicitud.getFoto()));
        mascota.setPeso(mascotaSolicitud.getPeso());
        mascota.setSexo(mascotaSolicitud.getSexo());
        mascota.setCategoria(mascotaSolicitud.getCategoriaId());
        mascota.setRaza(mascotaSolicitud.getRazaId());
        return mascota;
    }

    private List<MascotaRespuesta> convertirMascotasAListaMascotaRespuesta(List<Mascota> mascotas) {
        List<MascotaRespuesta> mascotasRespuesta = new ArrayList<>();

        for (Mascota mascota : mascotas) {
            CategoriaDto categoriaDto = modelMapper.map(mascota.getCategoria(), CategoriaDto.class);
            RazaDto razaDto = modelMapper.map(mascota.getRaza(), RazaDto.class);
            MascotaRespuesta mascotaRespuesta = new MascotaRespuesta();
            mascotaRespuesta.setId(mascota.getId());
            mascotaRespuesta.setNombre(mascota.getNombre());
            mascotaRespuesta.setDescripcion(mascota.getDescripcion());
            mascotaRespuesta.setEstado(mascota.getEstado());
            mascotaRespuesta.setEdad(mascota.getEdad());
            mascotaRespuesta.setFoto(mascota.getFoto());
            mascotaRespuesta.setPeso(mascota.getPeso());
            mascotaRespuesta.setSexo(mascota.getSexo());
            mascotaRespuesta.setCategoria(categoriaDto);
            mascotaRespuesta.setRaza(razaDto);
            mascotasRespuesta.add(mascotaRespuesta);
        }
        return mascotasRespuesta;
    }
}
