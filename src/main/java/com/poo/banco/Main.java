package com.poo.banco;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CuentaAhorro ch = null;
        CuentaCorriente cc = null;

        while (true) {

            System.out.println("\n==== MENÚ PRINCIPAL ====");
            System.out.println("1. Apertura de Cuenta de Ahorro");
            System.out.println("2. Apertura de Cuenta Corriente");
            System.out.println("3. Realizar Depósito");
            System.out.println("4. Realizar Retiro");
            System.out.println("5. Estado de la cuenta");
            System.out.println("6. Salir");

            System.out.print("Ingrese su opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la línea en blanco

            switch (opcion) {
                case 1:
                    ch = abrirCuentaDeAhorro(scanner);
                    break;
                case 2:
                    cc = abrirCuentaCorriente(scanner);
                    break;
                case 3:
                    Depositos(scanner,ch,cc);
                    break;
                case 4:
                    Retiros(scanner, ch, cc);
                    break;
                case 5:
                    EstadoCuenta(ch, cc);
                    break;
                case 6:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }
    private static void EstadoCuenta( CuentaAhorro ch, CuentaCorriente cc){
        
        ch.EstadoCuenta();
    }
    
    private static void Retiros(Scanner scanner, CuentaAhorro ch, CuentaCorriente cc) {

        int deposito;
        boolean bucle = true;
        
        while (bucle) {
            System.out.println("\n==== RETIROS ====");
            System.out.println("1. Retiros de Cuenta de Ahorro");
            System.out.println("2. Retiros de Cuenta Corriente");
            System.out.println("3. Volver");

            System.out.print("Ingrese su opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\nValor a retirar: ");
                    deposito = scanner.nextInt();
                    
                    ch.retirar(deposito);
                    break;
                case 2:
                    System.out.println("\nValor a retirar: ");
                    deposito = scanner.nextInt();
                    
                    cc.retirar(deposito);
                    break;
                case 3:
                    bucle = false;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private static void Depositos(Scanner scanner, CuentaAhorro ch, CuentaCorriente cc) {

        int deposito;
        boolean bucle = true;
        
        while (bucle) {
            System.out.println("\n==== DEPOSITOS ====");
            System.out.println("1. Depositos de Cuenta de Ahorro");
            System.out.println("2. Depositos de Cuenta Corriente");
            System.out.println("3. Volver");
            

            System.out.print("Ingrese su opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\nValor a depositar: ");
                    deposito = scanner.nextInt();
                    
                    ch.depositar(deposito);
                    break;
                case 2:
                    System.out.println("\nValor a depositar: ");
                    deposito = scanner.nextInt();
                    
                    cc.depositar(deposito);
                    break;
                case 3:
                    bucle = false;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }
    

    private static CuentaAhorro abrirCuentaDeAhorro(Scanner scanner) {

        System.out.println("\n==== APERTURA DE CUENTA DE AHORRO ====");

        Cliente cliente = solicitarDatosCliente(scanner);

        System.out.print("Ingrese un numero de cuenta: ");
        int numCuenta = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el saldo inicial: ");
        double saldoInicial = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Ingrese la tasa de rendimiento anual (porcentaje): ");
        double tasaDeRendimiento = scanner.nextDouble() / 100; // Convertir a decimal
        scanner.nextLine();

        CuentaAhorro cuentaAhorro = new CuentaAhorro(tasaDeRendimiento, cliente, numCuenta, saldoInicial);

        System.out.println("Cuenta de Ahorro abierta exitosamente.");

        return cuentaAhorro;
    }

    private static CuentaCorriente abrirCuentaCorriente(Scanner scanner) {
        System.out.println("\n==== APERTURA DE CUENTA CORRIENTE ====");

        Cliente cliente = solicitarDatosCliente(scanner);

        System.out.print("Ingrese un numero de cuenta: ");
        int numCuenta = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el saldo inicial: ");
        double saldoInicial = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Ingrese la tasa de mantenimiento mensual (porcentaje): ");
        double tasaDeMantenimiento = scanner.nextDouble() / 100; // Convertir a decimal
        scanner.nextLine();
        
        

        CuentaCorriente cuentaCorriente = new CuentaCorriente(tasaDeMantenimiento, cliente, numCuenta, saldoInicial);

        System.out.println("Cuenta Corriente abierta exitosamente.");

        return cuentaCorriente;
    }

    private static Cliente solicitarDatosCliente(Scanner scanner) {
        
        String nombres = null, apellidos = null;
        
        System.out.print("Ingrese su edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        if (edad < 18) {
            System.out.print("Ingrese el nombre del representante: ");
            nombres = scanner.nextLine();
            System.out.print("Ingrese el apellido del representante: ");
            apellidos = scanner.nextLine();
        } else {
            System.out.print("Ingrese su nombre: ");
            nombres = scanner.nextLine();
            System.out.print("Ingrese su apellido: ");
            apellidos = scanner.nextLine();
        }
        return new Cliente(nombres, apellidos, edad);
    }
}
