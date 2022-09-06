package com.Pilotos.pilotosCompany.Model;

import lombok.Data;

@Data
public class Empresa {

    private Long idEmpresa;
    private String nombre;
    private String direccion;
    private int telefono;
    private String NIT;

}
