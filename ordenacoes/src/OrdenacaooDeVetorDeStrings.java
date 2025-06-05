import utilitarios.imprimir_vetor;

public class OrdenacaooDeVetorDeStrings {

    public static void main(String[] args) {

        String[] vet_nomes = {"bbb", "aaa", "ccc"};

        ordenar_string(vet_nomes);



    }

    public static void ordenar_string(String[] vet_nomes){
        int tamanho_vetor = vet_nomes.length;
        String aux;
        for (int i = 0; i < tamanho_vetor - 1; i++) {
            for (int j = 0; j < tamanho_vetor - 1; j++) {
                if(vet_nomes[j].compareTo(vet_nomes[j+1]) > 0){
                    aux = vet_nomes[j];
                    vet_nomes[j] = vet_nomes[j+1];
                    vet_nomes[j+1] = aux;
                }
                imprimir_vetor.imprimir_string(vet_nomes);
            }
        }
    }
}
