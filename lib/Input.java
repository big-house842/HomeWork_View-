package lib;

import java.util.Random;
import java.util.Scanner;// atributo favorito

public class Input {
    final static Scanner LER = new Scanner(System.in);
    final static Random GERADOR = new Random();

    public static int[][] LerMatriz(int num_Linhas, int num_Colunas) {
        int[][] matriz = new int[num_Linhas][num_Colunas];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = LER.nextInt();
            }
        }

        return matriz;
    }

    public static int[] LerVetor(int num_Colunas) {
        int[] vetor = new int[num_Colunas];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = LER.nextInt();
        }

        return vetor;
    }

    public static int LerNumero() {
        return LER.nextInt();
    }

    public static int[][] GerarMatriz(int num_Linhas, int num_Colunas, int lim_Inf, int lim_Sup) {
        int[][] matriz = new int[num_Linhas][num_Colunas];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = GERADOR.nextInt(lim_Sup - lim_Inf) + lim_Inf;
            }
        }

        return matriz;
    }

    public static int[] GerarVetor(int num_Colunas, int lim_Inf, int lim_Sup) {
        int[] vetor = new int[num_Colunas];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = GERADOR.nextInt(lim_Sup - lim_Inf) + lim_Inf;
        }

        return vetor;
    }

    public static int GerarNumero(int lim_Inf, int lim_Sup) {
        return GERADOR.nextInt(lim_Sup - lim_Inf) + lim_Inf;
    }

    public static String LerString() {
        return LER.next();
    }

    public static boolean Has() {
        return LER.hasNextLine();
    }

}