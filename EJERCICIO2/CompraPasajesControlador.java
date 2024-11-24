package ejercicio2.controlador;


import ejercicio2.modelo.Pasajero;
import ejercicio2.modelo.Reserva_Compra;
import ejercicio2.vista.CompraPasajesVista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class CompraPasajesControlador {
    private CompraPasajesVista vista;

    public CompraPasajesControlador(CompraPasajesVista vista) {
        this.vista = vista;

        // Botón de resumen -> acción
        vista.botonResumen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarResumen();
            }
        });

        // Botón de reiniciar
        vista.botonReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reiniciarCampos();
            }
        });
    }

    private void mostrarResumen() {
        // Obtener datos de la vista
        String nombre = vista.nombreField.getText();
        String dni = vista.dniField.getText();
        String fechaViaje = vista.fechaViajeField.getText();
        String origen = (String) vista.origenn.getSelectedItem();
        String destino = (String) vista.destinoo.getSelectedItem();
        String piso = vista.primerPiso.isSelected() ? "1er Piso" : "2do Piso";

        // Servicios opcionales
        List<String> servicios = new ArrayList<>();
        if (vista.servicioAudifonos.isSelected()) servicios.add("Audífonos");
        if (vista.servicioManta.isSelected()) servicios.add("Manta");
        if (vista.servicioRevistas.isSelected()) servicios.add("Revistas");

        // Calidad del servicio
        String calidadServicio = vista.servicioList.getSelectedValue();

        // Modelo de pasajero y reserva
        Pasajero pasajero = new Pasajero(nombre, dni);
        Reserva_Compra reserva = new Reserva_Compra(pasajero, origen, destino, piso, servicios, calidadServicio);

        // R resumen en un cuadro de diálogo
        JOptionPane.showMessageDialog(vista, reserva.generarResumen());
    }

    private void reiniciarCampos() {
        vista.nombreField.setText("");
        vista.dniField.setText("");
        vista.fechaViajeField.setText("");
        vista.origenn.setSelectedIndex(0);
        vista.destinoo.setSelectedIndex(0);
        vista.grupoPiso.clearSelection();
        vista.servicioAudifonos.setSelected(false);
        vista.servicioManta.setSelected(false);
        vista.servicioRevistas.setSelected(false);
        vista.servicioList.clearSelection();
    }
}
