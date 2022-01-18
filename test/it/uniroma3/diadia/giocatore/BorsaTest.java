package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {

	private Borsa borsa=new Borsa();

	/*ritorna una borsa con una serie di attrezzi aggiunti*/
	private Borsa creaBorsa(int peso, String...attrezzi) {

		Borsa borsa= new Borsa();
		for(int i=0; i<attrezzi.length; i++) {
			borsa.addAttrezzo(new Attrezzo(attrezzi[i], peso));
		}

		return borsa;
	}


	/*ritorna una borsa con una serie di attrezzi aggiunti*/
	private Borsa creaBorsaElementiPesoDiverso(int peso1, int peso2, String attrezzo1, String attrezzo2) {

		Borsa borsa= new Borsa();
		borsa.addAttrezzo(new Attrezzo(attrezzo1, peso1));
		borsa.addAttrezzo(new Attrezzo(attrezzo2, peso2));

		return borsa;
	}


	//test su metodo addAttrezzo
	@Test
	public void testAddAttrezzoNotNull() {

		assertTrue(this.borsa.addAttrezzo(new Attrezzo("osso", 1)));
	}

	@Test
	public void testAddAttrezzoNull() {

		assertFalse(this.borsa.addAttrezzo(null));
		assertEquals(0, this.borsa.getPeso());
	}

	@Test
	public void testAddAttrezzoChePesaTroppo() {

		assertFalse(this.borsa.addAttrezzo(new Attrezzo("osso", 11)));
		assertEquals(0, this.borsa.getPeso());
	}
	
	@Test
	public void testAddAttrezzoEsistente() {

		this.borsa.addAttrezzo(new Attrezzo("osso", 1));
		assertEquals(1, this.borsa.getPeso());
		assertTrue(this.borsa.addAttrezzo(new Attrezzo("osso", 2)));
		assertEquals(2, this.borsa.getAttrezzo("osso").getPeso());
		assertEquals(2, this.borsa.getPeso());
	}


	//test su metodo getPesoMax
	@Test
	public void testGetPesoMax() {

		assertTrue(10==creaBorsa(1, "osso").getPesoMax());
	}


	//test su metodo getAttrezzo
	@Test
	public void testGetAttrezzo() {

		assertEquals("osso", creaBorsa(1, "osso").getAttrezzo("osso").getNome());
	}

	@Test
	public void testGetAttrezzoNonEsistente() {

		assertNull(creaBorsa(1, "osso").getAttrezzo("lanterna"));
	}


	//test su metodo getPeso
	@Test
	public void testGetPeso() {

		assertTrue(1==creaBorsa(1, "osso").getPeso());
	}


	//test su metodo removeAttrezzo
	@Test
	public void testRemovePrimoAttrezzo() {

		Borsa borsa=creaBorsa(1, "osso", "lanterna");
		assertTrue(borsa.getAttrezzo("osso")==borsa.removeAttrezzo("osso"));
	}

	@Test
	public void testRemoveUltimoAttrezzo() {

		Borsa borsa=creaBorsa(1, "osso", "lanterna");
		assertTrue(borsa.getAttrezzo("lanterna")==borsa.removeAttrezzo("lanterna"));
		
		
	}

	@Test
	public void testRemoveAttrezzoCentrale() {

		Borsa borsa=creaBorsa(1, "osso", "lanterna", "spada");
		assertTrue(borsa.getAttrezzo("lanterna")==borsa.removeAttrezzo("lanterna"));
	}

	@Test
	public void testRemoveAttrezzoInesistente() {

		Borsa borsa=creaBorsa(1, "osso", "lanterna");
		assertTrue(borsa.getAttrezzo("scudo")==borsa.removeAttrezzo("scudo"));
		
	}

	@Test
	public void testSortedSetOrdinatoPerNome() {
		Borsa borsa=creaBorsa(1, "osso", "lanterna");
		SortedSet<Attrezzo> set=borsa.getContenutoOrdinatoPerNome();
		Iterator<Attrezzo> it=set.iterator();
		assertTrue(it.hasNext());
		assertEquals("lanterna", it.next().getNome());
		assertTrue(it.hasNext());
		assertEquals("osso", it.next().getNome());
		assertFalse(it.hasNext());

	}
	
	@Test
	public void testSortedSetOrdinatoPerNomePesoDiverso() {
		Borsa borsa=creaBorsaElementiPesoDiverso(1, 2, "osso", "lanterna");
		SortedSet<Attrezzo> set=borsa.getContenutoOrdinatoPerNome();
		Iterator<Attrezzo> it=set.iterator();
		assertTrue(it.hasNext());
		assertEquals("lanterna", it.next().getNome());
		assertTrue(it.hasNext());
		assertEquals("osso", it.next().getNome());
		assertFalse(it.hasNext());

	}
	
	@Test
	public void testGetContenutoOrdinatoPerPesoDiversoGiaOrdinato() {
		Borsa borsa=creaBorsaElementiPesoDiverso(1, 2, "osso", "lanterna");
		List<Attrezzo> list=borsa.getContenutoOrdinatoPerPeso();
		Iterator<Attrezzo> it=list.iterator();
		assertTrue(it.hasNext());
		assertEquals("osso", it.next().getNome());
		assertTrue(it.hasNext());
		assertEquals("lanterna", it.next().getNome());
		assertFalse(it.hasNext());

	}
	
	
	@Test
	public void testGetContenutoOrdinatoPerPesoDiversoNoOrdinato() {
		Borsa borsa=creaBorsaElementiPesoDiverso(3, 2, "osso", "lanterna");
		List<Attrezzo> list=borsa.getContenutoOrdinatoPerPeso();
		Iterator<Attrezzo> it=list.iterator();
		assertTrue(it.hasNext());
		assertEquals("lanterna", it.next().getNome());
		assertTrue(it.hasNext());
		assertEquals("osso", it.next().getNome());
		assertFalse(it.hasNext());

	}
	

	@Test
	public void testGetContenutoOrdinatoPerPesoUguale() {
		Borsa borsa=creaBorsa(1, "osso", "lanterna");
		List<Attrezzo> list=borsa.getContenutoOrdinatoPerPeso();
		Iterator<Attrezzo> it=list.iterator();
		assertTrue(it.hasNext());
		assertEquals("lanterna", it.next().getNome());
		assertTrue(it.hasNext());
		assertEquals("osso", it.next().getNome());
		assertFalse(it.hasNext());
	}

	@Test
	public void testGetContenutoRaggruppatoPerPesoUguale() {
		Borsa borsa=creaBorsa(1, "osso", "lanterna");
		Map<Integer, Set<Attrezzo>> mappa=borsa.getContenutoRaggruppatoPerPeso();
		Iterator<Set<Attrezzo>> it=mappa.values().iterator();
		assertTrue(it.hasNext());
		Set<Attrezzo> set=it.next();
		Iterator<Attrezzo> it2=set.iterator();
		assertTrue(it2.hasNext());
		assertEquals("osso", it2.next().getNome());
		assertTrue(it2.hasNext());
		assertEquals("lanterna", it2.next().getNome());
		assertFalse(it2.hasNext());
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPesoDiverso() {
		Borsa borsa=creaBorsaElementiPesoDiverso(2, 1, "osso", "lanterna");
		Map<Integer, Set<Attrezzo>> mappa=borsa.getContenutoRaggruppatoPerPeso();
		Iterator<Set<Attrezzo>> it=mappa.values().iterator();
		assertTrue(it.hasNext());
		Set<Attrezzo> set=it.next();
		Iterator<Attrezzo> it2=set.iterator();
		assertTrue(it2.hasNext());
		assertEquals("lanterna", it2.next().getNome());
		assertFalse(it2.hasNext());
		assertTrue(it.hasNext());
		Set<Attrezzo> set1=it.next();
		Iterator<Attrezzo> it3=set1.iterator();
		assertEquals("osso", it3.next().getNome());
		assertFalse(it3.hasNext());
	}


}
