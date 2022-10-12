package com.adoptme.servicio;

import com.adoptme.dto.CategoriaDto;
import com.adoptme.modelo.Categoria;

import java.util.List;

public interface CategoriaServicio {
    void registrarCategoria(CategoriaDto categoriaDto);

    List<Categoria> obtenerCategorias();
}
