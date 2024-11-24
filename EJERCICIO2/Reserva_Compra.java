package ejercicio2.modelo;


import java.util.List;


public class Reserva_Compra {
    private Pasajero pasajero;
    private String origen;
    private String destino;
    private String piso;
    private List<String> serviciosOpcionales;
    private String calidadServicio;

    // Constructor
    public Reserva_Compra(Pasajero pasajero, String origen, String destino, String piso,
                          List<String> serviciosOpcionales, String calidadServicio) {
        this.pasajero = pasajero;
        this.origen = origen;
        this.destino = destino;
        this.piso = piso;
        this.serviciosOpcionales = serviciosOpcionales;
        this.calidadServicio = calidadServicio;
    }

    // Getters y setters
    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public List<String> getServiciosOpcionales() {
        return serviciosOpcionales;
    }

    public void setServiciosOpcionales(List<String> serviciosOpcionales) {
        this.serviciosOpcionales = serviciosOpcionales;
    }

    public String getCalidadServicio() {
        return calidadServicio;
    }

    public void setCalidadServicio(String calidadServicio) {
        this.calidadServicio = calidadServicio;
    }

    // Resumen de la reserva
    public String generarResumen() {
        StringBuilder resumen = new StringBuilder();
        resumen.append("Reserva de Pasaje:\n");
        resumen.append("Nombre: ").append(pasajero.getNombre()).append("\n");
        resumen.append("DNI: ").append(pasajero.getDni()).append("\n");
        resumen.append("Origen: ").append(origen).append("\n");
        resumen.append("Destino: ").append(destino).append("\n");
        resumen.append("Piso: ").append(piso).append("\n");
        resumen.append("Servicios Opcionales: ").append(String.join(", ", serviciosOpcionales)).append("\n");
        resumen.append("Calidad del Servicio: ").append(calidadServicio).append("\n");
        return resumen.toString();
    }
}
