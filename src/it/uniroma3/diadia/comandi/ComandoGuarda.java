package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando {

	
	
	/**
	 * guarda stanza stampando descrizione
	 * @param partita
	 */
	@Override
	public void esegui(Partita partita) {
		
		getIo().mostraMessaggio("cfu:" + partita.getGiocatore().getCfu() + "\n" + partita.getLabirinto().getStanzaCorrente().getDescrizione() + "\n" + "Borsa: " + partita.getGiocatore().getBorsa().getContenutoOrdinatoPerNome().toString());
	}




}
