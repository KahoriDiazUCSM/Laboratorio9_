package ejercicio2.controlador;


import ejercicio2.modelo.Pasajero;
import ejercicio2.modelo.Reserva_Compra;
import ejercicio2.vista.CompraPasajesVista;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
        // Validar campos obligatorios
        String nombre = vista.nombreField.getText();
        String dni = vista.dniField.getText();
        String fechaViaje = vista.fechaViajeField.getText();


        // Validar nombre
        if (nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "El nombre no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }


        // Validar DNI
        if (!validarDNI(dni)) {
            return;
        }


        // Validar fecha de viaje
        if (!validarFechaViaje(fechaViaje)) {
            return;
        }


        // Validar que se haya seleccionado un piso
        if (!vista.primerPiso.isSelected() && !vista.segundoPiso.isSelected()) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar un piso.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }


        // Validar que se haya seleccionado una calidad de servicio
        if (vista.servicioList.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una calidad de servicio.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }


        // Si todas las validaciones pasan, generar el resumen
        Pasajero pasajero = new Pasajero(nombre, dni);
        String origen = (String) vista.origenn.getSelectedItem();
        String destino = (String) vista.destinoo.getSelectedItem();
        String piso = vista.primerPiso.isSelected() ? "1er Piso" : "2do Piso";
        List<String> servicios = new ArrayList<>();
        if (vista.servicioAudifonos.isSelected()) servicios.add("Audífonos");
        if (vista.servicioManta.isSelected()) servicios.add("Manta");
        if (vista.servicioRevistas.isSelected()) servicios.add("Revistas");
        String calidadServicio = vista.servicioList.getSelectedValue();


        Reserva_Compra reserva = new Reserva_Compra(pasajero, origen, destino, piso, servicios, calidadServicio);
        JOptionPane.showMessageDialog(vista, reserva.generarResumen());
    }


    private boolean validarDNI(String dni) {
        DNI dniObj = new DNI(dni);
        if (!dniObj.validarDNI()) {
            JOptionPane.showMessageDialog(vista, "El DNI debe contener exactamente 8 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }


    private boolean validarFechaViaje(String fechaViaje) {
        // Verificar que la fecha tenga el formato DD/MM/AAAA
        if (!fechaViaje.matches("\\d{2}/\\d{2}/\\d{4}")) {
            JOptionPane.showMessageDialog(vista, "La fecha de viaje debe tener el formato DD/MM/AAAA.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }


        // Separar los componentes de la fecha
        String[] partes = fechaViaje.split("/");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int anio = Integer.parseInt(partes[2]);


        // Validar la fecha utilizando la clase Fecha
        Fecha fecha = new Fecha(dia, mes, anio);
        if (!fecha.validarFecha()) {
            JOptionPane.showMessageDialog(vista, "La fecha de viaje no es válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }


        return true;
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
