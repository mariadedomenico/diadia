package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoSaluta extends AbstractComando {

	private static final String MESSAGGIO_CON_CHI ="Che fai, parli con i fantasmi?";
	


	@Override
	public void esegui(Partita partita) {

		AbstractPersonaggio personaggio;
		personaggio = partita.getLabirinto().getStanzaCorrente().getPersonaggio();

		if (personaggio!=null) {
			getIo().mostraMessaggio(personaggio.saluta());

		} else getIo().mostraMessaggio(MESSAGGIO_CON_CHI);

	}

}
