/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poo.banco;


class CuentaCorriente extends Cuenta {
    private double tasaDeMantenimiento;
    private static final double TASA_CARGO_MENSUAL = 0.015; // 1.5% mensual
    private static final double MONTO_MINIMO_APERTURA = 200000; // 200 mil pesos

    public CuentaCorriente(double tasaDeMantenimiento, Cliente cliente, int numCuenta, double saldo) {
        super(cliente, numCuenta, saldo);
        this.tasaDeMantenimiento = tasaDeMantenimiento;
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
                saldo += (cantidad - 3000 - (0.02 * cantidad));
            } else if (cantidad <= 10000000) {
                saldo += (cantidad - 2000 - (0.02 * cantidad));
            } else {
                saldo += (cantidad - (0.033 * cantidad));
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
        System.out.println("==== ESTADO DE LA CUENTA CORRIENTE ====");
        System.out.println("Número de Cuenta: " + getNumCuenta());
        System.out.println("Nombre: " + getCliente().getNombre());
        System.out.println("Apellido: " + getCliente().getApellido());
        System.out.println("Saldo Actual: " + saldo);
    }

    @Override
    public String toString() {
        return "CuentaCorriente{" + "tasaDeMantenimiento=" + tasaDeMantenimiento + '}';
    }
}
