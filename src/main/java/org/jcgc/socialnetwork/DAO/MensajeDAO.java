package org.jcgc.socialnetwork.DAO;

import org.jcgc.socialnetwork.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        Conexion db_connect = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try (Connection conexion = db_connect.getConnection()) {

            String query = "SELECT * FROM mensajes;";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while(rs.next()) {
                System.out.println("ID: " + rs.getInt("id_mensaje"));
                System.out.println("Mensaje:  " + rs.getString("mensaje"));
                System.out.println("Autor: " + rs.getString("autor_mensaje"));
                System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
                System.out.println("");
            }

        } catch (SQLException e) {
            System.out.println("No se pudieron recuperar los datos");
            System.out.println(e);
        }
    }

    public static void borrarMensajeDB(int id_mensaje) {
        Conexion db_connect = new Conexion();

        try(Connection conexion = db_connect.getConnection()) {
            PreparedStatement ps = null;
            try{
                String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1,id_mensaje);
                ps.executeUpdate();
                System.out.println("El mensaje ha sido borrado");
            }catch(SQLException ex){
                System.out.println(ex);
                System.out.println("El mensaje no pudo ser borrado");
            }
        }catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void actualizarMensajeDB(Mensaje mensaje){
        Conexion db_connect = new Conexion();

        try(Connection conexion = db_connect.getConnection()) {
            PreparedStatement ps = null;
            try{
                String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getId());
                ps.executeUpdate();
                System.out.println("El mensaje ha sido actualizado correctamente.");
            }catch(SQLException ex){
                System.out.println(ex);
                System.out.println("El mensaje no pudo ser actualizado. Error: {}." + ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
