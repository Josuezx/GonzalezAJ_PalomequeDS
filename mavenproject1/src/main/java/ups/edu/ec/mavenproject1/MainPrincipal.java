/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ups.edu.ec.mavenproject1;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class MainPrincipal {
    private static int[] arregloUsuario;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Seleccione la operación:");
            System.out.println("1. Generar Arreglo y Ordenar");
            System.out.println("2. Medir Tiempos de Ejecución");
            System.out.println("0. Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    realizarOrdenamientos();
                    break;
                case 2:
                    Complejidad.medirTiemposConArreglo(arregloUsuario);
                    break;
                case 0:
                    System.out.println("Saliendo....");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }

    public static void realizarOrdenamientos() {
        Scanner scanner = new Scanner(System.in);

        // Ingresar tamaño del arreglo
        System.out.print("Ingrese el tamaño del arreglo: ");
        int n = scanner.nextInt();

        // Generar arreglo aleatorio
        Random random = new Random();
        arregloUsuario = new int[n];
        for (int i = 0; i < n; i++) {
            arregloUsuario[i] = random.nextInt(1000); // Números aleatorios entre 0 a 1000
        }

        MetodosDeOrdenamiento metodos = new MetodosDeOrdenamiento();
        metodos.realizarOrdenamientos(arregloUsuario);

    }
}

