package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOconsole;
import it.uniroma3.diadia.Partita;

public class ComandoFakeTest {

	private Partita partita;
	private AbstractComando fake;
	private IOconsole console;
	
	@Before 
	public void setUp() {
		this.partita=new Partita();
		this.console=new IOconsole();
		this.fake=new ComandoFake();
		this.fake.setParametro("parametro");
		this.fake.setIOConsole(console);
	
	}
	
	@Test
	public void testEsegui() {
		
		this.fake.esegui(partita);
		assertEquals("prova", this.partita.getLabirinto().getStanzaCorrente().getNome());
	}
	
	@Test
	public void testGetNome() {
		assertEquals("fake", this.fake.getNome());
	}
	
	@Test
	public void testGetParametro() {
		assertEquals("parametro", this.fake.getParametro());
	}
	
	
	
	
	
	
	
	
	
//	@Test
//	public void testEseguiVai() {
//		this.fake=new ComandoVai();
//		this.fake.setParametro("sud");
//		this.fake.setIOConsole(console);
//		this.fake.esegui(partita);
//		assertEquals("Aula N10", this.partita.getLabirinto().getStanzaCorrente().getNome());
//		assertEquals(19, this.partita.getGiocatore().getCfu());
//		
//	}
//	
//	@Test
//	public void testEseguiPrendi() {
//		this.fake=new ComandoPrendi();
//		this.fake.setParametro("osso");
//		this.fake.setIOConsole(console);
//		this.fake.esegui(partita);
//		assertFalse(this.partita.getLabirinto().getStanzaCorrente().hasAttrezzo("osso"));
//		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo("osso"));
//		
//	}
//	
//	@Test
//	public void testEseguiPosa() {
//		this.partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("chiave", 1));
//		this.fake=new ComandoPosa();
//		this.fake.setParametro("chiave");
//		this.fake.setIOConsole(console);
//		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo("chiave"));
//		this.fake.esegui(partita);
//		assertTrue(this.partita.getLabirinto().getStanzaCorrente().hasAttrezzo("chiave"));
//		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("chiave"));
//		
//	}
	
	
	
	
	
	

}
