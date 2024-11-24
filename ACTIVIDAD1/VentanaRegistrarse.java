
package actividad;


import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;


public class VentanaRegistrarse extends JFrame {
    private JTextField campoUsuario; -> Campo de texto para ingresar USUARIO
    private JPasswordField campoContrasena; -> Campo para ingresar CONTRASEÑA
    private JButton botonRegistrarse; -> Botón Registrarse


    public VentanaRegistrarse() {
        super("Registrarse"); -> Nombre de la ventana


        setLayout(new BorderLayout());


        // Ingresar Uusuario y contraseña - parte central
        JPanel panelCentral = new JPanel(new GridLayout(2, 2));
        panelCentral.add(new JLabel("Nuevo Usuario:")); Etiqueta que muestra la palabra Nuevo usuario
        campoUsuario = new JTextField();
        panelCentral.add(campoUsuario); 


        panelCentral.add(new JLabel("Nueva Contraseña:"));
        campoContrasena = new JPasswordField();
        panelCentral.add(campoContrasena);
        add(panelCentral, BorderLayout.CENTER); -> centro


        // Botón de registrar - parte inferior organización
        botonRegistrarse = new JButton("Registrar"); 
        add(botonRegistrarse, BorderLayout.SOUTH);-> sur, inferior


        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}

H
