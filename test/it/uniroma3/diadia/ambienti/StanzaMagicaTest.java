package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {

	private StanzaMagicaProtected stanzaMagica;
	private Attrezzo lanterna;
	private Attrezzo scudo;
	private Attrezzo spada;
	private Attrezzo osso;
	
	@Before
	public void setUp() {
		this.stanzaMagica=new StanzaMagicaProtected("Atrio");
		this.lanterna=new Attrezzo("lanterna", 3);
		this.scudo=new Attrezzo("scudo", 2);
		this.spada=new Attrezzo("spada", 2);
		this.osso=new Attrezzo("osso", 1);
	}
	
	@Test
	public void modificaAttrezzo() {
		lanterna=stanzaMagica.modificaAttrezzo(lanterna);
		assertEquals(6, lanterna.getPeso());
		assertEquals("anretnal", lanterna.getNome());
	}
	
	
	@Test
	public void testAddAttrezzoValido() {
		assertTrue(this.stanzaMagica.addAttrezzo(lanterna));
		assertEquals(3, lanterna.getPeso());
		assertEquals("lanterna", lanterna.getNome());
	}
	
	@Test
	public void testAddAttrezzoNonValido() {
		assertFalse(this.stanzaMagica.addAttrezzo(null));
	}
	
	@Test
	public void testAddAttrezzoSogliaMax() {
		this.stanzaMagica.addAttrezzo(osso);
		this.stanzaMagica.addAttrezzo(lanterna);
		this.stanzaMagica.addAttrezzo(spada);
		assertTrue(this.stanzaMagica.addAttrezzo(scudo));
		assertEquals(4, scudo.getPeso());
		assertEquals("oducs", scudo.getNome());
	}

}
