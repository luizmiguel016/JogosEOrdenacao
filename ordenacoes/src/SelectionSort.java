import utilitarios.imprimir_vetor;

public class SelectionSort {


    public static void main(String[] args) {

        int[] vet = {3, 4, 9, 2, 5, 8, 2, 1, 7};

        ordenar(vet);

        imprimir_vetor.imprimir_int(vet);
    }

    public static void ordenar(int[] vet){
        int tamanho_vetor = vet.length;
        int indice_menor = 0;
        int aux;

        for (int i = 0; i < tamanho_vetor-1; i++) {
            indice_menor = i;

            for (int j = i; j < tamanho_vetor; j++) {
                if(vet[indice_menor] > vet[j]){
                    indice_menor = j;
                }
            }
            if(indice_menor != i){
                aux = vet[indice_menor];
                vet[indice_menor] = vet[i];
                vet[i] = aux;
            }
        }
    }
}