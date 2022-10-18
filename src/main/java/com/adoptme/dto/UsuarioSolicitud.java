package com.adoptme.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioSolicitud {
    private String nombre;
    private String apellido;
    private String direccion;
    private String correo;
    private String telefono;
    private Integer edad;
}
