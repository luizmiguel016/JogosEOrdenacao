import java.util.Random;

public class ComparacaoDeDesempenho {

    public static void main(String[] args) {
        int[] tamanhos = {10000, 50000, 100000};

        for (int tamanho : tamanhos) {
            System.out.println("\n\n### TAMANHO DO VETOR: " + tamanho + " ###");

            int[] ordenado = new int[tamanho];
            for (int i = 0; i < tamanho; i++) {
                ordenado[i] = i;
            }

            int[] invertido = new int[tamanho];
            for (int i = 0; i < tamanho; i++) {
                invertido[i] = tamanho - i;
            }

            int[] aleatorio = new int[tamanho];
            Random rand = new Random();
            for (int i = 0; i < tamanho; i++) {
                aleatorio[i] = rand.nextInt(100000);
            }

            testar("Ordenado", ordenado);
            testar("Invertido", invertido);
            testar("Aleatório", aleatorio);
        }
    }

    public static void testar(String tipo, int[] original) {
        System.out.println("\n--- Tipo de vetor: " + tipo + " ---");

        ordenar_e_medir("Bubble Sort", original.clone(), "bubble");
        ordenar_e_medir("Insertion Sort", original.clone(), "insertion");
        ordenar_e_medir("Selection Sort", original.clone(), "selection");
    }

    public static void ordenar_e_medir(String nome, int[] vetor, String tipo) {
        long comparacoes = 0;
        long trocas = 0;
        int aux, chave, menor;

        long inicio = System.nanoTime();

        int n = vetor.length;

        if (tipo.equals("bubble")) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - 1 - i; j++) {
                    comparacoes++;
                    if (vetor[j] > vetor[j + 1]) {
                        aux = vetor[j];
                        vetor[j] = vetor[j + 1];
                        vetor[j + 1] = aux;
                        trocas++;
                    }
                }
            }
        }

        if (tipo.equals("insertion")) {
            for (int i = 1; i < n; i++) {
                chave = vetor[i];
                int j = i - 1;
                while (j >= 0 && vetor[j] > chave) {
                    comparacoes++;
                    vetor[j + 1] = vetor[j];
                    trocas++;
                    j--;
                }
                comparacoes++; // última comparação falsa
                vetor[j + 1] = chave;
            }
        }

        if (tipo.equals("selection")) {
            for (int i = 0; i < n - 1; i++) {
                menor = i;
                for (int j = i + 1; j < n; j++) {
                    comparacoes++;
                    if (vetor[j] < vetor[menor]) {
                        menor = j;
                    }
                }
                if (menor != i) {
                    aux = vetor[i];
                    vetor[i] = vetor[menor];
                    vetor[menor] = aux;
                    trocas++;
                }
            }
        }

        long fim = System.nanoTime();
        long tempo = fim - inicio;

        System.out.println(nome + ":");
        System.out.println("Tempo (ns): " + tempo);
        System.out.println("Comparações: " + comparacoes);
        System.out.println("Trocas: " + trocas + "\n");
    }
}

// Blubble Sort
    // Melhor caso é no ordenado, ams faz muitas comparações
    // Pior caso é no invertino

// Isertion Sort
    // Melhro caso é no ordenado, muito eficiente e quase não fez trocas
    // Pior caso é no invertino, precisou mover todos os elementos
    // Melhor que o Bubble em geral

// Selection Sort
    // Todos os casos, sempre faz o mesmo número de comparações independente da ordem
    // Menos trocas que o Bubble Sort, mas o desemepnho é o mesmo.