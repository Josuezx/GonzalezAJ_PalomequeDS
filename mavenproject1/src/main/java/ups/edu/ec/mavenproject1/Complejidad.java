/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ups.edu.ec.mavenproject1;

/**
 *
 * @author Usuario
 */


import java.util.Random;

public class Complejidad {

    public static void medirTiemposConArreglo(int[] arregloBase) {
       // int[] tamanos = {10, 50, 100, 500, 1000, 5000, 10000, 20000, 30000};

        medirTiempo("Burbuja con Ajustes", arregloBase, Complejidad::ordenamientoBurbujaAjuste,arregloBase);
        medirTiempo("Selección", arregloBase, Complejidad::ordenamientoSeleccion,arregloBase);
        medirTiempo("Inserción", arregloBase, Complejidad::ordenamientoInsercion,arregloBase );
    }

    public static void medirTiempo(String metodo, int[] tamanos, AlgoritmoOrdenamiento algoritmo, int[] arregloBase) {
        System.out.println("Método " + metodo);
    
        for (int tamano : tamanos) {
            int[] arregloAleatorio = generarArregloAleatorio(arregloBase,tamano); 
    
            long startTime = System.currentTimeMillis();
            algoritmo.ordenar(arregloAleatorio);
            long endTime = System.currentTimeMillis();
    
            double tiempoSegundos = (endTime - startTime) / 1000.0;
    
            System.out.printf("Con %d valores el tiempo es de %.4f seg.%n", tamano, tiempoSegundos);
        }
    
        System.out.println();
    }

    public static void ordenamientoSeleccion(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arreglo[j] < arreglo[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arreglo[i];
            arreglo[i] = arreglo[minIdx];
            arreglo[minIdx] = temp;
        }
    }

    public static void ordenamientoInsercion(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 1; i < n; i++) {
            int actual = arreglo[i];
            int j = i - 1;
            while (j >= 0 && actual < arreglo[j]) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }
            arreglo[j + 1] = actual;
        }
    }

    public static void ordenamientoBurbujaAjuste(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }

    public static int[] generarArregloAleatorio(int[] arregloBase, int tamano) {
        int[] arreglo = new int[tamano];
        Random random = new Random();
        int n = arregloBase.length;
        for (int i = 0; i < tamano; i++) {
            arreglo[i] = arregloBase[random.nextInt(n)];
        }
        return arreglo;
    }

    
    interface AlgoritmoOrdenamiento {
        void ordenar(int[] arreglo);
    }
}
