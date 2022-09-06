package com.Pilotos.pilotosCompany.repository;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "permisos")
public class EntityPermisos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column (name = "lectura")
    private Boolean lectura;
    @Column (name = "escritura")
    private Boolean escritura;
    @Column (name = "actualizar")
    private Boolean actualizar;
    @Column (name = "borrar")
    private Boolean borrar;
    @JoinColumn (name = "id_empleado", referencedColumnName = "id")
    @ManyToOne (optional = false)
    private EntityEmpleado idEmpleado;


    public EntityPermisos(Boolean lectura, Boolean escritura, Boolean actualizar, Boolean borrar, EntityEmpleado idEmpleado) {
        this.lectura = lectura;
        this.escritura = escritura;
        this.actualizar = actualizar;
        this.borrar = borrar;
        this.idEmpleado = idEmpleado;
    }
}
