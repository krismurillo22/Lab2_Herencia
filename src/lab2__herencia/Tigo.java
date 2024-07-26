/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2__herencia;

import java.util.ArrayList;
/**
 *
 * @author Dennisse
 */
public class Tigo {

    private ArrayList<Plan> planes;

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
            }
        }
    }

    public void lista() {
        int contadorIPhone = 0;
        int contadorSamsung = 0;
        for (int i = 0; i < planes.size(); i++) {
            Plan plan = planes.get(i);
            plan.imprimir();
            if (plan instanceof PlanIPhone) {
                contadorIPhone++;
            } else if (plan instanceof PlanSamsung) {
                contadorSamsung++;
            }
        }
        String mensaje1 = "Total iPhone: " + contadorIPhone;
        String mensaje2 = "Total Samsung: " + contadorSamsung;
        System.out.println(mensaje1);
        System.out.println(mensaje2);
    }
}
