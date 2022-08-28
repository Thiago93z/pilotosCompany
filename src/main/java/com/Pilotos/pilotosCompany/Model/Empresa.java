package com.Pilotos.pilotosCompany.Model;

import javax.persistence.Entity;
import javax.persistence.*;


@Entity
@Table(name="Empresa")



public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpresa;
    @Column(name="nombre", nullable = false)
    private String nombre;
    @Column(name="direccion", nullable = false)
    private String direccion;
    @Column(name="telefono", nullable = false)
    private int telefono;
    @Column(name="NIT", nullable = false)
    private String NIT;

    public Empresa (String nombre, String direccion, int idEmpresa, int telefono, String NIT) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.idEmpresa = idEmpresa;
        this.telefono = telefono;
        this.NIT = NIT;
    }

    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }
}
