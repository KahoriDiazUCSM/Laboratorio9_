package ejercicio2.vista;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.*;

public class CompraPasajesVista extends JFrame {
    // Componentes para el formulario
    public JTextField nombreField;
    public JTextField dniField;
    public JTextField fechaViajeField;
    public JComboBox<String> origenn;
    public JComboBox<String> destinoo;
    public JRadioButton primerPiso;
    public JRadioButton segundoPiso;
    public ButtonGroup grupoPiso;
    public JCheckBox servicioAudifonos;
    public JCheckBox servicioManta;
    public JCheckBox servicioRevistas;
    public JList<String> servicioList;
    public JButton botonResumen;
    public JButton botonReiniciar;

    // Constructor
    public CompraPasajesVista() {
        setTitle("Compra de Pasajes");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 2));

        // Nombre
        add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        add(nombreField);

        // DNI
        add(new JLabel("DNI:"));
        dniField = new JTextField();
        add(dniField);

        // Fecha de viaje
        add(new JLabel("Fecha de Viaje:"));
        fechaViajeField = new JTextField();
        add(fechaViajeField);

        // Origen
        add(new JLabel("Origen:"));
        origenn = new JComboBox<>(new String[]{"Arequipa", "Lima", "Cusco"});
        add(origenn);

        // Destino
        add(new JLabel("Destino:"));
        destinoo = new JComboBox<>(new String[]{"Ayacucho", "Ica", "Puno"});
        add(destinoo);

        // Piso
        add(new JLabel("Piso:"));
        primerPiso = new JRadioButton("1er Piso");
        segundoPiso = new JRadioButton("2do Piso");
        grupoPiso = new ButtonGroup();
        grupoPiso.add(primerPiso);
        grupoPiso.add(segundoPiso);
        JPanel pisoPanel = new JPanel(new FlowLayout());
        pisoPanel.add(primerPiso);
        pisoPanel.add(segundoPiso);
        add(pisoPanel);

        // Servicios extra
        add(new JLabel("Servicios Extras:"));
        servicioAudifonos = new JCheckBox("Audífonos");
        servicioManta = new JCheckBox("Manta");
        servicioRevistas = new JCheckBox("Revistas");
        JPanel serviciosPanel = new JPanel(new FlowLayout());
        serviciosPanel.add(servicioAudifonos);
        serviciosPanel.add(servicioManta);
        serviciosPanel.add(servicioRevistas);
        add(serviciosPanel);

        // Calidad del servicio
        add(new JLabel("Calidad del Servicio:"));
        servicioList = new JList<>(new String[]{"Económicoo", "Ejecutivo", "VIP"});
        add(new JScrollPane(servicioList));

        // Botones
        botonResumen = new JButton("Mostrar Resumen");
        botonReiniciar = new JButton("Reiniciar");
        add(botonResumen);
        add(botonReiniciar);

        setVisible(true);
    }
}
