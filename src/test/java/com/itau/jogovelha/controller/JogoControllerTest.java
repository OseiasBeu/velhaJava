package com.itau.jogovelha.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.itau.jogovelha.elemento.Tabuleiro;

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
	public void deveRetornarTabuleiro(){
		String url = String.format("http://localhost:%d", port);
		String tabuleiro = restTemplate.getForObject(url, String.class);
		
		assertEquals(tabuleiro, "{\"casas\":[[\" \",\" \",\" \"],[\" \",\" \",\" \"],[\" \",\" \",\" \"]]}");
	}
}
