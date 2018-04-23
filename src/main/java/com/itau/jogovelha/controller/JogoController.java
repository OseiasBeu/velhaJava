package com.itau.jogovelha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itau.jogovelha.elemento.Tabuleiro;

@Controller
public class JogoController {
	
	@RequestMapping("/")
	public @ResponseBody Tabuleiro getTabuleiro() {
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.inicializar();
		
		return tabuleiro;
	}
}
