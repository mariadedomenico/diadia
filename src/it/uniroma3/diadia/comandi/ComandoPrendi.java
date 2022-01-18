package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando {
	
	
	/**
	 * Comando "Prendi". Rimuove attrezzo dalla stanza e lo aggiunge in borsa.
	 * @param partita
	 */
	@Override
	public void esegui(Partita partita) {

		if(getParametro()==null)
			getIo().mostraMessaggio("Che attrezzo vuoi prendere?");

		Attrezzo a=partita.getLabirinto().getStanzaCorrente().getAttrezzo(getParametro());

		if(partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a)==true) {
			if((partita.getGiocatore().getBorsa().getPeso()+a.getPeso())<partita.getGiocatore().getBorsa().getPesoMax()) {
				partita.getGiocatore().getBorsa().addAttrezzo(a);
				getIo().mostraMessaggio("Attrezzo aggiunto in borsa");
			}
			else{
				getIo().mostraMessaggio("Impossibile aggiungere attrezzo. Peso massimo raggiunto");
				partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
			}
		}
		else
			getIo().mostraMessaggio("Scegli un attrezzo valido oppure posane uno... troppi attrezzi :(");

	}
	

	

}
