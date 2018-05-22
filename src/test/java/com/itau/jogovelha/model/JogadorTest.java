package com.itau.jogovelha.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JogadorTest {

    @Test
    public void deveInicializarCorretamente(){
        Jogador jogador = new Jogador("John");

        assertEquals(jogador.getNome(), "John");
        assertEquals(jogador.getPontos(), 0);
    }

    @Test
    public void deveIncrementarPontos(){
        Jogador jogador = new Jogador("John");

        jogador.incrementarPontos();

        assertEquals(jogador.getPontos(), 1);
    }
}
