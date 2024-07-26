/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab2__herencia;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("GICELL");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        Tigo tigo = new Tigo();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        JLabel labelNumero = new JLabel("Número de Teléfono:");
        JTextField textNumero = new JTextField();
        JLabel labelNombre = new JLabel("Nombre del Cliente:");
        JTextField textNombre = new JTextField();
        JLabel labelExtra = new JLabel("Email/PIN:");
        JTextField textExtra = new JTextField();
        JLabel labelTipo = new JLabel("Tipo (IPHONE/SAMSUNG):");
        JTextField textTipo = new JTextField();

        JButton addPlanButton = new JButton("Agregar Plan");
        addPlanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numeroTel = Integer.parseInt(textNumero.getText());
                    String nombre = textNombre.getText();
                    String extra = textExtra.getText();
                    String tipo = textTipo.getText().toLowerCase();

                    if (!tipo.equals("iphone") && !tipo.equals("samsung")) {
                        throw new IllegalArgumentException("Tipo incorrecto. Debe ser 'iphone' o 'samsung'.");
                    }

                    if (nombre.matches(".*\\d.*")) {
                        throw new IllegalArgumentException("Nombre no puede contener números.");
                    }

                    if (extra.contains("@")) {
                        if (!tipo.equals("iphone")) {
                            throw new IllegalArgumentException("El tipo debe ser 'iphone' si se ingresa un email.");
                        }
                    } else {
                        if (!isNumeric(extra)) {
                            throw new IllegalArgumentException("El PIN debe ser un número.");
                        }
                        if (!tipo.equals("samsung")) {
                            throw new IllegalArgumentException("El tipo debe ser 'samsung' si se ingresa un PIN.");
                        }
                    }

                    if (tigo.búsqueda(numeroTel, extra, tipo)) {
                        JOptionPane.showMessageDialog(frame, "Número o dato extra ya existente.");
                    } else {
                        tigo.agregarPlan(numeroTel, nombre, extra, tipo);
                        JOptionPane.showMessageDialog(frame, "Plan agregado exitosamente.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "El número de teléfono debe ser un número válido.");
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage() + ". Por favor ingrese los datos correctamente.");
                }
            }
        });

        JButton pagoPlanButton = new JButton("Pago Plan");
        pagoPlanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int numeroTel = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número de teléfono:"));

                    if (!tigo.búsqueda(numeroTel, "", "")) {
                        JOptionPane.showMessageDialog(null, "Número no existe en base de datos.");
                        return;
                    }

                    int mins = Integer.parseInt(JOptionPane.showInputDialog("Ingrese minutos consumidos:"));
                    int msgs = Integer.parseInt(JOptionPane.showInputDialog("Ingrese mensajes consumidos:"));
                    double pago = tigo.pagoPlan(numeroTel, mins, msgs);
                    JOptionPane.showMessageDialog(null, "El pago mensual es: $" + pago);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Entrada no válida. Por favor, ingrese números válidos.");
                }
            }
        });

        JButton agregarAmigoButton = new JButton("Agregar Amigo");
        agregarAmigoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int numeroTel = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número de teléfono:"));
                    String pin = JOptionPane.showInputDialog("Ingrese PIN de amigo:");
                    tigo.agregarAmigo(numeroTel, pin);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "El número de teléfono y el PIN deben ser números válidos.");
                }
            }
        });

        JButton listarButton = new JButton("Listar Planes");
        listarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tigo.lista();
            }
        });

        JButton salirButton = new JButton("Salir");
        salirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel.add(labelNumero);
        panel.add(textNumero);
        panel.add(labelNombre);
        panel.add(textNombre);
        panel.add(labelExtra);
        panel.add(textExtra);
        panel.add(labelTipo);
        panel.add(textTipo);
        panel.add(addPlanButton);
        panel.add(pagoPlanButton);
        panel.add(agregarAmigoButton);
        panel.add(listarButton);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, salirButton);

        frame.setVisible(true);
    }

    // Método para verificar si una cadena es numérica
    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
