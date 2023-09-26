package com.poo.banco;

public class CuentaAhorro extends Cuenta {

    private double tasaDeRendimiento;

    public CuentaAhorro(double tasaDeRendimiento, Cliente cliente, int numCuenta, double saldo) {
        super(cliente, numCuenta, saldo);
        this.tasaDeRendimiento = tasaDeRendimiento;
    }

    public double getTasaDeRendimiento() {
        return tasaDeRendimiento;
    }

    public void setTasaDeRendimiento(double tasaDeRendimiento) {
        this.tasaDeRendimiento = tasaDeRendimiento;
    }

    @Override
    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int getNumCuenta() {
        return numCuenta;
    }

    @Override
    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    @Override
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public void depositar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("El monto del depósito debe ser mayor que cero.");
        } else {
            // Aplicar las reglas de cobro mencionadas
            if (cantidad < 500000) {
                saldo += (cantidad - 7000);
            } else if (cantidad < 2000000) {
                saldo += (cantidad - 3000 - (0.01 * cantidad));
            } else if (cantidad <= 10000000) {
                saldo += (cantidad - 2000 - (0.005 * cantidad));
            } else {
                saldo += (cantidad - (0.018 * cantidad));
            }
            System.out.println("Depósito realizado con éxito. Nuevo saldo: " + saldo);
        }
    }

    @Override
    public void retirar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("El monto del retiro debe ser mayor que cero.");
        } else if (cantidad > saldo) {
            System.out.println("Saldo insuficiente para realizar el retiro.");
        } else {
            saldo -= cantidad;
            System.out.println("Retiro realizado con éxito. Nuevo saldo: " + saldo);
        }
    }

    @Override
    public void EstadoCuenta() {
        System.out.println("\n==== ESTADO DE LA CUENTA DE AHORRO ====");
        System.out.println("Número de Cuenta: " + getNumCuenta());
        System.out.println("Nombre: " + getCliente().getNombre());
        System.out.println("Apellido: " + getCliente().getApellido());
        System.out.println("Saldo Actual: " + saldo);
    }

    @Override
    public String toString() {
        return "CuentaAhorro{" + "tasaDeRendimiento=" + tasaDeRendimiento + '}';
    }
}
