import utilitarios.imprimir_vetor;

public class ClassificacaoDeNotas {

    public static void main(String[] args) {
        int[] notas = {85, 70, 95, 60, 75, 80};

        ordenar_notas(notas);

        System.out.print("Notas Ordenadas: ");
        imprimir_vetor.imprimir_int(notas);

        double mediana = calcular_mediana(notas);
        System.out.println("Mediana: " + mediana);
    }

    public static void ordenar_notas(int[] vet) {
        int tamanho = vet.length;
        int aux;

        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho - 1; j++) {
                if (vet[j] > vet[j + 1]) {
                    aux = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = aux;
                }
            }
        }
    }

    public static double calcular_mediana(int[] vet) {
        int meio = vet.length / 2;

        if (vet.length % 2 == 0) {
            return (vet[meio - 1] + vet[meio]) / 2.0;
        }
        else {
            return vet[meio];
        }
    }
}