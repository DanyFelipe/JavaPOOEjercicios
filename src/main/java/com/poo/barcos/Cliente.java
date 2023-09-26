
package com.poo.barcos;

public class Cliente {
    
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private Barco barco;

    public Cliente(String nombre, String apellido, String cedula, String telefono, Barco barco) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.barco = barco;
    }

    public Cliente() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public Barco getBarco() {
        return barco;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", telefono=" + telefono + ", barco=" + barco + '}';
    }
}
