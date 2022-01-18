package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOconsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosaTest {

	private ComandoPosa comando=new ComandoPosa();
	private Attrezzo osso= new Attrezzo("osso", 1);
	private Attrezzo lanterna= new Attrezzo("lanterna", 2);
	private Attrezzo scudo= new Attrezzo("scudo", 3);
	private Attrezzo[] arrayDiAttrezzi= new Attrezzo[3];
	
	@Before
	public void setUp() {
		
		
		arrayDiAttrezzi[0]=this.scudo;
		arrayDiAttrezzi[1]=this.osso;
		arrayDiAttrezzi[2]=this.lanterna;
		
	}
	
	
	private Partita creaPartita(String nome) {

		Partita partita=new Partita();
		Stanza stanza=new Stanza(nome);
		partita.getLabirinto().setStanzaCorrente(stanza);
		stanza.addAttrezzo(this.osso);
		stanza.addAttrezzo(this.lanterna);
		Borsa borsa=new Borsa();
		borsa.addAttrezzo(this.scudo);
		partita.getGiocatore().setBorsa(borsa);
		
		
		return partita;
	}
	
	@Test
	public void testEseguiPosaAttrezzo() {
		
		this.comando.setParametro("scudo");
		this.comando.setIOConsole(new IOconsole());
		Partita p=creaPartita("Atrio");
		this.comando.esegui(p);
		
		assertArrayEquals(this.arrayDiAttrezzi, p.getLabirinto().getStanzaCorrente().getAttrezzi().values().toArray());
	}
	
	@Test
	public void testEseguiPosaAttrezzoNonEsistente() {
		
	
		this.comando.setParametro("spada");
		this.comando.setIOConsole(new IOconsole());
		Partita p=creaPartita("Atrio");
		p.getLabirinto().getStanzaCorrente().addAttrezzo(scudo);
		this.comando.esegui(p);
		
		
		assertArrayEquals(this.arrayDiAttrezzi, p.getLabirinto().getStanzaCorrente().getAttrezzi().values().toArray());
	}
		

}
