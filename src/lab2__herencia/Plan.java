/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2__herencia;

/**
 *
 * @author User
 */
public abstract class Plan {
    protected int numeroTelefono;
    protected String nombreCliente;
    
    public Plan(int numeroTelefono, String nombreCliente) {
        this.numeroTelefono = numeroTelefono;
        this.nombreCliente = nombreCliente;
    }

    public int getNumeroTelefono() {
        return numeroTelefono;
    }
    
    public String getNombreCliente() {
        return nombreCliente;
    }
    
    public abstract double pagoMensual(int mins, int msgs);

    public String imprimir() {
        return "Número de Teléfono: " + numeroTelefono + "\nNombre del Cliente:" + nombreCliente;
    }
}
