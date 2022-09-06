package com.Pilotos.pilotosCompany.repository;

import com.Pilotos.pilotosCompany.util.EnumRol;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table (name = "empleado")
public class EntityEmpleado {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    @Column (name = "nombre")
    private String nombre;
    @Column (name = "apellido")
    private String apellido;
    @Column (name = "edad")
    private Long edad;
    @Column (name = "doc")
    private String doc;
    @Column (name = "Password")
    private String password;
    @Column (name = "rol")
    @Enumerated (EnumType.STRING)
    private EnumRol rol;
    @JoinColumn (name = "id_empresa", referencedColumnName = "id_empresa")
    @ManyToOne (optional = false)
    private EntityEmpresa idEmpresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado")
    private Collection<EntityPermisos> permisosCollection;

}
