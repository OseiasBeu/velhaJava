package com.itau.jogovelha.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TabuleiroTest {
	
	@Test
	public void deveInicializarTabuleiroVazio() {
		Tabuleiro tabuleiro = new Tabuleiro();
		assertEquals("[ ][ ][ ]\n[ ][ ][ ]\n[ ][ ][ ]\n", tabuleiro.toString());
	}
	
	@Test
	public void deveDefinirCasa() {
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.inicializar();
		tabuleiro.setCasa(0, 0, Valor.X);
		tabuleiro.setCasa(2, 2, Valor.O);
		
		assertEquals("[X][ ][ ]\n[ ][ ][ ]\n[ ][ ][O]\n", tabuleiro.toString());
	}

	@Test
	public void deveEvitarQueUmaCasaSejaSobrescrita() {
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.inicializar();
		tabuleiro.setCasa(0, 0, Valor.X);
		tabuleiro.setCasa(0, 0, Valor.O);

		assertEquals("[X][ ][ ]\n[ ][ ][ ]\n[ ][ ][ ]\n", tabuleiro.toString());
	}

    @Test
    public void deveTestarVitoriaPorHorizontal(){
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.inicializar();

        assertEquals(tabuleiro.verificarVitoria(), false);

        tabuleiro.setCasa(0, 0, Valor.X);
        tabuleiro.setCasa(0, 1, Valor.X);
        tabuleiro.setCasa(0, 2, Valor.X);

        assertEquals(tabuleiro.verificarVitoria(), true);
    }

    @Test
    public void deveTestarVitoriaPorVertical(){
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.inicializar();

        assertEquals(tabuleiro.verificarVitoria(), false);

        tabuleiro.setCasa(0, 0, Valor.X);
        tabuleiro.setCasa(1, 0, Valor.X);
        tabuleiro.setCasa(2, 0, Valor.X);

        assertEquals(tabuleiro.verificarVitoria(), true);
    }

    @Test
    public void deveTestarVitoriaPorDiagonal1(){
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.inicializar();

        assertEquals(tabuleiro.verificarVitoria(), false);

        tabuleiro.setCasa(0, 0, Valor.X);
        tabuleiro.setCasa(1, 1, Valor.X);
        tabuleiro.setCasa(2, 2, Valor.X);

        assertEquals(tabuleiro.verificarVitoria(), true);
    }

    @Test
    public void deveTestarVitoriaPorDiagonal2(){
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.inicializar();

        assertEquals(tabuleiro.verificarVitoria(), false);

        tabuleiro.setCasa(0, 2, Valor.X);
        tabuleiro.setCasa(1, 1, Valor.X);
        tabuleiro.setCasa(2, 0, Valor.X);

        assertEquals(tabuleiro.verificarVitoria(), true);
    }
}
