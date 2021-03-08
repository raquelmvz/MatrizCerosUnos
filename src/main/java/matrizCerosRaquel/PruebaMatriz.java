/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizCerosRaquel;

/**
 *
 * @author raquel
 */
public class PruebaMatriz {

    public static void main(String[] args) {

//        //creacion de una matriz con una dimension que se pasa por parametro
//        Matriz matriz = new Matriz(10);
//
//        //impresion de la matriz por pantalla
//        matriz.imprimeMatrizCuadrada();
        System.out.println("Ejemplo que se cumple siempre:");
        int[][] matriz = new int[][]{{0, 1, 1, 1, 0}, {0, 1, 0, 1, 0}, {0, 1, 1, 1, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        Matriz matrizCorrecta = new Matriz(matriz);
        matrizCorrecta.imprimeMatrizCuadrada();
        int[] coordenadas = matrizCorrecta.coordenadasCeroRodeadoPorUnos();
        System.out.println("Las coordenadas del 0 son (" + coordenadas[0] + "," + coordenadas[1] + ")");

        System.out.println("Ejemplo aleatorio");
        Matriz matrizAlea = new Matriz(15);
        matrizAlea.imprimeMatrizCuadrada();
        int[] coordenadas2 = matrizAlea.coordenadasCeroRodeadoPorUnos();
        System.out.println("Las coordenadas del 0 son (" + coordenadas2[0] + "," + coordenadas2[1] + ")");

        //la solucion de las coordenadas esta en el mismo formato que los arrays -- la fila 1 es la 0,etc
    }

}
