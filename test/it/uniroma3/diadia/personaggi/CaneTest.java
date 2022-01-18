package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class CaneTest {
	
	private Cane cane;
	private Attrezzo regalo_gradito;
	private Attrezzo regalo_nongradito;
	private Partita p;
	
	@Before
	public void setUp() {
		this.cane=new Cane("nome", "presentazione");
		this.regalo_gradito=new Attrezzo("biscotto", 1);
		this.regalo_nongradito=new Attrezzo("osso", 1);
		this.p=new Partita();
	}

	@Test
	public void testAgisciNonHaSalutato() {
		assertEquals("Non svegliare il can che dorme", this.cane.agisci(p));
		assertEquals(20, this.p.getGiocatore().getCfu());
	}
	
	@Test
	public void testAgisciHaSalutato() {
		this.cane.saluta();
		assertEquals("Can che abbaia... MORDE!", this.cane.agisci(p));
		assertEquals(19, this.p.getGiocatore().getCfu());
	}

	@Test
	public void testRiceviRegaloGradito() {
		assertEquals("Congratulazioni! Il cane ha apprezzato il regalo", this.cane.riceviRegalo(regalo_gradito, p));
		assertEquals(20, this.p.getGiocatore().getCfu());
		assertTrue(this.p.getLabirinto().getStanzaCorrente().hasAttrezzo("chiave"));
	}
	
	@Test
	public void testRiceviRegaloNonGradito() {
		assertEquals("Aia! Il cane non ha apprezzato il regalo... meglio scappare", this.cane.riceviRegalo(regalo_nongradito, p));
		assertEquals(19, this.p.getGiocatore().getCfu());
		assertFalse(this.p.getLabirinto().getStanzaCorrente().hasAttrezzo("chiave"));
	}

	@Test
	public void testGetNome() {
		assertEquals("nome", this.cane.getNome());
	}

	@Test
	public void testHaSalutatoTrue() {
		this.cane.saluta();
		assertTrue(this.cane.haSalutato());
	}
	
	@Test
	public void testHaSalutatoFalse() {
		assertFalse(this.cane.haSalutato());
	}

	@Test
	public void testSalutaHaSalutato() {
		this.cane.saluta();
		assertEquals("Ciao, io sono nome. Ci siamo gia' presentati!", this.cane.saluta());
	}
	
	@Test
	public void testSalutaNonHaSalutato() {
		assertEquals("Ciao, io sono nome.presentazione", this.cane.saluta());
	}

}
