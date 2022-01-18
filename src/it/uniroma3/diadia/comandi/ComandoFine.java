package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando{
	
	
	/**
	 * Comando "Fine".
	 * @param partita
	 */
	@Override
	public void esegui(Partita partita) {

			getIo().mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
			partita.setFinita();

	}



}
