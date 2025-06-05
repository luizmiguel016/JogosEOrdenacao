import utilitarios.imprimir_vetor;

public class InsertionSort {

    public static void main(String[] args) {

        int[] vet = {3, 4, 9, 2, 5, 8, 2, 1, 7};

        ordenar(vet);

    }

    public static void ordenar(int[] vet){
        int tamanho_vetor = vet.length;
        int chave;

        for (int i = 0; i < tamanho_vetor; i++) {
            int j = i - 1;
            chave = vet[i];

            while(j >= 0 && vet[j] > chave){
                vet[j + 1] = vet[j];

                j--;
            }
            vet[j + 1] = chave;
            imprimir_vetor.imprimir_int(vet);
        }
    }

}
