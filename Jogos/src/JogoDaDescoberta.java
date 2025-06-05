import java.util.Random;
import java.util.Scanner;

public class JogoDaDescoberta {

    Scanner sc = new Scanner(System.in);
    private final String[] palavras_descoberta = {"ENGENHARIA", "SOFTWARE", "DADOS", "ANALISTA"};
    private String palavra_selecionada_descoberta;
    private final Random random = new Random();

    public void selecionar_palavra_descoberta() {
        palavra_selecionada_descoberta = palavras_descoberta[random.nextInt(palavras_descoberta.length)];
    }

    public String embaralhar_letras_descoberta() {
        char[] palavra_array = palavra_selecionada_descoberta.toCharArray();

        for (int i = 0; i < palavra_array.length; i++) {
            int indice_aleatorio = random.nextInt(palavra_array.length);
            char temp = palavra_array[i];
            palavra_array[i] = palavra_array[indice_aleatorio];
            palavra_array[indice_aleatorio] = temp;
        }

        return new String(palavra_array);
    }

    public void jogar() {
        System.out.println("Bem-vindo ao Jogo da Descoberta");
        selecionar_palavra_descoberta();
        String palavra_para_descobrir = embaralhar_letras_descoberta();

        System.out.println("Qual a palavra " + palavra_para_descobrir + "?");

        int tentativa = 0;

        while (true) {
            System.out.println("Informe a palavra, 'dica' para ganhar uma dica ou '0' para desistir!");
            String resposta = sc.next().toUpperCase();

            if (resposta.equals("0")) {
                System.out.println("Parabéns, você sabe o seu limite, com " + tentativa + " tentativas.");
                break;
            }
            if (resposta.equals("DICA")) {
                System.out.println("A primeira letra é: " + palavra_selecionada_descoberta.charAt(0)
                        + " e a última é: " + palavra_selecionada_descoberta.charAt(palavra_para_descobrir.length() - 1));
                continue;
            }
            if (resposta.equals(palavra_selecionada_descoberta)) {
                tentativa++;
                System.out.println("Você acertou com " + tentativa + " tentativa(s)!");
                break;
            } else {
                tentativa++;
            }
        }
    }
}