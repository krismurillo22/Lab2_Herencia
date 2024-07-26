/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2__herencia;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class PlanSamsung extends Plan{
    private String pin;
    private ArrayList<String> bbm;
    
    public PlanSamsung(int numeroTelefono, String nombreCliente, String pin) {
        super(numeroTelefono, nombreCliente);
        this.pin = pin;
        this.bbm = new ArrayList<>();
    }
    
    public double pagoMensual(int mins, int msgs) {
        int minExtras = mins - 200;
        int msgsExtras = msgs - 300;

        return 40 + (minExtras * 0.8) + (msgsExtras * 0.2);
    }
    
    public String imprimir(){
        return super.imprimir()+"\nPIN: "+pin;
    }
    
    public void agregarPinAmigo(String pin) {
        if (!bbm.contains(pin)) {
            bbm.add(pin);
        }
    }
    
    public String getPin() {
        return pin;
    }
}
