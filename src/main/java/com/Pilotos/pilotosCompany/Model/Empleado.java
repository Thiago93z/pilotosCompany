package com.Pilotos.pilotosCompany.Model;

<<<<<<< HEAD
import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name="Empleado")


public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpleado;
    @Column(name="empleado",nullable = false)
    String empleado;
    @Column(name = "id",nullable = false)

    String id;
    @Column(name="empresa",nullable = false)
    String empresa;
    @Column(name="rol",nullable = false)
    String rol;
    @Column(name="mail",nullable = false)
    String mail;
    public Empleado(String empleado, String id, String empresa, String rol, String mail) {
        this.empleado = empleado;
        this.id = id;
        this.empresa = empresa;
        this.rol = rol;
        this.mail = mail;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
=======
import com.Pilotos.pilotosCompany.Enums.Enum_Rol;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

>>>>>>> origin/development
}
