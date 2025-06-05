import java.util.Random;
import java.util.Scanner;

public class CacaPalavras {

    Scanner sc = new Scanner(System.in);
    private final int tamanho_tabuleiro = 10;
    private final char[][] tabuleiro_caca = new char[tamanho_tabuleiro][tamanho_tabuleiro];
    private final String[] palavras_caca = {"SUPINO", "REMADA", "SCOTT", "ROSCA", "EXTENSORA", "FLEXORA"};
    private String palavra_selecionada_caca;
    private final Random random = new Random();

    public void selecionar_palavra_caca() {
        palavra_selecionada_caca = palavras_caca[random.nextInt(palavras_caca.length)];
    }

    public void embaralhar_letras_caca() {
        for (int i = 0; i < tamanho_tabuleiro; i++) {
            for (int j = 0; j < tamanho_tabuleiro; j++) {
                tabuleiro_caca[i][j] = (char) ('A' + random.nextInt(26));
            }
        }
    }

    public void inserir_palavra_caca() {
        int linha_aleatoria = random.nextInt(tamanho_tabuleiro);
        int coluna_inicio = random.nextInt(tamanho_tabuleiro - palavra_selecionada_caca.length());

        for (int i = 0; i < palavra_selecionada_caca.length(); i++) {
            tabuleiro_caca[linha_aleatoria][coluna_inicio + i] = palavra_selecionada_caca.charAt(i);
        }
    }

    public void apresentar_tabuleiro_caca() {
        System.out.println("= Caça-Palavras =");
        for (int i = 0; i < tamanho_tabuleiro; i++) {
            for (int j = 0; j < tamanho_tabuleiro; j++) {
                System.out.print(tabuleiro_caca[i][j]);
            }
            System.out.println();
        }
        System.out.println("=================\n");
    }

    public void jogar() {
        selecionar_palavra_caca();
        embaralhar_letras_caca();
        inserir_palavra_caca();
        apresentar_tabuleiro_caca();

        System.out.println("Chute a palavra, mas em letra maiúscula!");

        String chute = sc.nextLine().toUpperCase();

        while (!chute.equals(palavra_selecionada_caca)) {
            System.out.println("\nVocê errou, tente novamente!\n");
            apresentar_tabuleiro_caca();
            chute = sc.nextLine().toUpperCase();
        }

        System.out.println("\nParabéns, você acertou a palavra correta!");
    }
}