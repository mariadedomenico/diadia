package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class LabirintoTest {
	
	//crea labirinto
	public Labirinto creaLabirinto() {
		Labirinto lab=new Labirinto();
		return lab;
	}
	

	//test su metodo getStanzaVincente
	@Test
	public void testStanzaVincenteNotNull() {
		
		assertNotNull(this.creaLabirinto().getStanzaVincente());
		
	}
	
	@Test
	public void testGetStanzaVincenteCorretta() {
		
		assertEquals("Biblioteca", this.creaLabirinto().getStanzaVincente().getNome());
		
	}
	
	
	
	//test su metodo getStanzaCorrente
	@Test
	public void testStanzaCorrenteNotNull() {
		
		assertNotNull(this.creaLabirinto().getStanzaCorrente());
		
	}
	
	@Test
	public void testGetStanzaCorrenteCorretta() {
		
		assertEquals("Atrio", this.creaLabirinto().getStanzaCorrente().getNome());
		
	}

	
	

}
