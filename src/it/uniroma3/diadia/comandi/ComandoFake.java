package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoFake extends AbstractComando{

	
	@Override
	public void esegui(Partita partita) {
		partita.getLabirinto().setStanzaCorrente(new Stanza("prova"));
		
	}

}
