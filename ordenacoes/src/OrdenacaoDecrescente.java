import utilitarios.imprimir_vetor;

public class OrdenacaoDecrescente {

    public static void main(String[] args) {

        int[] vet = {3, 4, 9, 2, 5, 8, 2, 1, 7};

        ordenar_decrescente(vet);
    }

    public static void ordenar_decrescente(int[] vet){
        int tamanho_vetor = vet.length;
        int aux;
        for (int i = 0; i < tamanho_vetor - 1; i++) {
            for (int j = 0; j < tamanho_vetor - 1; j++) {
                if(vet[j] < vet[j+1]){
                    aux = vet[j];
                    vet[j] = vet[j+1];
                    vet[j+1] = aux;
                }
                imprimir_vetor.imprimir_int(vet);
            }
        }
    }
}