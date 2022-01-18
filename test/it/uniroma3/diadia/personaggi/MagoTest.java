package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class MagoTest {

	private Mago mago;
	private Attrezzo regalo;
	private Attrezzo regalo_magico;
	private Partita p;
	
	@Before
	public void setUp() {
		
		this.regalo=new Attrezzo("biscotto", 1);
		this.mago=new Mago("nome", "presentazione", regalo);
		this.regalo_magico=new Attrezzo("osso", 2);
		this.p=new Partita();
	}

	@Test
	public void testAgisciHaAttrezzo() {
		assertEquals("Sei un vero simpaticone, con una mia magica azione, troverai un nuovo oggetto per il tuo borsone!", this.mago.agisci(p));
		assertTrue(this.p.getGiocatore().getBorsa().hasAttrezzo(this.regalo.getNome()));
	}
	
	@Test
	public void testAgisciNonHaRegalo() {
		this.mago.agisci(p);
		assertEquals("Mi spiace, ma non ho piu' nulla...", this.mago.agisci(p));
	}

	@Test
	public void testRiceviRegalo() {
		assertEquals("Hoketi poketi peso dimezzato", this.mago.riceviRegalo(regalo_magico, p));
		assertTrue(this.p.getLabirinto().getStanzaCorrente().hasAttrezzo(regalo_magico.getNome()));
		assertEquals(1, this.p.getLabirinto().getStanzaCorrente().getAttrezzo(regalo_magico.getNome()).getPeso());
	}
	

	@Test
	public void testGetNome() {
		assertEquals("nome", this.mago.getNome());
	}

	@Test
	public void testHaSalutatoTrue() {
		this.mago.saluta();
		assertTrue(this.mago.haSalutato());
	}
	
	@Test
	public void testHaSalutatoFalse() {
		assertFalse(this.mago.haSalutato());
	}

	@Test
	public void testSalutaHaSalutato() {
		this.mago.saluta();
		assertEquals("Ciao, io sono nome. Ci siamo gia' presentati!", this.mago.saluta());
	}
	
	@Test
	public void testSalutaNonHaSalutato() {
		assertEquals("Ciao, io sono nome.presentazione", this.mago.saluta());
	}

}
