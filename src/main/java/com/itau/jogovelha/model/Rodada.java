package com.itau.jogovelha.model;

public class Rodada {
    private Jogador[] jogadores = new Jogador[2];
    private Jogo jogo;

    public Rodada(String nomeUm, String nomeDois){
        jogadores[0] = new Jogador(nomeUm);
        jogadores[1] = new Jogador(nomeDois);

        jogo = new Jogo();
    }

    public void iniciarJogo(){
        if(! jogo.isEncerrado()){
            return;
        }

        jogo = new Jogo();
    }

    public void jogar(int x, int y){
        if(jogo.isEncerrado()){
            return;
        }

        jogo.jogar(x, y);

        if(jogo.isEncerrado() && jogo.isVitoria()){
            int vencedor = jogo.getJogadorAtivo();

            jogadores[vencedor].incrementarPontos();
        }
    }

    public Placar getPlacar(){
        int[] pontuacao = {jogadores[0].getPontos(), jogadores[1].getPontos()};

        Placar placar = new Placar();
        placar.pontuacao = pontuacao;
        placar.casas = jogo.getCasas();
        placar.encerrado = jogo.isEncerrado();

        return placar;
    }

}
