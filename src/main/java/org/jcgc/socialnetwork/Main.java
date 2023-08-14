package org.jcgc.socialnetwork;

import java.util.Scanner;
import org.jcgc.socialnetwork.DAO.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("-------------------------------");
            System.out.println("Aplicacion de Mensajes");
            System.out.println("1. Crear Mensajes");
            System.out.println("2. Listar Mensajes");
            System.out.println("3. Editar Mensajes");
            System.out.println("4. Eliminar Mensajes");
            System.out.println("5. Salir");
            System.out.println("\nOpcion a elegir --> ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> MensajeService.crearMensaje();
                case 2 -> MensajeService.listarMensaje();
                case 3 -> MensajeService.editarMensaje();
                case 4 -> MensajeService.borrarMensaje();
                case 5 -> System.out.println("Ha llegado al final del programa. Gracias!");
                default -> System.out.println("Ha digitado un número erroneo. Intentelo de nuevo :)");

            }
        } while (opcion != 5) ;


    }
}