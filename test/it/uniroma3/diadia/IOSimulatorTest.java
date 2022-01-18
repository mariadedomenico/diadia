package it.uniroma3.diadia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class IOSimulatorTest {

	private DiaDia gioca;
	private DiaDia gioca2;
	private DiaDia gioca6;
	private IOSimulator console;
	private IOSimulator console2;
	private IOSimulator console6;
	private Map<Integer, String> map= new HashMap<Integer, String>() ;
	private Map<Integer, String> map2=new HashMap<Integer, String>();
	private Map<Integer, String> map6=new HashMap<Integer, String>();

	@Before
	public void setUp() {
		this.map.put(0, "vai sud");
		this.map.put(1, "posa osso");
		this.map.put(2, "guarda");
		this.map.put(3, "fine");

		this.map2.put(0, "vai sud");
		this.map2.put(1, "posa osso");

		this.map6.put(0, "aiuto");
		this.map6.put(1, "vai sud");
		this.map6.put(2, "prendi ascia");
		this.map6.put(3, "guarda");
		this.map6.put(4, "posa ascia");
		this.map6.put(5, "fine");






	}

	@Test
	public void testVaiPosaGuardaFine() throws Exception {
		this.console=new IOSimulator(this.map);
		this.gioca=new DiaDia(this.console);
		this.gioca.gioca();
		assertTrue(this.console.hasNextMessaggio());
		assertEquals(""+"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
				"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
				"I locali sono popolati da strani personaggi, " +
				"alcuni amici, altri... chissa!\n"+
				"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
				"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
				"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
				"Per conoscere le istruzioni usa il comando 'aiuto'.", this.console.nextMessaggio() );
		assertTrue(this.console.hasNextMessaggio());
		assertEquals(this.gioca.getPartita().getLabirinto().getStanzaCorrente().getDescrizione(), this.console.nextMessaggio());
		assertTrue(this.console.hasNextMessaggio());
		assertEquals("Scegli un attrezzo valido", this.console.nextMessaggio());
		assertTrue(this.console.hasNextMessaggio());
		assertEquals("cfu:19\n" + this.gioca.getPartita().getLabirinto().getStanzaCorrente().getDescrizione() + "\nBorsa: " + this.gioca.getPartita().getGiocatore().getBorsa().getContenutoOrdinatoPerNome().toString(), this.console.nextMessaggio());
		assertTrue(this.console.hasNextMessaggio());
		assertEquals("Grazie di aver giocato!", this.console.nextMessaggio());
		assertFalse(this.console.hasNextMessaggio());
	}

	@Test
	public void testVaiPosa() throws Exception {

		this.console2=new IOSimulator(this.map2);
		this.gioca2=new DiaDia(this.console2);
		this.gioca2.gioca();
		assertTrue(this.console2.hasNextMessaggio());
		assertEquals(""+"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
				"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
				"I locali sono popolati da strani personaggi, " +
				"alcuni amici, altri... chissa!\n"+
				"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
				"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
				"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
				"Per conoscere le istruzioni usa il comando 'aiuto'.", this.console2.nextMessaggio() );
		assertTrue(this.console2.hasNextMessaggio());
		assertEquals(this.gioca2.getPartita().getLabirinto().getStanzaCorrente().getDescrizione(), this.console2.nextMessaggio());
		assertTrue(this.console2.hasNextMessaggio());
		assertEquals("Scegli un attrezzo valido", this.console2.nextMessaggio());
		assertFalse(this.console2.hasNextMessaggio());
	}

	@Test
	public void testVaiPosaGuardaFineAiutoPrendi() throws Exception {

		this.console6=new IOSimulator(this.map6);
		this.gioca6=new DiaDia(this.console6);
		this.gioca6.gioca();

		assertTrue(this.console6.hasNextMessaggio());
		assertEquals(""+"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
				"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
				"I locali sono popolati da strani personaggi, " +
				"alcuni amici, altri... chissa!\n"+
				"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
				"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
				"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
				"Per conoscere le istruzioni usa il comando 'aiuto'.", this.console6.nextMessaggio() );
		assertTrue(this.console6.hasNextMessaggio());
		assertEquals("vai ", this.console6.nextMessaggio());
		assertTrue(this.console6.hasNextMessaggio());
		assertEquals("aiuto ", this.console6.nextMessaggio());
		assertTrue(this.console6.hasNextMessaggio());
		assertEquals("fine ", this.console6.nextMessaggio());
		assertTrue(this.console6.hasNextMessaggio());
		assertEquals("prendi ", this.console6.nextMessaggio());
		assertTrue(this.console6.hasNextMessaggio());
		assertEquals("posa ", this.console6.nextMessaggio());
		assertTrue(this.console6.hasNextMessaggio());
		assertEquals("guarda ", this.console6.nextMessaggio());
		assertTrue(this.console6.hasNextMessaggio());
		assertEquals("regala ", this.console6.nextMessaggio());
		assertTrue(this.console6.hasNextMessaggio());
		assertEquals("saluta ", this.console6.nextMessaggio());
		assertTrue(this.console6.hasNextMessaggio());
		assertEquals("interagisci ", this.console6.nextMessaggio());
		assertTrue(this.console6.hasNextMessaggio());
		assertEquals(this.gioca6.getPartita().getLabirinto().getStanzaCorrente().getDescrizione(), this.console6.nextMessaggio());
		assertTrue(this.console6.hasNextMessaggio());
		assertEquals("Scegli un attrezzo valido oppure posane uno... troppi attrezzi :(", this.console6.nextMessaggio());
		assertTrue(this.console6.hasNextMessaggio());
		assertEquals("cfu:19\n" + this.gioca6.getPartita().getLabirinto().getStanzaCorrente().getDescrizione() + "\nBorsa: " + this.gioca6.getPartita().getGiocatore().getBorsa().getContenutoOrdinatoPerNome().toString(), this.console6.nextMessaggio());
		assertTrue(this.console6.hasNextMessaggio());
		assertEquals("Scegli un attrezzo valido", this.console6.nextMessaggio());
		assertTrue(this.console6.hasNextMessaggio());
		assertEquals("Grazie di aver giocato!", this.console6.nextMessaggio());
		assertFalse(this.console6.hasNextMessaggio());
	}


	
	
	
	
}
