import utilitarios.imprimir_vetor;

public class OrdenacaoEmMatrizes {

    public static void main(String[] args) {

        int[][] matriz = {
                {3, 2, 1},
                {6, 5, 4},
                {9, 8, 7}
        };

        ordenar_matriz(matriz);


        imprimir_vetor.imprimir_matriz(matriz);
    }

    public static void ordenar_matriz(int[][] matriz){
        int aux;

        for (int i = 0; i < matriz.length; i++) {
            int colunas = matriz[i].length;

            for (int j = 0; j < colunas - 1; j++) {
                for (int k = 0; k < colunas - 1; k++) {
                    if(matriz[i][k] > matriz[i][k + 1]){
                        aux = matriz[i][k];
                        matriz[i][k] = matriz[i][k + 1];
                        matriz[i][k + 1] = aux;
                    }
                }
            }
        }
    }

}
