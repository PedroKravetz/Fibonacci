package main;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Coloque qual termo da sequência fibonnacci você quer: ");
        int retorno = scanner.nextInt();
        while (retorno<1){
            System.out.println("Esse é um valor inválido.");
            System.out.println("Coloque qual termo da sequência fibonnacci você quer: ");
            retorno = scanner.nextInt();
        }
        System.out.println(fibonacciInterado(retorno));
        System.out.println(fibonacciRecursivo(retorno));

    }

    /**
     * Esse método faz o fibonacci de uma maneira interada para retornar o termo correto
     * @param termo - Termo da sequência fibonacci a ser retornado
     * @return int - Valor do termo da sequência Fibonacci
     */
    private static int fibonacciInterado(int termo) {
        if (termo==1){
            return 0;
        }
        if (termo==2){
            return 1;
        }
        int anterior1=0;
        int anterior2=1;
        int atual=0;
        while(termo-2>0){
            atual =anterior1+anterior2;
            termo--;
            anterior1=anterior2;
            anterior2=atual;
        }
        return atual;
    }

    /**
     * Esse método faz o fibonacci de uma maneira recursiva para retornar o termo correto
     * @param termo - Termo da sequência fibonacci a ser retornado
     * @return int - Valor do termo da sequência Fibonacci
     */
    private static int fibonacciRecursivo(int termo){
        if(termo==1)
            return 0;
        if (termo==2)
            return 1;
        return (fibonacciRecursivo(termo-1)+ fibonacciRecursivo(termo-2));
    }
}
