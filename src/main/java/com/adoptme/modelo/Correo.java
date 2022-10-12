package com.adoptme.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Correo {
    private String sender;
    private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;
}
