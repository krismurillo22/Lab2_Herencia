/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2__herencia;

/**
 *
 * @author User
 */
public abstract class PlanIPhone extends Plan {
    private String emailITunes;
    
    public PlanIPhone(int numeroTelefono, String nombreCliente, String emailITunes) {
        super(numeroTelefono, nombreCliente);
        this.emailITunes = emailITunes;
    }
    
    public double pagoMensual(int mins, int msgs) {
        return 22 + (mins * 0.4) + (msgs * 0.1);
    }
    
    public String imprimir() {
        return super.imprimir() + "Email de iTunes: " + emailITunes;
    }
    
    public String getEmailITunes() {
        return emailITunes;
    }
    
}
