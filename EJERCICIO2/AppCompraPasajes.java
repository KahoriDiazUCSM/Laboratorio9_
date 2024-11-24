package ejercicio2;

import ejercicio2.controlador.CompraPasajesControlador;
import ejercicio2.vista.CompraPasajesVista;

public class AppCompraPasajes {
    public static void main(String[] args) {
   
        CompraPasajesVista vista = new CompraPasajesVista();
        

        CompraPasajesControlador controlador = new CompraPasajesControlador(vista);
    }
}
