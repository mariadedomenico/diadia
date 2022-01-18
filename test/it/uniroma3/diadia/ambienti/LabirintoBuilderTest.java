package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilderTest {
		
	LabirintoBuilder lab;
	Stanza stanzaCorrente;
	Labirinto labirinto;
	Attrezzo attrezzo;
	
	@Before
	public void setUp() {
		this.lab=new LabirintoBuilder();
		this.stanzaCorrente=new Stanza("stanzaCorrente");
		this.labirinto=new Labirinto();
		this.lab.addStanza("stanzaCorrente");
		this.lab.addStanza("stanzaAdiacente");
		this.attrezzo=new Attrezzo("attrezzo", 1);
		
		
	}

	@Test
	public void testAddStanzaIniziale() {
		assertEquals("stanzaIniziale" , this.lab.addStanzaIniziale("stanzaIniziale").getNome());
	}

	@Test
	public void testAddStanzaVincente() {
		assertEquals("stanzaVincente" , this.lab.addStanzaVincente("stanzaVincente").getNome());
	}

	@Test
	public void testAddStanza() {
		assertEquals("stanza" , this.lab.addStanza("stanza").getNome());
	}

	@Test
	public void testGetStanzaCorrente() {
		this.lab.setStanzaCorrente(this.stanzaCorrente);
		assertSame(this.stanzaCorrente, this.lab.getStanzaCorrente());
	}


	@Test
	public void testGetStanzaIniziale() {
		this.lab.setStanzaIniziale(this.stanzaCorrente);
		assertSame(this.stanzaCorrente, this.lab.getStanzaIniziale());
	}


	@Test
	public void testGetStanzaVincente() {
		this.lab.setStanzaVincente(this.stanzaCorrente);
		assertSame(this.stanzaCorrente, this.lab.getStanzaVincente());
	}

	@Test
	public void testGetLabirinto() {
		assertSame(this.lab, this.lab.getLabirinto());
	}

	@Test
	public void testAddAdiacenza() {
		this.lab.addAdiacenza("stanzaCorrente", "stanzaAdiacente", "nord");
		assertEquals("stanzaAdiacente", this.lab.getMappaStanza().get("stanzaCorrente").getStanzaAdiacente("nord").getNome());
	}

	@Test
	public void testAddAttrezzoLabBuilder() {
		assertTrue(this.lab.addAttrezzoLabBuilder("osso", 1));
		assertTrue(this.lab.getMappaStanza().get("stanzaAdiacente").hasAttrezzo("osso"));
	}
	
	@Test
	public void testMonolocale() {
		
		LabirintoBuilder lab=new LabirintoBuilder();
		lab.addStanzaIniziale("salotto");
		lab.addAttrezzoLabBuilder("divano", 3);
		assertTrue(lab.getMappaStanza().containsKey("salotto"));
		assertTrue(lab.getMappaStanza().get("salotto").hasAttrezzo("divano"));
		assertEquals("salotto", lab.getStanzaIniziale().getNome());
		assertEquals("salotto", lab.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testBilocale() {
		
		LabirintoBuilder lab=new LabirintoBuilder();
		lab.addStanzaIniziale("salotto");
		lab.addAttrezzoLabBuilder("divano", 3);
		lab.addStanza("cucina");
		lab.addAdiacenza("salotto", "cucina", "nord");
		lab.addAttrezzoLabBuilder("pentola", 1);
	
		assertTrue(lab.getMappaStanza().containsKey("salotto"));
		assertTrue(lab.getMappaStanza().containsKey("cucina"));
		assertEquals("cucina", lab.getMappaStanza().get("salotto").getStanzaAdiacente("nord").getNome());
		assertTrue(lab.getMappaStanza().get("salotto").hasAttrezzo("divano"));
		assertTrue(lab.getMappaStanza().get("cucina").hasAttrezzo("pentola"));
		assertEquals("salotto", lab.getStanzaIniziale().getNome());
		assertEquals("salotto", lab.getStanzaCorrente().getNome());
		
	}
	
	@Test
	public void testAppartamento() {
		
		LabirintoBuilder lab=new LabirintoBuilder();
		lab.addStanzaIniziale("salotto");
		lab.addAttrezzoLabBuilder("divano", 3);
		lab.addStanza("cucina");
		lab.addAdiacenza("salotto", "cucina", "nord");
		lab.addAdiacenza("cucina", "salotto", "sud");
		lab.addAttrezzoLabBuilder("pentola", 1);
		lab.addStanza("camera da letto");
		lab.addAdiacenza("salotto", "camera da letto", "sud");
		lab.addAdiacenza("camera da letto", "salotto", "nord");
		lab.addAttrezzoLabBuilder("letto", 100);
		lab.addStanzaVincente("bagno");
		lab.addAdiacenza("camera da letto", "bagno", "est");
		lab.addAdiacenza("bagno", "camera da letto", "ovest");
		lab.addAttrezzoLabBuilder("spazzolino", 1);
	
		assertTrue(lab.getMappaStanza().containsKey("salotto"));
		assertTrue(lab.getMappaStanza().containsKey("cucina"));
		assertTrue(lab.getMappaStanza().containsKey("bagno"));
		assertTrue(lab.getMappaStanza().containsKey("camera da letto"));
		assertEquals("camera da letto", lab.getMappaStanza().get("salotto").getStanzaAdiacente("sud").getNome());
		assertEquals("cucina", lab.getMappaStanza().get("salotto").getStanzaAdiacente("nord").getNome());
		assertEquals("bagno", lab.getMappaStanza().get("camera da letto").getStanzaAdiacente("est").getNome());
		assertEquals("camera da letto", lab.getMappaStanza().get("bagno").getStanzaAdiacente("ovest").getNome());
		assertEquals("salotto", lab.getMappaStanza().get("cucina").getStanzaAdiacente("sud").getNome());
		assertEquals("salotto", lab.getMappaStanza().get("camera da letto").getStanzaAdiacente("nord").getNome());
		assertTrue(lab.getMappaStanza().get("salotto").hasAttrezzo("divano"));
		assertTrue(lab.getMappaStanza().get("cucina").hasAttrezzo("pentola"));
		assertTrue(lab.getMappaStanza().get("camera da letto").hasAttrezzo("letto"));
		assertTrue(lab.getMappaStanza().get("bagno").hasAttrezzo("spazzolino"));
		assertEquals("salotto", lab.getStanzaIniziale().getNome());
		assertEquals("bagno", lab.getStanzaVincente().getNome());
		assertEquals("salotto", lab.getStanzaCorrente().getNome());
		
	}

}
