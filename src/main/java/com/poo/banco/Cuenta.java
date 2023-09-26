
package com.poo.banco;

import java.util.ArrayList;
import java.util.List;

abstract class Cuenta {
    
    private static List<Cuenta> todasLasCuentas = new ArrayList<>();
    
    protected Cliente cliente;
    protected int numCuenta;
    protected double saldo;

    public Cuenta(Cliente cliente, int numCuenta, double saldo) {
        this.cliente = cliente;
        this.numCuenta = numCuenta;
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public abstract void depositar(double cantidad);
    public abstract void retirar(double cantidad);
    public abstract void EstadoCuenta();

    // Otros métodos y atributos comunes a todas las cuentas
}
