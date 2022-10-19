package com.adoptme.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRegistro {
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasenia;
}
