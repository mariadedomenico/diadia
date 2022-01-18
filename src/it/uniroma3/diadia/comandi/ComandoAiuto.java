package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando{

	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda", "regala", "saluta", "interagisci"};
	
	
	/**
	 * Stampa informazioni di aiuto.
	 * @param partita
	 */
	@Override
	public void esegui(Partita partita) {

		for(int i=0; i<this.elencoComandi.length; i++) 
			getIo().mostraMessaggio(this.elencoComandi[i]+" ");

	}
	



}
