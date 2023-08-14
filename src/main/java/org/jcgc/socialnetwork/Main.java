package org.jcgc.socialnetwork;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        System.out.println("New Connection to MySQL DB!");
        Conexion conexion = new Conexion();
        try (Connection cnx = conexion.getConnection()){

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}