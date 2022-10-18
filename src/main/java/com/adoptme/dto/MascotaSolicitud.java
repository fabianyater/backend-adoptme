package com.adoptme.dto;

import com.adoptme.modelo.Categoria;
import com.adoptme.modelo.Raza;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MascotaSolicitud {
    private String nombre;
    private String descripcion;
    private String estado;
    private Integer edad;
    private String foto;
    private Double peso;
    private String sexo;
    private Categoria categoriaId;
    private Raza razaId;
}
