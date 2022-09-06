package com.Pilotos.pilotosCompany.repository;


import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table (name = "empresa")
public class EntityEmpresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_empresa")
    private Long idEmpresa;
    @Column(name="nombre", nullable = false)
    private String nombre;
    @Column(name="direccion", nullable = false)
    private String direccion;
    @Column(name="telefono", nullable = false)
    private int telefono;
    @Column(name="NIT", nullable = false)
    private String NIT;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresa")
    private Collection<EntityEmpleado> listaEmpleados;


}
