package com.Pilotos.pilotosCompany.Model;

import java.util.Date;
import javax.persistence.*;
import org.springframework.data.annotation.createdDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "MovimientoDinero" )
public class MovimientoDinero {
    @id
    @generatedValue(strategy = GenerationType.Auto)
    @column(name="id_monto")
    private Integer id;
    @column(name="monto")
    private Integer monto;

    @column(name="monto_positivo")
    private Integer monto_positivo;
    @column(name="monto_negativo")
    private Integer  monto_negativo;
    @column(name="concepto")
    private String concepto;

    @column(name="user_movimiento")
    private String user_movimiento;

    @column(name="fecha_movimiento")
    private String fecha_movimiento;
public MovimientoDinero(){

}

    public MovimientoDinero(Integer id, Integer monto, Integer monto_positivo, Integer monto_negativo, String concepto, String user_movimiento, String fecha_movimiento) {
        this.id = id;
        this.monto = monto;
        this.monto_positivo = monto_positivo;
        this.monto_negativo = monto_negativo;
        this.concepto = concepto;
        this.user_movimiento = user_movimiento;
        this.fecha_movimiento = fecha_movimiento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public void setMonto_positivo(Integer monto_positivo) {
        this.monto_positivo = monto_positivo;
    }

    public void setMonto_negativo(Integer monto_negativo) {
        this.monto_negativo = monto_negativo;
    }

    public String getFecha_movimiento() {
        return fecha_movimiento;
    }

    public void setFecha_movimiento(String fecha_movimiento) {
        this.fecha_movimiento = fecha_movimiento;
    }

    @Override
    public String toString() {
        return "(MovimientoDinero [id="+id +"monto="+monto+"="+ monto_positivo+"monto_positivo="+monto_negativo+"monto_negativo="+concepto+"user_movimiento="+ user_movimiento+"fecha_movimiento="+ fecha_movimiento ;
    }

}
