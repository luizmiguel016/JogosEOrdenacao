import java.util.Random;

public class Torneio {

    public static void main(String[] args) {
        int tamanho = 1000;

        int[] vetor_ordenado = gerar_vetor_ordenado(tamanho);
        int[] vetor_invertido = gerar_vetor_invertido(tamanho);
        int[] vetor_aleatorio = gerar_vetor_aleatorio(tamanho);


        testar_algoritmos("Vetor Ordenado", vetor_ordenado);
        testar_algoritmos("Vetor Invertido", vetor_invertido);
        testar_algoritmos("Vetor Aleatório", vetor_aleatorio);
    }

    public static int[] gerar_vetor_ordenado(int tamanho) {
        int[] vet = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vet[i] = i;
        }
        return vet;
    }

    public static int[] gerar_vetor_invertido(int tamanho) {
        int[] vet = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vet[i] = tamanho - i;
        }
        return vet;
    }

    public static int[] gerar_vetor_aleatorio(int tamanho) {
        int[] vet = new int[tamanho];
        Random rand = new Random();
        for (int i = 0; i < tamanho; i++) {
            vet[i] = rand.nextInt(10000);
        }
        return vet;
    }

    public static void testar_algoritmos(String nome, int[] vetorOriginal) {
        System.out.println("Tipo de vetor: " + nome);

        long tempo_bubble = medir_tempo(vetorOriginal, "bubble");
        long tempo_insertion = medir_tempo(vetorOriginal, "insertion");
        long tempo_selection = medir_tempo(vetorOriginal, "selection");

        System.out.println("Bubble Sort:    " + tempo_bubble + " ns");
        System.out.println("Insertion Sort: " + tempo_insertion + " ns");
        System.out.println("Selection Sort: " + tempo_selection + " ns");

        String vencedor = "Bubble Sort";
        long menorTempo = tempo_bubble;

        if (tempo_insertion < menorTempo) {
            vencedor = "Insertion Sort";
            menorTempo = tempo_insertion;
        }

        if (tempo_selection < menorTempo) {
            vencedor = "Selection Sort";
        }

        System.out.println("→ Vencedor: " + vencedor + "\n");
    }

    public static long medir_tempo(int[] vetor_original, String tipo) {
        int[] copia = vetor_original.clone();
        long inicio = System.nanoTime();

        switch (tipo) {
            case "bubble":
                bubbleSort(copia);
                break;
            case "insertion":
                insertionSort(copia);
                break;
            case "selection":
                selectionSort(copia);
                break;
        }

        long fim = System.nanoTime();
        return fim - inicio;
    }

    public static void bubbleSort(int[] vet) {
        int aux;
        for (int i = 0; i < vet.length - 1; i++) {
            for (int j = 0; j < vet.length - 1 - i; j++) {
                if (vet[j] > vet[j + 1]) {
                    aux = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = aux;
                }
            }
        }
    }

    public static void insertionSort(int[] vet) {
        for (int i = 1; i < vet.length; i++) {
            int chave = vet[i];
            int j = i - 1;
            while (j >= 0 && vet[j] > chave) {
                vet[j + 1] = vet[j];
                j--;
            }
            vet[j + 1] = chave;
        }
    }

    public static void selectionSort(int[] vet) {
        for (int i = 0; i < vet.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < vet.length; j++) {
                if (vet[j] < vet[menor]) {
                    menor = j;
                }
            }
            int temp = vet[menor];
            vet[menor] = vet[i];
            vet[i] = temp;
        }
    }
}
