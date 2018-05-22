package com.itau.jogovelha.model;

public class Tabuleiro {
	String[][] casas = new String[3][3];

	public Tabuleiro(){
	    inicializar();
    }

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
	
	public boolean setCasa(int x, int y, Valor valor) {
	    String vazio = Valor.VAZIO.getValor();

		if(! this.casas[x][y].equals(vazio)){
		    return false;
        }

	    this.casas[x][y] = valor.getValor();
		return true;
	}

	public boolean verificarVitoria(){
        for(int i = 0; i < 3; i ++){
            //verifica verticais
            if(casas[0][i] == casas[1][i] && casas[1][i] == casas[2][i] && casas[0][i] != Valor.VAZIO.getValor()){
                return true;
            }

            //verifica horizontais
	        if(casas[i][0] == casas[i][1] && casas[i][1] == casas[i][2] && casas[i][0] != Valor.VAZIO.getValor()){
                return true;
            }
        }

        if(casas[0][0] == casas[1][1] && casas[1][1] == casas[2][2] && casas[0][0] != Valor.VAZIO.getValor()){
            return true;
        }

        if(casas[0][2] == casas[1][1] && casas[1][1] == casas[2][0] && casas[1][1] != Valor.VAZIO.getValor()){
            return true;
        }

        return false;
    }

    public boolean verificarVelha(){
	    for(String[] linha: casas){
	        for(String casa: linha){
	            if(casa == Valor.VAZIO.getValor()){
	                return false;
                }
            }
        }

        return true;
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
