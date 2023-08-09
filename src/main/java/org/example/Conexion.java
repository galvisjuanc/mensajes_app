package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3307/mensajes_app","root","");
            if(connection != null) {
                System.out.println("Conexión Exitosa");
            }
        } catch (SQLException e){
            System.out.println(e);
        }
        return connection;
    }
}
