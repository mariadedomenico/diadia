package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import it.uniroma3.diadia.IOconsole;

public class FabbricaDiComandiRiflessivaTest {

	private IOconsole console;
	private FabbricaDiComandiRiflessiva fabbrica=new FabbricaDiComandiRiflessiva();
	
	@Test
	public void testCostruisciComandoAiuto() throws Exception {
		assertEquals("aiuto", this.fabbrica.costruisciComando("aiuto", this.console).getNome());
	}
	
	@Test
	public void testCostruisciComandoPrendi() throws Exception {
		assertEquals("prendi", this.fabbrica.costruisciComando("prendi", this.console).getNome());
		assertEquals("osso", this.fabbrica.costruisciComando("prendi osso", this.console).getParametro());
	}
	
	@Test
	public void testCostruisciComandoPosa() throws Exception {
		assertEquals("posa", this.fabbrica.costruisciComando("posa", this.console).getNome());
		assertEquals("osso", this.fabbrica.costruisciComando("posa osso", this.console).getParametro());
	}

	@Test
	public void testCostruisciComandoFine() throws Exception {
		assertEquals("fine", this.fabbrica.costruisciComando("fine", this.console).getNome());
	}
	
	@Test
	public void testCostruisciComandoGuarda() throws Exception {
		assertEquals("guarda", this.fabbrica.costruisciComando("guarda", this.console).getNome());
	}
	
	@Test
	public void testCostruisciComandoVai() throws Exception {
		assertEquals("vai", this.fabbrica.costruisciComando("vai", this.console).getNome());
		assertEquals("nord", this.fabbrica.costruisciComando("vai nord", this.console).getParametro());
	}
}
