package it.uniroma3.diadia;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {

	/*Ritorna una partita, impostando la stanza corrente e i cfu a disposizione.
	 * Imposto la stanza vincente uguale alla stanza corrente, cosi' da avere lo stesso riferimento ad oggetto.
	 */
	
	private Partita creaPartita(String stanzaCorrente, int cfu, boolean finita) {

		Partita partita=new Partita();
		Stanza stanza=new Stanza(stanzaCorrente);
		
		partita.getLabirinto().setStanzaCorrente(stanza);
		partita.getGiocatore().setCfu(cfu);
		
		if(stanzaCorrente.equals("Biblioteca"))
			partita.getLabirinto().setStanzaVincente(stanza);
		
		if(finita==true)
			partita.setFinita();
		
		return partita;
	}

	//test su metodo vinta()
	@Test
	public void testStanzaCorrenteDiversaStanzaVincente() {
		assertFalse("stanzaCorrente uguale da stanzaVincente", creaPartita("Aula N10", 20, false).vinta());
	}

	@Test
	public void testStanzaCorrenteUgualeStanzaVincente() {
		assertTrue("stanzaCorrente diversa da stanzaVincente", creaPartita("Biblioteca", 20, false).vinta());
	}
	
	@Test
	public void testStanzaCorrenteUgualeStanzaVincenteCfuFiniti() {
		assertTrue(creaPartita("Biblioteca", 0, false).vinta());
	}
	
	
	//test su metodo isFinita
	@Test
	public void testIsFinitaVintaStanzaVincenteUgualeStanzaCorrente() {
	
		assertTrue(creaPartita("Biblioteca", 20, false).isFinita());
	}
	
	@Test
	public void testIsFinitaPersaPartitaFinitaSetFinitaTrue() {
	
		assertTrue(creaPartita("Atrio", 20, true).isFinita());
	}
	
	@Test
	public void testIsFinitaCfuFiniti() {
	
		assertTrue(creaPartita("Atrio", 0, false).isFinita());
	}
	
	@Test
	public void testIsFinitaFalse() {
	
		assertFalse(creaPartita("Atrio", 20, false).isFinita());
	}
	
	
	
	
	
	
	



}
