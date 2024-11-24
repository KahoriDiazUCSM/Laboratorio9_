package actividad;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;


public class VentanaInicio extends JFrame {
    private JButton botonIngresar; -> Botón Ingresar usa JButton
    private JButton botonRegistrarse; -> Botón Registrarse usa JButton


    public VentanaInicio() {
        super("Ingresar o Registrarse"); -> Nombre de la ventana 

        setLayout(new FlowLayout());
        
        //Botón Ingresar - > Evento Ingresar-Ventana Ingresar

        botonIngresar = new JButton("Ingresar");
        botonIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent EventoIngresar) {
                VentanaIngresar ventanaIngresar1 = new VentanaIngresar();
                ventanaIngresar1.setVisible(true);
            }
        }
        );
        add(botonIngresar);

        //Botón Registrarse- > Evento Registrarse -Ventana Registrarse


        botonRegistrarse = new JButton("Registrarse");
        botonRegistrarse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent EventoRegistrarse) {
                VentanaRegistrarse ventanaRegistrarse1 = new VentanaRegistrarse();
                ventanaRegistrarse1.setVisible(true);
            }
        }
        );
        add(botonRegistrarse);


        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
