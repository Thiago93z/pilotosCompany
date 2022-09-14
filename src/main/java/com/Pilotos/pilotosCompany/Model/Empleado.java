package com.Pilotos.pilotosCompany.Model;

import com.Pilotos.pilotosCompany.Enums.Enum_Rol;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

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

    @Column(name="mail",nullable = false)
    private String mail;
    private String nombre;
    private int edad;
    @Enumerated(EnumType.STRING)
    @Column(name = "rol")
    private Enum_Rol rol;

    @JoinColumn(name = "id_empresa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empresa idEmpresa;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}