package org.jcgc.socialnetwork.DAO;

import org.jcgc.socialnetwork.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MensajeDAO {

    public static void CrearMensajeDB(Mensaje mensaje) throws SQLException {
        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.getConnection()) {
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO mensajes (mensaje, autor_mensaje) VALUES (?,?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutorMensaje());
                ps.executeUpdate();
                System.out.println("Mensaje creado exitosamente");
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void leerMensajeDB() {

    }

    public static void borrarMensajeDB(int id) {

    }

    public static void actualizarMensajeDB(Mensaje mensaje){

    }
}
