package com.Pilotos.pilotosCompany.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@AllArgsConstructor
@Data

public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nombre;
    private String direccion;
    private int telefono;
    private String nit;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresa")
    @JsonIgnore
    private  Collection<Empleado> empleados;

    public Empresa(){

    }
}
