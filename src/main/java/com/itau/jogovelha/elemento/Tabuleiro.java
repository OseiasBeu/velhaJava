package com.itau.jogovelha.elemento;

public class Tabuleiro {
	String[][] casas = new String[3][3];
	
	public void inicializar() {
		for(String[] linha : casas) {
			for (int i = 0; i < linha.length; i++) {
				linha[i] = Valor.VAZIO.getValor();
			}
		}
	}
	
	public String[][] getCasas(){
		return casas;
	}
	
	public void setCasa(int x, int y, Valor valor) {
		this.casas[x][y] = valor.getValor();
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		for(String[] linha : casas) {
			for (String casa: linha) {
				builder.append(String.format("[%s]", casa));
			}
			
			builder.append("\n");
		}
		
		return builder.toString();
	}
}
