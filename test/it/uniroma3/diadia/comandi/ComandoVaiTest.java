package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import it.uniroma3.diadia.IOconsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVaiTest {

	private ComandoVai comando=new ComandoVai();
	private Stanza stanza=new Stanza("Atrio");
	private Stanza stanza2=new Stanza("Aula N10");
	
	private Partita creaPartita(String direzione, String direzioneAdiacente, int cfu) {

		Partita partita=new Partita();
		this.stanza.impostaStanzaAdiacente(direzione, this.stanza2);
		this.stanza2.impostaStanzaAdiacente(direzioneAdiacente, this.stanza);
		partita.getLabirinto().setStanzaCorrente(this.stanza);
		partita.getGiocatore().setCfu(cfu);
		
		return partita;
	}
	
	
	@Test
	public void testEseguiStanzaAdiacenteEsistente() {
		
		this.comando.setParametro("est");
		this.comando.setIOConsole(new IOconsole());
		Partita p=creaPartita("est", "ovest", 20);
		this.comando.esegui(p);
		assertEquals(p.getLabirinto().getStanzaCorrente(), p.getLabirinto().getStanzaCorrente().getStanzaAdiacente("ovest").getStanzaAdiacente("est"));
		assertEquals(19,p.getGiocatore().getCfu());
		
	}
	
	@Test
	public void testEseguiStanzaAdiacenteNonEsistente() {
		
		this.comando.setParametro("nord");
		this.comando.setIOConsole(new IOconsole());
		Partita p=creaPartita("est", "ovest", 20);
		this.comando.esegui(p);
		assertEquals(this.stanza, p.getLabirinto().getStanzaCorrente());
		assertEquals(20,p.getGiocatore().getCfu());
		
	}
	
	@Test
	public void testEseguiStanzaAdiacente0Cfu() {
		
		this.comando.setParametro("nord");
		this.comando.setIOConsole(new IOconsole());
		Partita p=creaPartita("est", "ovest", 0);
		this.comando.esegui(p);
		assertEquals(this.stanza, p.getLabirinto().getStanzaCorrente());
		assertEquals(0,p.getGiocatore().getCfu());
		
	}
	
	@Test
	public void testEseguiParametroNonValido() {
		
		this.comando.setParametro("nard");
		this.comando.setIOConsole(new IOconsole());
		Partita p=creaPartita("nord", "ovest", 20);
		this.comando.esegui(p);
		assertEquals(this.stanza, p.getLabirinto().getStanzaCorrente());
		assertEquals(20,p.getGiocatore().getCfu());
		
	}
	
	
}
