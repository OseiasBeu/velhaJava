package com.itau.jogovelha.model;

public class Jogador {
    private String nome;
    private int pontos;

    public Jogador(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void incrementarPontos(){
        pontos++;
    }
}
