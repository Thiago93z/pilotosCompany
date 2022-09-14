package com.Pilotos.pilotosCompany.Model;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name="Usuario")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name="nombre", nullable = false)
    private String nombre;
    @Column(name="direccion")
    private String direccion;
    @Column(name="telefono", nullable = false)
    private String telefono;
    @Column(name="documento", nullable = false)
    private String documento;
  
    @ManyToOne(fetch = FetchType.LAZY , targetEntity = com.Pilotos.pilotosCompany.Model.Empleado.class)
    @JoinColumn(name = "Id_Empleado")
    private Empresa Empresa;

    public Usuario(){

    }


    public Usuario(String nombre,String direccion, String telefono, String documento){
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
