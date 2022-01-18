package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StregaTest {

	private Strega strega;
	private Attrezzo regalo;
	private Partita p;
	
	@Before
	public void setUp() {
		this.strega=new Strega("nome", "presentazione");
		this.regalo=new Attrezzo("biscotto", 1);
		this.p=new Partita();
	}

	@Test
	public void testAgisciNonHaSalutato() {
		assertEquals("Parim-pam-pum, nella stanza con meno attrezzi andrai tu!", this.strega.agisci(p));
		assertEquals("Biblioteca", this.p.getLabirinto().getStanzaCorrente().getNome());
	}
	
	@Test
	public void testAgisciHaSalutato() {
		this.strega.saluta();
		assertEquals("Higitus figitus abracazè, andrai nella stanza con più attrezzi per te!", this.strega.agisci(p));
		assertEquals("Aula N10", this.p.getLabirinto().getStanzaCorrente().getNome());
	}

	@Test
	public void testRiceviRegalo() {
		assertEquals("AHAHAHAHHAHAHAH MIOOOOO", this.strega.riceviRegalo(regalo, p));
		assertFalse(this.p.getGiocatore().getBorsa().hasAttrezzo(regalo.getNome()));
	}
	

	@Test
	public void testGetNome() {
		assertEquals("nome", this.strega.getNome());
	}

	@Test
	public void testHaSalutatoTrue() {
		this.strega.saluta();
		assertTrue(this.strega.haSalutato());
	}
	
	@Test
	public void testHaSalutatoFalse() {
		assertFalse(this.strega.haSalutato());
	}

	@Test
	public void testSalutaHaSalutato() {
		this.strega.saluta();
		assertEquals("Ciao, io sono nome. Ci siamo gia' presentati!", this.strega.saluta());
	}
	
	@Test
	public void testSalutaNonHaSalutato() {
		assertEquals("Ciao, io sono nome.presentazione", this.strega.saluta());
	}

}
