package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoRegala extends AbstractComando{

	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio=partita.getLabirinto().getStanzaCorrente().getPersonaggio();
		if(personaggio!=null) {
			if(partita.getGiocatore().getBorsa().hasAttrezzo(getParametro())) {
				String msg=personaggio.riceviRegalo(partita.getGiocatore().getBorsa().getAttrezzi().get(getParametro()), partita);
				getIo().mostraMessaggio(msg);
			}
			else
				getIo().mostraMessaggio("Niente regalo :(");
		}
		else
			getIo().mostraMessaggio("Non so a chi regalarlo");
		
	}
	
	

}
