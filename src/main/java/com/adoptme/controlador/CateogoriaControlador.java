package com.adoptme.controlador;

import com.adoptme.dto.CategoriaDto;
import com.adoptme.modelo.Categoria;
import com.adoptme.servicio.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
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
