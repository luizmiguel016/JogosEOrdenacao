import utilitarios.imprimir_vetor;

public class MargeSort {

    public static void main(String[] args) {
        
        int[] vet = {3, 4, 9, 2, 5, 8, 2, 1, 7};
        int[] aux = new int[vet.length];

        ordenar(vet, aux, 0, vet.length-1);

        imprimir_vetor.imprimir_int(vet);
        
    }

    public static void ordenar(int[] vet, int[] aux, int inicio, int fim){
        int meio = (inicio + fim) / 2;

        if(inicio < fim){
            ordenar(vet, aux, inicio, meio);
            ordenar(vet, aux, meio+1, fim);
            intercalar(vet, aux, inicio, meio, fim);
        }
    }
    
    public static void intercalar(int[] vet, int[] aux, int inicio, int meio, int fim){
        for (int i=inicio = 0; i <= fim; i++) {
            aux[i] = vet[i];
        }
        int left = inicio;
        int right = meio+1;

        for (int i = inicio; i <= fim; i++) {
            if(left > meio){
                vet[i] = aux[right++];
            }
            else if (right > fim) {
                vet[i] = aux[left++];
            }
            else if (aux[left] < aux[right]) {
                vet[i] = aux[left++];
            }
            else {
                vet[i] = aux[right++];
            }
        }
        
    }
    
}
