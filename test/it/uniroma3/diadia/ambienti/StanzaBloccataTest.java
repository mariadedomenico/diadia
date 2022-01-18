package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	private StanzaBloccata stanza;
	private Attrezzo attrezzo;
	private StanzaBloccata stanza1;
	private Attrezzo attrezzo1;
	
	@Before
	public void setUp() {
		this.stanza=new StanzaBloccata("stanza");
		this.stanza1=new StanzaBloccata("stanza");
		this.attrezzo=new Attrezzo("chiave", 1);
		this.attrezzo1=new Attrezzo("osso", 1);
		this.stanza.addAttrezzo(attrezzo);
		this.stanza1.addAttrezzo(attrezzo1);
		this.stanza.impostaStanzaAdiacente("sud", stanza1);
		this.stanza1.impostaStanzaAdiacente("nord", stanza);
		
	}
	
	@Test
	public void testGetStanzaAdiacenteBloccata() {
		this.stanza1.setStanzaCorrente(stanza1);
		assertEquals(this.stanza1, this.stanza1.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testGetStanzaAdiacenteNonBloccata() {
		this.stanza.setStanzaCorrente(stanza);
		assertEquals(this.stanza1, this.stanza.getStanzaAdiacente("sud"));
	}

	@Test
	public void testGetDescrizioneAttrezzoPresente() {
		assertEquals(this.stanza.toString(), this.stanza.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneAttrezzoNonPresente() {
		assertEquals(this.stanza1.toString() + "\nImpossibile accedere a nord, scegli un'altra direzione per cambiare stanza", this.stanza1.getDescrizione());
	}

}
