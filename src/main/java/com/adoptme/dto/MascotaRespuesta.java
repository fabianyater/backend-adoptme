package com.adoptme.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MascotaRespuesta {
    private Integer id;
    private String nombre;
    private String descripcion;
    private String estado;
    private Integer edad;
    private byte[] foto;
    private CategoriaDto categoria;
    private RazaDto raza;
}
