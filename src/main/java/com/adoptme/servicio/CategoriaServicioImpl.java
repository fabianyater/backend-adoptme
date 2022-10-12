package com.adoptme.servicio;

import com.adoptme.dto.CategoriaDto;
import com.adoptme.modelo.Categoria;
import com.adoptme.repositorio.CategoriaRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServicioImpl implements CategoriaServicio{
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void registrarCategoria(CategoriaDto categoriaDto) {
        Categoria categoria = modelMapper.map(categoriaDto, Categoria.class);
        categoriaRepositorio.save(categoria);
    }

    @Override
    public List<Categoria> obtenerCategorias() {
        return categoriaRepositorio.findAll();
    }
}
