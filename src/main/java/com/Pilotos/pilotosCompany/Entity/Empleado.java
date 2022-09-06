package com.Pilotos.pilotosCompany.Entity;

import lombok.Data;

@Data
public class Empleado {
    private Long id;
    private String nombre;
    private String apellido;
    private Long edad;
    private String doc;
    private String password;
}
