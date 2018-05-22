package com.itau.jogovelha.controller;

import static org.junit.Assert.assertEquals;

import com.itau.jogovelha.model.Jogada;
import com.itau.jogovelha.model.Placar;
import com.itau.jogovelha.model.Valor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class JogoControllerTest {
	@LocalServerPort
	int port;
	
	@Autowired
	TestRestTemplate restTemplate;

	@Autowired
	JogoController controller;
	
	@Test
	public void deveRetornarPlacar(){
		String url = String.format("http://localhost:%d", port);
		Placar placar = restTemplate.getForObject(url, Placar.class);
		
		assertEquals(0, placar.pontuacao[0]);
		assertEquals(0, placar.pontuacao[1]);
	}

    @Test
    public void deveFazerJogada(){
        String url = String.format("http://localhost:%d", port);

        Jogada jogada = new Jogada();
        jogada.x = 0;
        jogada.y = 0;

        Placar placar = restTemplate.postForObject(url, jogada, Placar.class);

        assertEquals(0, placar.pontuacao[0]);
        assertEquals(0, placar.pontuacao[1]);
        assertEquals(Valor.X.getValor(), placar.casas[0][0]);
    }
}
