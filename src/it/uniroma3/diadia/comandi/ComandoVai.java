package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends AbstractComando{

	
	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 * @param partita
	 */
	@Override
	public void esegui(Partita partita) {
		
			if(getParametro()==null)
				getIo().mostraMessaggio("Dove vuoi andare ?");
			Stanza prossimaStanza = null;
			prossimaStanza = partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(getParametro());
			
			if (prossimaStanza == null)
				getIo().mostraMessaggio("Direzione inesistente");
			else {
				if(partita.getGiocatore().isVivo()==true) {
					partita.getLabirinto().setStanzaCorrente(prossimaStanza);
					int cfu = partita.getGiocatore().getCfu();
					partita.getGiocatore().setCfu(cfu-1);
				}
				
			}

			getIo().mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		
	}


	

}
