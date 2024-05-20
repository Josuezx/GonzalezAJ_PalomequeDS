/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ups.edu.ec.mavenproject1;

import java.util.ArrayList;

public class MetodosDeOrdenamiento {
    public void realizarOrdenamientos(int[] arreglo) {
        // Método de ordenamiento por selección
        System.out.println("\n====== Ordenamiento por Selección ======");
        ordenamientoSeleccion(arreglo.clone());

        // Método de ordenamiento por inserción
        System.out.println("\n====== Ordenamiento por Inserción ======");
        ordenamientoInsercion(arreglo.clone());

        // Método de ordenamiento burbuja con ajuste
        System.out.println("\n====== Ordenamiento Burbuja con Ajuste ======");
        ordenamientoBurbujaAjuste(arreglo.clone());
    }

    public void ordenamientoSeleccion(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            int posMenor = i;
            for (int j = i + 1; j < n; j++) {
                imprimirEstado(i + 1, arreglo, posMenor, j);
                if (arreglo[j] < arreglo[posMenor]) {
                    posMenor = j;
                }
            }
            int temp = arreglo[i];
            arreglo[i] = arreglo[posMenor];
            arreglo[posMenor] = temp;
        }

        imprimirEstado(n, arreglo, null, null);
    }

    public void ordenamientoInsercion(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 1; i < n; i++) {
            int actual = arreglo[i];
            int j = i - 1;
            while (j >= 0 && actual < arreglo[j]) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }
            arreglo[j + 1] = actual;
            imprimirEstado(i, arreglo, actual, null);
        }
        imprimirEstado(n, arreglo, null, null);
    }

    public void ordenamientoBurbujaAjuste(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                imprimirEstado(i + 1, arreglo, arreglo[j], arreglo[j + 1]);
                if (arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
        imprimirEstado(n, arreglo, null, null);
    }

    private void imprimirEstado(int iteracion, int[] arreglo, Integer valorA, Integer valorB) {
        System.out.print(iteracion + ". ");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i]);
            if (i < arreglo.length - 1) {
                System.out.print(", ");
            }
        }
        if (valorA != null || valorB != null) {
            System.out.println("   Valor A: " + (valorA != null ? valorA : "") + ", Valor B: " + (valorB != null ? valorB : ""));
        } else {
            System.out.println();
        }
    }
}
