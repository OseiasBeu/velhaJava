package com.itau.jogovelha.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RodadaTest {

    @Test
    public void deveInicializarPlacar(){
        Rodada rodada = new Rodada("J1", "J2");

        int[] pontuacao = rodada.getPlacar().pontuacao;

        assertEquals(0, pontuacao[0]);
        assertEquals(0, pontuacao[1]);
    }

    @Test
    public void deveEvitarQueUmJogoAtivoSejaReiniciado(){
        Rodada rodada = new Rodada("J1", "J2");

        rodada.jogar(0,0);

        String casa = rodada.getPlacar().casas[0][0];

        rodada.iniciarJogo();

        assertEquals(Valor.X.getValor(), casa);

    }

    @Test
    public void deveIniciarUmNovoJogo(){
        Rodada rodada = new Rodada("J1", "J2");

        rodada.jogar(0,0);
        rodada.jogar(1,0);
        rodada.jogar(0,1);
        rodada.jogar(1,1);
        rodada.jogar(0,2);

        assertEquals(Valor.X.getValor(), rodada.getPlacar().casas[0][0]);
        assertEquals(1, rodada.getPlacar().pontuacao[0]);

        rodada.iniciarJogo();

        assertEquals(Valor.VAZIO.getValor(), rodada.getPlacar().casas[0][0]);

    }

    @Test
    public void deveContabilizarPontos(){
        Rodada rodada = new Rodada("J1", "J2");

        //vitória jogador 2
        rodada.jogar(0,0);
        rodada.jogar(1,0);
        rodada.jogar(0,1);
        rodada.jogar(1,1);
        rodada.jogar(2,2);
        rodada.jogar(1,2);

        assertEquals(0, rodada.getPlacar().pontuacao[0]);
        assertEquals(1, rodada.getPlacar().pontuacao[1]);

        rodada.iniciarJogo();

        //vitória jogador 1
        rodada.jogar(0,0);
        rodada.jogar(1,0);
        rodada.jogar(0,1);
        rodada.jogar(1,1);
        rodada.jogar(0,2);

        assertEquals(1, rodada.getPlacar().pontuacao[0]);
        assertEquals(1, rodada.getPlacar().pontuacao[1]);
    }

}
