
package com.Pilotos.pilotosCompany.Model;

public class MovimientoDinero {
     private int id;
    private int monto;
    private int monto_positivo;
    private int monto_negativo;
    private String concepto;
    private String user_movimiento;
    private  date  fecha_movimiento;
 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getMonto_positivo() {
        return monto_positivo;
    }

    public void setMonto_positivo(int monto_positivo) {
        this.monto_positivo = monto_positivo;
    }

    public int getMonto_negativo() {
        return monto_negativo;
    }

    public void setMonto_negativo(int monto_negativo) {
        this.monto_negativo = monto_negativo;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getUser_movimiento() {
        return user_movimiento;
    }

    public void setUser_movimiento(String user_movimiento) {
        this.user_movimiento = user_movimiento;
    }
      public  date getFecha_movimiento() {
        return fecha_movimiento;
    }

    public void setFecha_movimiento(String fecha_movimiento) {
        this.fecha_movimiento = fecha_movimiento;
    }
}
