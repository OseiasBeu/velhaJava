package com.itau.jogovelha.model;

public enum Valor {
	VAZIO(" "),
	X("X"),
	O("O");
	
	String valor;
	
	Valor(String valor){
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
}