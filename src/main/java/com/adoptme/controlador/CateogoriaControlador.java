package com.adoptme.controlador;

import com.adoptme.dto.CategoriaDto;
import com.adoptme.modelo.Categoria;
import com.adoptme.servicio.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CateogoriaControlador {
    @Autowired
    private CategoriaServicio categoriaServicio;

    @PostMapping
    public ResponseEntity<Void> registrarCategoria(@RequestBody CategoriaDto categoriaDto) {
        categoriaServicio.registrarCategoria(categoriaDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> obtenerCategorias() {
        return ResponseEntity.ok(categoriaServicio.obtenerCategorias());
    }
}
