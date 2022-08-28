package com.Pilotos.pilotosCompany.Vista;

public class MovimientoDineroView {

    public void imprimirDatosMovimiento( int id, int monto, int monto_positivo, int monto_negativo, String concepto, String user_movimiento, date user_movimiento){
        System.out.println("Imprimir datos de movimientos de montos");
        System.out.println("id: " + id);
        System.out.println("monto: " + monto);
        System.out.println("monto positivo: " + monto_positivo);
        System.out.println("monto negativo: " + monto_negativo);
        System.out.println("concepto: " + concepto);
        System.out.println("usuario que registra movimiento: " + user_movimiento);
        System.out.println("fecha registro de movimiento: " +fecha_movimiento);

    }
