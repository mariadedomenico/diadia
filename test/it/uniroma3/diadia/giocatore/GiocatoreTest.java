package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GiocatoreTest {
	
	
	//ritorna un giocatore
	public Giocatore giocatore(Borsa borsa) {
		
		Giocatore giocatore=new Giocatore();
		giocatore.setBorsa(borsa);
		
		return giocatore;
	}
	
	
	//test su metodo getCfu
	@Test
	public void testGetCfu() {
		
		assertTrue(20==this.giocatore(new Borsa()).getCfu());
	}
	
	//test su metodo getBorsa
	@Test
	public void testGetBorsa() {
		
		Borsa borsa=new Borsa();
		assertTrue(borsa==this.giocatore(borsa).getBorsa());
	}

}
