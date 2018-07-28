package com.itau.jogovelha.controller;

import com.itau.jogovelha.model.Jogada;
import com.itau.jogovelha.model.Placar;
import com.itau.jogovelha.model.Rodada;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.itau.jogovelha.model.Tabuleiro;

@Controller
@CrossOrigin
public class JogoController {

	Rodada rodada = new Rodada("Jogador 1", "Jogador 2");

	@RequestMapping("/jogo")
	public @ResponseBody
	Placar getPlacar() {
		return rodada.getPlacar();
	}

    //@RequestMapping(path = "/jogar", method = RequestMethod.POST)
    @RequestMapping(method = RequestMethod.POST, path = "/jogar")
    public @ResponseBody
    Placar jogar(@RequestBody Jogada jogada) {
        rodada.jogar(jogada.x, jogada.y);
        
        return rodada.getPlacar();
    }

    @RequestMapping("/iniciar")
    public @ResponseBody
    Placar iniciarJogo() {
        rodada.iniciarJogo();

        return rodada.getPlacar();
    }
}
