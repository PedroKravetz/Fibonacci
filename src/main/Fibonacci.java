package main;

import java.util.Scanner;

public class Fibonacci {
    private static final int[][] MATRIZFIBONACCI = new int[][]{{0, 1}, {1, 1}};
    private static final int[][] MATRIZI = new int[][]{{1, 0}, {0, 1}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Coloque qual termo da sequência fibonnacci você quer: ");
        int retorno = scanner.nextInt();
        while (retorno < 0) {
            System.out.println("Esse é um valor inválido.");
            System.out.println("Coloque qual termo da sequência fibonnacci você quer: ");
            retorno = scanner.nextInt();
        }
        long start = System.nanoTime();
        System.out.println("Fibonacci Recursivo: " + fibonacciRecursivo(retorno));
        long elapsed = System.nanoTime() - start;
        System.out.println("Tempo em NanoSegundos: " + elapsed);

        start = System.nanoTime();
        System.out.println("Fibonacci Interado: " + fibonacciInterado(retorno));
        elapsed = System.nanoTime() - start;
        System.out.println("Tempo em NanoSegundos: " + elapsed);

        start = System.nanoTime();
        System.out.println("Fibonacci Log(n): " + fibonacciLogn(retorno));
        elapsed = System.nanoTime() - start;
        System.out.println("Tempo em NanoSegundos: " + elapsed);

        scanner.close();
    }

    /**
     * Esse método faz o fibonacci de uma maneira interada para retornar o termo correto
     *
     * @param termo - Termo da sequência fibonacci a ser retornado
     * @return int - Valor do termo da sequência Fibonacci
     */
    private static int fibonacciInterado(int termo) {
        if (termo == 0) return 0;
        if (termo == 1) return 1;
        int anterior1 = 0;
        int anterior2 = 1;
        int atual = 0;
        while (termo - 2 >= 0) {
            atual = anterior1 + anterior2;
            termo--;
            anterior1 = anterior2;
            anterior2 = atual;
        }
        return atual;
    }

    /**
     * Esse método faz o fibonacci de uma maneira recursiva para retornar o termo correto
     *
     * @param termo - Termo da sequência fibonacci a ser retornado
     * @return int - Valor do termo da sequência Fibonacci
     */
    private static int fibonacciRecursivo(int termo) {
        if (termo == 0) return 0;
        if (termo == 1) return 1;
        return (fibonacciRecursivo(termo - 1) + fibonacciRecursivo(termo - 2));
    }

    /**
     * Esse método faz o fibonacci em log(n) para retornar o termo correto
     *
     * @param termo - Termo da sequência fibonacci a ser retornado
     * @return int - Valor do termo da sequência Fibonacci
     */
    private static int fibonacciLogn(int termo) {
        if (termo == 0) return 0;
        if (termo == 1) return 1;
        int[][] mat = multLogn(MATRIZFIBONACCI, termo - 1);
        return mat[1][1];
    }

    /**
     * Esse método multiplica a Matriz 1 pela 2
     *
     * @param matriz1 - Matriz de multiplicação do lado esquerdo
     * @param matriz2 - Matriz de multiplicação do lado direito
     * @return int[][] - Valor da multiplicação das matrizes
     */
    private static int[][] multiplicaMatriz(int[][] matriz1, int[][] matriz2) {
        int[][] matrizAux = new int[2][2];
        matrizAux[0][0] = (matriz1[0][0] * matriz2[0][0]) + (matriz1[0][1] * matriz2[1][0]);
        matrizAux[0][1] = (matriz1[0][0] * matriz2[0][1]) + (matriz1[0][1] * matriz2[1][1]);
        matrizAux[1][0] = (matriz1[1][0] * matriz2[0][0]) + (matriz1[1][1] * matriz2[1][0]);
        matrizAux[1][1] = (matriz1[1][0] * matriz2[0][1]) + (matriz1[1][1] * matriz2[1][1]);
        return matrizAux;
    }

    /**
     * Esse método retorna a matriz elevada a n
     *
     * @param matriz - Matriz que será multiplicada
     * @param n      - A exponenciação da matriz
     * @return int[][] - Valor da matriz elevada a n
     */
    private static int[][] multLogn(int[][] matriz, int n) {
        int[][] matrizaux;
        if (n == 0) return MATRIZI;
        if (n % 2 == 0) {
            matrizaux = multiplicaMatriz(matriz, matriz);
            return multLogn(matrizaux, n / 2);
        } else {
            return multiplicaMatriz(matriz, multLogn(matriz, n - 1));
        }
    }
}
