/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab2__herencia;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author User
 */
public class Lab2__Herencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("MENU");
        JButton BtnAgregarPlan = new JButton("Agregar Plan");
        JButton BtnPagoPlan = new JButton("Pago Plan");
        JButton BtnAgregarAmigo = new JButton("Agregar Amigo");
        JButton BtnListar = new JButton("Listar");
        JButton BtnSalir = new JButton("Salir");
        frame.setSize(500,500);
        
        
        frame.add(BtnAgregarPlan);
        frame.add(BtnPagoPlan);
        frame.add(BtnAgregarAmigo);
        frame.add(BtnListar);
        frame.add(BtnSalir);
        frame.setLayout(new GridLayout(1,3));
        
        
        
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        BtnAgregarPlan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //funcion para agregar plan
            }
        });   
        
        BtnPagoPlan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Funcion para pago plan
            }
        });
        
        BtnAgregarAmigo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //funcion para Agregar amigo
            }
        });
        
        BtnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //funcion para listar
            }
        });
        
        BtnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        
    }
   
    
    
    
}
