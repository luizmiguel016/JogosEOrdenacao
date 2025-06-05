import utilitarios.imprimir_vetor;

public class OrdenacaoParcial {

    public static void main(String[] args) {

        int[] vet = {8, 4, 3, 7, 6, 5, 2};
        int n = 4;

        ordenar_parcial(vet, n);

    }

    public static void ordenar_parcial(int[] vet, int n) {
        int aux;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (vet[j] > vet[j + 1]) {
                    aux = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = aux;
                }
                imprimir_vetor.imprimir_int(vet);
            }
        }
    }

}
