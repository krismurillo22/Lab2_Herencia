/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2__herencia;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Dennisse
 */
public class Tigo {

    ArrayList<Plan> planes;

    public Tigo() {
        planes = new ArrayList<>();
    }

    public void agregarPlan(int numeroTel, String nombre, String extra, String tipo) {
        if (tipo.equalsIgnoreCase("IPHONE")) {
            planes.add(new PlanIPhone(numeroTel, nombre, extra));
        } else if (tipo.equalsIgnoreCase("SAMSUNG")) {
            planes.add(new PlanSamsung(numeroTel, nombre, extra));
        }
    }

    public boolean búsqueda(int numeroTel, String datoExtra, String tipo) {
        for (int i = 0; i < planes.size(); i++) {
            Plan plan = planes.get(i);
            if (plan.getNumeroTelefono() == numeroTel) {
                return true;
            }
            if (tipo.equalsIgnoreCase("IPHONE") && plan instanceof PlanIPhone) {
                if (((PlanIPhone) plan).getEmailITunes().equals(datoExtra)) {
                    return true;
                }
            } else if (tipo.equalsIgnoreCase("SAMSUNG") && plan instanceof PlanSamsung) {
                if (((PlanSamsung) plan).getPin().equals(datoExtra)) {
                    return true;
                }
            }
        }
        return false;
    }

    public double pagoPlan(int numeroTel, int mins, int msgs) {
        for (int i = 0; i < planes.size(); i++) {
            Plan plan = planes.get(i);
            if (plan.getNumeroTelefono() == numeroTel) {
                return plan.pagoMensual(mins, msgs);
            }
        }
        return -1;
    }

    public void agregarAmigo(int numeroTel, String pin) {
        for (int i = 0; i < planes.size(); i++) {
            Plan plan = planes.get(i);
            if (plan.getNumeroTelefono() == numeroTel && plan instanceof PlanSamsung) {
                ((PlanSamsung) plan).agregarPinAmigo(pin);
                return;
            }
        }
    }

    public void lista() {
        int contadorIPhone = 0;
        int contadorSamsung = 0;
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < planes.size(); i++) {
            Plan plan = planes.get(i);
            resultado.append("Número de Cliente: ").append(plan.getNumeroTelefono()).append("\n");
            resultado.append("Nombre: ").append(plan.getNombreCliente()).append("\n");
            if (plan instanceof PlanIPhone) {
                resultado.append("Email: ").append(((PlanIPhone) plan).getEmailITunes()).append("\n");
                resultado.append("Tipo: IPHONE\n");
                contadorIPhone++;
            } else if (plan instanceof PlanSamsung) {
                resultado.append("PIN: ").append(((PlanSamsung) plan).getPin()).append("\n");
                resultado.append("Tipo: SAMSUNG\n");
                contadorSamsung++;
            }
            resultado.append("\n");
        }
        resultado.append("Total iPhone: ").append(contadorIPhone).append("\n");
        resultado.append("Total Samsung: ").append(contadorSamsung).append("\n");
        JOptionPane.showMessageDialog(null, resultado.toString());
    }
}
