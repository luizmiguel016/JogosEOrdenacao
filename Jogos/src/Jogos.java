public class Jogos {

    private final CacaPalavras cacaPalavras = new CacaPalavras();
    private final JogoDaDescoberta jogoDescoberta = new JogoDaDescoberta();

    public void jogar_caca_palavras() {
        cacaPalavras.jogar();
    }

    public void jogar_jogo_descoberta() {
        jogoDescoberta.jogar();
    }
}