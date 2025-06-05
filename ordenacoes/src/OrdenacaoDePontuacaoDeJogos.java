import utilitarios.imprimir_vetor;

public class OrdenacaoDePontuacaoDeJogos {

    public static void main(String[] args) {
        int[] pontuacoes = {250, 300, 150, 400, 350};

        OrdenacaoDecrescente.ordenar_decrescente(pontuacoes);
        imprimir_vetor.imprimir_int(pontuacoes);

        int pontuacaoMaisAlta = pontuacoes[0];
        System.out.println("1 pontuação: " + pontuacaoMaisAlta);
    }
}