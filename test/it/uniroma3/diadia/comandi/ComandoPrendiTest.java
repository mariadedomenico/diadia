package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOconsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendiTest {

	private ComandoPrendi comando=new ComandoPrendi();
	private Attrezzo osso= new Attrezzo("osso", 1);
	private Attrezzo lanterna= new Attrezzo("lanterna", 2);
	private Attrezzo scudo= new Attrezzo("scudo", 3);
	private Attrezzo spada= new Attrezzo("spada", 100);
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
		stanza.addAttrezzo(this.scudo);
		stanza.addAttrezzo(spada);
		Borsa borsa=new Borsa();
		borsa.addAttrezzo(this.osso);
		borsa.addAttrezzo(this.lanterna);
		partita.getGiocatore().setBorsa(borsa);
		
		
		return partita;
	}
	
	@Test
	public void testEseguiPrendiAttrezzo() {
		
		this.comando.setParametro("scudo");
		this.comando.setIOConsole(new IOconsole());
		Partita p=creaPartita("Atrio");
		this.comando.esegui(p);
		
		assertArrayEquals(this.arrayDiAttrezzi, p.getGiocatore().getBorsa().getAttrezzi().values().toArray());
	}
	
	@Test
	public void testEseguiPrendiAttrezzoNonEsistente() {
		
		this.comando.setParametro("coltello");
		this.comando.setIOConsole(new IOconsole());
		Partita p=creaPartita("Atrio");
		p.getGiocatore().getBorsa().addAttrezzo(scudo);
		this.comando.esegui(p);
		
		
		assertArrayEquals(this.arrayDiAttrezzi, p.getGiocatore().getBorsa().getAttrezzi().values().toArray());
	}
	
	@Test
	public void testEseguiPrendiAttrezzoPesoMaxRaggiunto() {
		
		this.comando.setParametro("spada");
		this.comando.setIOConsole(new IOconsole());
		Partita p=creaPartita("Atrio");
		this.comando.esegui(p);
		p.getGiocatore().getBorsa().addAttrezzo(scudo);
		this.comando.esegui(p);
		
		
		assertArrayEquals(this.arrayDiAttrezzi, p.getGiocatore().getBorsa().getAttrezzi().values().toArray());
	}


}
