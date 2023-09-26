/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poo.barcos;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Alquiler {
    
    private Cliente cliente;
    private Date fechaInicial;
    private Date fechaFinal;
    private int posicionAmarre;
    private long diferenciaEnDias;

    public Alquiler(Cliente cliente, Date fechaInicial, Date fechaFinal, int posicionAmarre) {
        this.cliente = cliente;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.posicionAmarre = posicionAmarre;
    }

    public Alquiler() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public int getPosicionAmarre() {
        return posicionAmarre;
    }
    
    public double calcularCostoAlquiler() {
        diferenciaEnDias = (fechaFinal.getTime() - fechaInicial.getTime()) / (1000 * 60 * 60 * 24);
        // Se agrega un impuesto del 10%
        double costoAlquiler = diferenciaEnDias * (25000 + 1.10);
        return costoAlquiler;
    }
    
    public void imprimirRecibo() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("\n========= Recibo de Alquiler ==========\n");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Matrícula del Barco: " + cliente.getBarco().getMatricula());
        System.out.println("Eslora del Barco: " + cliente.getBarco().getEsloraMetros() + " metros");
        System.out.println("Año de Fabricación del Barco: " + cliente.getBarco().getAnoFabricacion());
        System.out.println("Fecha Inicial de Alquiler: " + dateFormat.format(fechaInicial));
        System.out.println("Fecha Final de Alquiler: " + dateFormat.format(fechaFinal));
        System.out.println("Posición del Amarre: " + posicionAmarre);
        System.out.println("Costo del Alquiler: $" + calcularCostoAlquiler());
        System.out.println("Total días: " + diferenciaEnDias);
    }

    @Override
    public String toString() {
        return "Alquiler{" + "cliente=" + cliente + ", fechaInicial=" + fechaInicial + ", fechaFinal=" + fechaFinal + ", posicionAmarre=" + posicionAmarre + '}';
    }    
}
