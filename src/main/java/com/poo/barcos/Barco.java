
package com.poo.barcos;

public class Barco {
    
    private String matricula;
    private double esloraMetros;
    private int anoFabricacion;

    public Barco(String matricula, double esloraMetros, int anoFabricacion) {
        this.matricula = matricula;
        this.esloraMetros = esloraMetros;
        this.anoFabricacion = anoFabricacion;
    }

    public Barco() {
    }
    
    public String getMatricula() {
        return matricula;
    }

    public double getEsloraMetros() {
        return esloraMetros;
    }

    public int getAnoFabricacion() {
        return anoFabricacion;
    }

    @Override
    public String toString() {
        return "Barco{" + "matricula=" + matricula + ", esloraMetros=" + esloraMetros + ", anoFabricacion=" + anoFabricacion + '}';
    }
    
    
}
