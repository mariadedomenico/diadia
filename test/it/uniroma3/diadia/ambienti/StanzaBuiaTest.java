package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	
	private StanzaBuia stanza;
	private Attrezzo attrezzo;
	private StanzaBuia stanza1;
	private Attrezzo attrezzo1;
	
	@Before
	public void setUp() {
		this.stanza=new StanzaBuia("stanza");
		this.attrezzo=new Attrezzo("torcia", 1);
		this.stanza.addAttrezzo(attrezzo);
		this.stanza1=new StanzaBuia("stanza");
		this.attrezzo1=new Attrezzo("osso", 1);
		this.stanza1.addAttrezzo(attrezzo1);
	}
	

	@Test
	public void testGetDescrizioneAttrezzoPresente() {
		assertEquals(this.stanza.toString(), this.stanza.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneAttrezzoNonPresente() {
		assertEquals("Qui c'è buio pesto", this.stanza1.getDescrizione());
	}
	
	

}
