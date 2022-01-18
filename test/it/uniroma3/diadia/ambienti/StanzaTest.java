package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

	public Stanza stanza=new Stanza("stanza"); //è legale????
	public Stanza stanzaAdiacente=new Stanza("stanzaAdiacente");

	
	//crea stanza, aggiungendo una serie di attrezzi
	private Stanza creaStanza(int peso, String...attrezzi) {

		Stanza stanza= new Stanza("stanza");
		for(int i=0; i<attrezzi.length; i++) {
			stanza.addAttrezzo(new Attrezzo(attrezzi[i], peso));
		}

		return stanza;
	}


	//test su metodo addAttrezzo
	@Test
	public void testAddAttrezzoAggiunto() {

		assertTrue(this.stanza.addAttrezzo(new Attrezzo("osso", 1)));

	}

	@Test
	public void testAddAttrezzoNull() {

		assertFalse(this.stanza.addAttrezzo(null));

	}
	
	@Test
	public void testAddAttrezzoEsistente() {

		this.stanza.addAttrezzo(new Attrezzo("osso", 1));
		assertTrue(this.stanza.addAttrezzo(new Attrezzo("osso", 2)));
		assertEquals(2, this.stanza.getAttrezzo("osso").getPeso());
	

	}
	
	@Test
	public void testAddAttrezzoNumeroMaxSuperato() {
		
		assertFalse(this.creaStanza(1, "osso", "lanterna", "scudo", "spada", "martello", "elmo", "pugnale", "sciabola", "pistola", "osso").addAttrezzo(new Attrezzo("lanterna", 1)));
	}

	
	
	//test su metodo hasAttrezzo
	@Test
	public void testHasAttrezzoEsistente() {

		assertTrue(this.creaStanza(1, "osso").hasAttrezzo("osso"));

	}

	@Test
	public void testHasAttrezzoNonEsiste() {

		assertFalse(this.creaStanza(1, "osso").hasAttrezzo("lanterna"));

	}

	@Test
	public void testHasAttrezzoNull() {

		assertFalse(this.creaStanza(1, "osso").hasAttrezzo(null));

	}
	
	
	
	//test su metodo removeAttrezzo
	@Test
	public void testRemovePrimoAttrezzo() {

		Stanza stanza=this.creaStanza(1, "osso", "lanterna");
		assertTrue(stanza.removeAttrezzo(stanza.getAttrezzo("osso")));
	}

	@Test
	public void testRemoveUltimoAttrezzo() {

		Stanza stanza=this.creaStanza(1, "osso", "scudo");
		assertTrue(stanza.removeAttrezzo(stanza.getAttrezzo("scudo")));
	}

	@Test
	public void testRemoveAttrezzoCentrale() {

		Stanza stanza=this.creaStanza(1, "osso", "lanterna", "scudo");
		assertTrue(stanza.removeAttrezzo(stanza.getAttrezzo("lanterna")));
	}

	@Test
	public void testRemoveAttrezzoInesistente() {

		Stanza stanza=this.creaStanza(1, "osso");
		assertFalse(stanza.removeAttrezzo(stanza.getAttrezzo("lanterna")));
	}
	
	@Test
	public void testImpostaStanzaAdiacenteDirezioneEsistente() {
		this.stanza.impostaStanzaAdiacente("nord", this.stanzaAdiacente);
		assertEquals(this.stanzaAdiacente, this.stanza.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testImpostaStanzaAdiacenteDirezioneNonEsistente() {
		this.stanza.impostaStanzaAdiacente("nard", this.stanzaAdiacente);
		assertNull(this.stanza.getStanzaAdiacente("nard"));
	}
	
	@Test
	public void testImpostaStanzaAdiacenteStanzaEsistente() {
		this.stanza.impostaStanzaAdiacente("nord", this.stanzaAdiacente);
		assertEquals(this.stanzaAdiacente, this.stanza.getStanzaAdiacente("nord"));
	}

	@Test
	public void testImpostaStanzaAdiacenteStanzaNonEsistente() {
		this.stanza.impostaStanzaAdiacente("nord", null);
		assertNull(this.stanza.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testImpostaStanzaAdiacenteRaggiuntoNumeroMax() {
		
		Stanza nord = new Stanza("nord");
		this.stanza.impostaStanzaAdiacente("nord", new Stanza("nordVecchia"));
		this.stanza.impostaStanzaAdiacente("sud", new Stanza("sud"));
		this.stanza.impostaStanzaAdiacente("est", new Stanza("est"));
		this.stanza.impostaStanzaAdiacente("ovest", new Stanza("ovest"));
		
		this.stanza.impostaStanzaAdiacente("nord", nord);
		assertEquals(nord, this.stanza.getStanzaAdiacente("nord"));
		
	}
	
	@Test
	public void testGetStanzaAdiacente() {
		this.stanza.impostaStanzaAdiacente("nord", this.stanzaAdiacente);
		assertEquals(this.stanzaAdiacente, this.stanza.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testGetNome() {
		assertEquals("stanza", this.stanza.getNome());
	}

	@Test
	public void testGetAttrezzi() {
		Attrezzo a=new Attrezzo("osso", 1);
		this.stanza.addAttrezzo(a);
		Map<String, Attrezzo> mappa=this.stanza.getAttrezzi();
		assertTrue(mappa.containsValue(a));
		
	}
	
	@Test
	public void testGetAttrezzo() {
		Attrezzo a=new Attrezzo("osso", 1);
		this.stanza.addAttrezzo(a);
		assertEquals(a, this.stanza.getAttrezzo("osso"));
		
	}
	
	@Test
	public void testGetAttrezzoNonEsistente() {
		Attrezzo a=new Attrezzo("osso", 1);
		this.stanza.addAttrezzo(a);
		assertNull(this.stanza.getAttrezzo("lanterna"));
		
	}
	
	@Test
	public void testGetDirezioni() {
		this.stanza.impostaStanzaAdiacente("nord", this.stanzaAdiacente);
		this.stanza.impostaStanzaAdiacente("sud", new Stanza("sud"));
		assertTrue(this.stanza.getDirezioni().contains("nord"));
		assertTrue(this.stanza.getDirezioni().contains("sud"));
		
	}
	
	@Test
	public void testHasDirezioneEsistente() {
		this.stanza.impostaStanzaAdiacente("nord", this.stanzaAdiacente);
		assertTrue(this.stanza.hasDirezione("nord"));
	}
	
	@Test
	public void testHasDirezioneNonEsistente() {
		this.stanza.impostaStanzaAdiacente("nord", this.stanzaAdiacente);
		assertFalse(this.stanza.hasDirezione("sud"));
	}
	
	
}
