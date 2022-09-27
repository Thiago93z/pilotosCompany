package com.Pilotos.pilotosCompany.Model;

import com.Pilotos.pilotosCompany.Enums.Enum_Rol;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name="mail",nullable = false, unique = true)
    private String mail;
    private String nombre;
    private int edad;
    @Enumerated(EnumType.STRING)
    @Column(name = "rol", columnDefinition = "USER")
    private Enum_Rol rol;

    @Column(name = "auth0Id", unique = true)
    private String auth0Id;

    @CreationTimestamp
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    @JoinColumn(name = "id_empresa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empresa idEmpresa;

    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;*/

    @OneToOne
    private Usuario usuario;

}