package com.adoptme.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioLogin {
    private String correo;
    private String contrasenia;
    private String jwt;
}
