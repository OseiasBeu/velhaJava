package com.itau.jogovelha.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JogoTest {

    @Test
    public void deveAlternarJogadorAtivo(){
        Jogo jogo = new Jogo();

        assertEquals(0, jogo.getJogadorAtivo());

        jogo.jogar(0, 0);

        assertEquals(1, jogo.getJogadorAtivo());
    }

    @Test
    public void deveTestarVitoria(){
        Jogo jogo = new Jogo();

        jogo.jogar(0, 0);
        jogo.jogar(1, 0);

        assertEquals(false, jogo.isEncerrado());

        jogo.jogar(0, 1);
        jogo.jogar(1, 1);

        assertEquals(false, jogo.isEncerrado());

        jogo.jogar(0, 2);

        assertEquals(true, jogo.isEncerrado());
        assertEquals(0, jogo.getJogadorAtivo());
    }

}
