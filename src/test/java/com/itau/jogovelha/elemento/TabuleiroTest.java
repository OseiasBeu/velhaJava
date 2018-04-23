package com.itau.jogovelha.elemento;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TabuleiroTest {
	
	@Test
	public void deveRetornarTabuleiroVazio() {
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.inicializar();
		assertEquals(tabuleiro.toString(), "[ ][ ][ ]\n[ ][ ][ ]\n[ ][ ][ ]\n");
	}
	
	@Test
	public void deveDefinirCasa() {
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.inicializar();
		tabuleiro.setCasa(0, 0, Valor.X);
		tabuleiro.setCasa(2, 2, Valor.O);
		
		assertEquals(tabuleiro.toString(), "[X][ ][ ]\n[ ][ ][ ]\n[ ][ ][O]\n");
	}
}
