package org.jcgc.socialnetwork.DAO;

import java.sql.SQLException;
import java.util.Scanner;

public class MensajeService {

    public static void crearMensaje() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje: ");
        String mensaje = sc.nextLine();

        System.out.println("Escribe tu nombre: ");
        String nombre = sc.nextLine();

        Mensaje registro = new Mensaje();
        registro.setMensaje(mensaje);
        registro.setAutorMensaje(nombre);

        MensajeDAO.CrearMensajeDB(registro);
    }

    public static void listarMensaje() {
        MensajeDAO.leerMensajeDB();
    }

    public static void borrarMensaje() {

    }

    public static void editarMensaje() {

    }
}
