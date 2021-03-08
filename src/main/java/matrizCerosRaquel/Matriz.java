/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizCerosRaquel;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author raquel
 */
public class Matriz {

    private int[][] matriz;

    //Constructor de la matriz
    //se pasa la dimension por parametro
    public Matriz(int n) {
        this.matriz = devuelveMatrizCuadrada(n);
    }

    //constructor por defecto para crear una matriz de prueba
    public Matriz(int[][] matriz) {
        this.matriz = matriz;
    }

    //Getters y setters
    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    //metodo para generar valores aleatorios entre dos numeros
    private int devuelveAleatorio(int n, int m) {
        Random random = new Random();
        return random.nextInt(m - n + 1) + n;
    }

    //metodo que inicializa la matriz
    private int[][] devuelveMatrizCuadrada(int a) {
        int[][] matrizGenerada = new int[a][a];

        for (int i = 0; i < matrizGenerada.length; i++) {
            for (int j = 0; j < matrizGenerada[i].length; j++) {
                //cada elem de la matriz sera un num aleat entre 0 y 1
                matrizGenerada[i][j] = devuelveAleatorio(0, 1);
            }
        }
        return matrizGenerada;
    }

    //metodo que imprime la matriz de forma cuadrada
    public void imprimeMatrizCuadrada() {

        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[i].length; j++) {
                System.out.print(this.matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    //metodo que dadas las coordenadas de un elemento de la matriz obtenga una lista con todos los elementos que lo rodean
    private static ArrayList<Integer> obtenerNumRodean(int[][] matriz, int fila, int col) {
        ArrayList<Integer> listaADevolver = new ArrayList<>();

        //matriz con las coordenadas de los elementos que rodean a uno cualquiera
        //se van a sumar o restar para obtener las coordenadas
        int[][] coordenadas = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};

        //se recorre la matriz de las coordenadas anterior
        for (int[] coordenada : coordenadas) {
            //como tenemos el num de fila y de col del elemento que queremos (sera uno de los 0)
            //sumamos los elem de la matriz de coordenadas para 'desplazarnos' en todas direcciones

            //para las coordenadas x cogemos el primer elem y para las coord y el segundo
            int coordX = fila + coordenada[0];
            int coordY = col + coordenada[1];

            //se comprueba que la coordenada obtenida no se sale de la matriz
            if (coordX >= 0 && coordX < matriz.length) {
                if (coordY >= 0 && coordY < matriz[coordX].length) {
                    //se añade a la lista el elemento que se encuentre en cada coordenada, asi tenemos todos los numeros que rodean
                    //al elemento en una sola lista
                    listaADevolver.add(matriz[coordX][coordY]);
                }
            }
        }
        return listaADevolver;
    }

    //metodo que devuelve true o false si los elementos que se pasan son 1 o no
    //si la lista que hemos obtenido contiene un cero significa que no nos sirve como solucion
    private boolean estaRodeadoPorUnos(ArrayList<Integer> lista) {
        return !lista.contains(0);
    }

    //metodo que devuelve la solucion final de las coordenadas usando los anteriores
    public int[] coordenadasCeroRodeadoPorUnos() {

        //para guardar el resultado
        //si no hay solucion devolvera las coordenadas -1,-1
        int[] coordenadas = new int[]{-1, -1};

        //recorro la matriz en busca de 0s
        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[i].length; j++) {

                if (this.matriz[i][j] == 0 && estaRodeadoPorUnos(obtenerNumRodean(this.matriz, i, j))) {
                    coordenadas[0] = i;
                    coordenadas[1] = j;
                    //En cuanto el primer 0 cumpla la condicion me salgo del bucle
                    break;
                }
            }
        }
        return coordenadas;

    }
}
