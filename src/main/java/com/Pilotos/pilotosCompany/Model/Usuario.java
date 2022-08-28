package com.Pilotos.pilotosCompany.Model;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name="Usuario")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuarios;
    @Column(name="nombre", nullable = false)
    public String nombre;
    @Column(name="direccion", nullable = false)
    public String direccion;
    @Column(name="telefono", nullable = false)
    public String telefono;
    @Column(name="documento", nullable = false)
    private String documento;

    public Usuario (String nombre,String direccion, String telefono, String documento){
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.documento = documento;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
