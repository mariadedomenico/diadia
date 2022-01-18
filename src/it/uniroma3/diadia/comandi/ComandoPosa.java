package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa extends AbstractComando{

	
	@Override
	/**
	 * Comando "Posa". Rimuove attrezzo dalla borsa e lo aggiunge in stanza.
	 * @param partita
	 */
	public void esegui(Partita partita) {

		if(getParametro()==null)
			getIo().mostraMessaggio("Che attrezzo vuoi posare?");

		Attrezzo a=partita.getGiocatore().getBorsa().removeAttrezzo(getParametro());

		if(a!=null) {
			boolean verificato=partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
			if(verificato==false) {
				getIo().mostraMessaggio("Raggiunto numero massimo di attrezzi. Impossibile aggiungerne uno nuovo");
				partita.getGiocatore().getBorsa().addAttrezzo(a);
			}	
			else
				getIo().mostraMessaggio("Attrezzo posato");
		}
		else
			getIo().mostraMessaggio("Scegli un attrezzo valido");
	}



}
