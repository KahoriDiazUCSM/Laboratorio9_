package actividad;


import javax.swing.*;
import java.awt.GridLayout;


public class VentanaIngresar extends JFrame {
    private JTextField campoUsuario; -> Campo de texto para ingresar USUARIO
    private JPasswordField campoContrasena;-> Campo para ingresar CONTRASEÑA
    private JButton btnEntrar; -> Botón ENTRAR


    public VentanaIngresar() {
        super("Ingresar");  -> Nombre de la ventana


        setLayout(new GridLayout(6, 2)); -> GridLayout con 6 filas y 2 columnas para distribuir etiquetas, campos de texto y un botón


        add(new JLabel("Usuario:")); -> Etiqueta que muestra la palabra usuario
        campoUsuario = new JTextField();
        add(campoUsuario);


        add(new JLabel("Contraseña:")); -> Etiqueta que muestra la palabra contraseña
        campoContrasenia = new JPasswordField();
        add(campoContrasenia);


        // Botón de entrar
        btnEntrar = new JButton("Entrar");
        add(btnEntrar);


        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
