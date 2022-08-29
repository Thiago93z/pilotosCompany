package com.Pilotos.pilotosCompany.Model;

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
}
