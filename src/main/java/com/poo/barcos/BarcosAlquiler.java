/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poo.barcos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GAMER
 */
public class BarcosAlquiler {
    
    public static void main(String[] args) {
        
        try {
            Scanner scanner = new Scanner(System.in);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            
            Barco barco = obtenerDatosBarco(scanner);
            Cliente cliente = obtenerDatosCliente(scanner, barco);
            
            Date fechaInicial = obtenerFecha("Ingrese la fecha inicial de alquiler (YYYY-MM-DD): ", dateFormat, scanner);
            Date fechaFinal = obtenerFecha("Ingrese la fecha final de alquiler (YYYY-MM-DD): ", dateFormat, scanner);
            
            System.out.print("Ingrese la posición del amarre: ");
            int posicionAmarre = scanner.nextInt();
            scanner.nextLine();

            Alquiler alquiler = new Alquiler(cliente, fechaInicial, fechaFinal, posicionAmarre);
            
            //Imprimir recibo
            alquiler.imprimirRecibo();
            
        } catch (ParseException ex) {
            Logger.getLogger(BarcosAlquiler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static Date obtenerFecha(String mensaje, SimpleDateFormat dateFormat, Scanner scanner) throws ParseException {
        Date fecha = null;
        boolean fechaValida = false;

        while (!fechaValida) {
            System.out.print(mensaje);
            String fechaStr = scanner.nextLine();

            try {
                fecha = dateFormat.parse(fechaStr);
                fechaValida = true;
            } catch (ParseException e) {
                System.err.println("Error: Formato de fecha incorrecto. Utilice DD/MM/YYYY.");
            }
        }

        return fecha;
    }
    
    private static Cliente obtenerDatosCliente(Scanner scanner, Barco barco) {
        
        System.out.print("\n====== DATOS DEL CLIENTE ======\n");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Cedula: ");
        String cedula = scanner.nextLine();
        System.out.print("Telefono: ");
        String telefono = scanner.nextLine();
        
        return new Cliente(nombre, apellido, cedula, telefono, barco);
    }
    private static Barco obtenerDatosBarco(Scanner scanner) {
        
        System.out.print("\n====== DATOS DEL BARCO ======\n");
        System.out.print("Ingrese la matrícula del barco: ");
        String matriculaBarco = scanner.nextLine();
        System.out.print("Ingrese la eslora del barco en metros: ");
        double esloraMetros = scanner.nextDouble();
        System.out.print("Ingrese el año de fabricación del barco: ");
        int anoFabricacion = scanner.nextInt();
        scanner.nextLine();
        
        return new Barco(matriculaBarco, esloraMetros, anoFabricacion);
    }
}
