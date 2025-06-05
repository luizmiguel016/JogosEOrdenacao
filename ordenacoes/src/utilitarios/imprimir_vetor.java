package utilitarios;

public class imprimir_vetor {

    public static void imprimir_int(int[] vet) {
        for (int i = 0; i < vet.length; i++) {
            System.out.print(vet[i] + " ");
        }
        System.out.println("");
    }

    public static void imprimir_string(String[] vet) {
        for (int i = 0; i < vet.length; i++) {
            System.out.print(vet[i] + " ");
        }
        System.out.println("");
    }

    public static void imprimir_matriz(int[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}