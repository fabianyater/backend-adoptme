package com.adoptme.servicio;

import com.adoptme.dto.RazaDto;
import com.adoptme.modelo.Raza;
import com.adoptme.repositorio.RazaRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RazaServicioImpl implements RazaServicio{
    @Autowired
    private RazaRepositorio razaRepositorio;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public void registrarRaza(RazaDto razaDto) {
        Raza raza = modelMapper.map(razaDto, Raza.class);
        razaRepositorio.save(raza);
    }

    @Override
    public List<Raza> obtenerRazas() {
        return razaRepositorio.findAll();
    }
}
