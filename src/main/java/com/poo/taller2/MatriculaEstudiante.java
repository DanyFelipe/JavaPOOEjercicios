/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.poo.taller2;

import java.util.Scanner;

public class MatriculaEstudiante {

    public static double calcularCostoMatricula(int semestre, boolean enLinea, int creditosPerdidos) {

        double costoMatricula = 1500;
        int costoPorCredito = 0;

        if (!enLinea) {
            if (semestre >= 1 && semestre <= 3) {
                costoPorCredito = 20;
            } else if (semestre >= 4 && semestre <= 6) {
                costoPorCredito = 25;
            } else if (semestre >= 7) {
                costoPorCredito = 30;
            }
            //Cálculo del costo total de créditos
            double costoCreditos = creditosPerdidos * costoPorCredito;
            costoMatricula += costoCreditos;
        }

        // Aplicar aumento del 5% a partir del quinto semestre para todos
        if (semestre >= 5) {
            costoMatricula *= 1.05;
        }

        return costoMatricula;
    }

    public static void imprimirRecibo(
            String nombres, String apellidos, String documento, String direccion,
            String telefono, String carrera, int semestre, boolean enLinea, int creditosPerdidos) {
        double costoMatricula = calcularCostoMatricula(semestre, enLinea, creditosPerdidos);

        System.out.println("\n=========== Recibo de Inscripción ==========");
        System.out.println("Nombre Completo: " + nombres + " " + apellidos);
        System.out.println("Documento: " + documento);
        System.out.println("Dirección: " + direccion);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Carrera: " + carrera);
        System.out.println("Semestre: " + semestre);
        System.out.println("Modalidad en línea: " + (enLinea ? "Sí" : "No"));
        System.out.println("Créditos Perdidos: " + creditosPerdidos);
        System.out.println("Costo de Matrícula: $" + costoMatricula);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int creditosPerdidos;

        System.out.println("========== Bienvenido al Sistema de Matrícula =========");

        String[] carreras = {"Ingeniería de Sistemas", "Contaduría", "Administración de Empresas"};

        try {
            System.out.println("Seleccione una carrera:");
            for (int i = 0; i < carreras.length; i++) {
                System.out.println((i + 1) + ". " + carreras[i]);
            }

            int seleccionCarrera = scanner.nextInt() - 1;

            scanner.nextLine(); // Consumir la línea en blanco

            System.out.print("Ingrese sus nombres: ");
            String nombres = scanner.nextLine();

            System.out.print("Ingrese sus apellidos: ");
            String apellidos = scanner.nextLine();

            System.out.print("Ingrese su número de documento: ");
            String documento = scanner.nextLine();

            System.out.print("Ingrese su dirección: ");
            String direccion = scanner.nextLine();

            System.out.print("Ingrese su número de teléfono: ");
            String telefono = scanner.nextLine();

            System.out.print("Ingrese el semestre en curso: ");
            int semestre = scanner.nextInt();

            System.out.print("¿Está realizando el curso en línea? (Si/No): ");
            String enLineaStr = scanner.next().toLowerCase();
            boolean enLinea = enLineaStr.equals("si");

            if (enLinea) {
                creditosPerdidos = 0;
            } else {
                System.out.print("Ingrese la cantidad de créditos perdidos: ");
                creditosPerdidos = scanner.nextInt();
            }

            String carreraSeleccionada = carreras[seleccionCarrera];

            imprimirRecibo(nombres, apellidos, documento, direccion, telefono, carreraSeleccionada, semestre, enLinea,
                    creditosPerdidos);

        } catch (Exception e) {
            System.out.print("Ingrese todos los datos correctamente, ERROR: " + e);
        } finally {
            scanner.close();
        }
    }
}
