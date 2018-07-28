package com.itau.jogovelha.model;

public class Jogo {
    private Tabuleiro tabuleiro = new Tabuleiro();
    private Valor[] valores = {Valor.X, Valor.O};

    private int jogadorAtivo = 0;
    private boolean encerrado = false;
    private boolean vitoria = false;

    public Jogo(){
    }

    public void jogar(int x, int y){
        if(encerrado){
            return;
        }

        Valor valorDaVez = valores[jogadorAtivo];

        boolean sucesso = tabuleiro.setCasa(x, y, valorDaVez);

        if(!sucesso){
            return;
        }

        
        vitoria = tabuleiro.verificarVitoria();
       
        boolean velha = tabuleiro.verificarVelha();

        if(vitoria || velha){
            encerrado = true;
            return;
        }

        if(jogadorAtivo == 0){
            jogadorAtivo = 1;
        }else{
            jogadorAtivo = 0;
        }
    }

    public String[][] getCasas(){
        return tabuleiro.getCasas();
    }

    public boolean isEncerrado(){
        return encerrado;
    }

    public boolean isVitoria(){
        return vitoria;
    }

    public int getJogadorAtivo(){
        return jogadorAtivo;
    }

}
