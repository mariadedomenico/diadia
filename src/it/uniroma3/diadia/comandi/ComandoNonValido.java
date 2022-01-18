package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando{


	@Override
	
	/**
	 * stampa informazione se comando non valido
	 */
	public void esegui(Partita partita) {
		getIo().mostraMessaggio("Comando non valido");
		
	}

}
