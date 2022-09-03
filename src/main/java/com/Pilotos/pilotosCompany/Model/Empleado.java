package com.Pilotos.pilotosCompany.Model;

import com.Pilotos.pilotosCompany.Controller.EmpleadoComtroller;

import javax.persistence.*;

@Entity
@Table(name="Empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name="empleado",nullable = false)
    private  String empleado;
    @Column(name="empresa",nullable = false)
    private String empresa;
    @Column(name="rol",nullable = false)
    private String rol;
    @Column(name="mail",nullable = false)
    private String mail;
    @ManyToOne(fetch = FetchType.LAZY , targetEntity = com.Pilotos.pilotosCompany.Model.Empresa.class)
    private Empresa Empresa;

    public Empleado() {
    }

    public Empleado(String empleado, String empresa, String rol, String mail) {
        this.empleado = empleado;
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
