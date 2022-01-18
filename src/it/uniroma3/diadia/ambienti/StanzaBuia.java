package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe StanzaBuia - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' possibile guardare nella stanza solo se presente l'attrezzo torcia
 * 
 * @see Attrezzo
 * @version base
 * @author Maria
 *
 */

public class StanzaBuia extends Stanza{

	static final private String NOME_ATTREZZO_PARTICOLARE="torcia";
	private String nomeAttrezzoParticolare;
	
	
	/**
	 * imposta la stanzaBuia
	 * @param nome della stanza
	 */
	public StanzaBuia(String nome) {
		super(nome);
		this.nomeAttrezzoParticolare=NOME_ATTREZZO_PARTICOLARE;
	}
	
	
	/**
	 * @return descizione stanza se presente torcia
	 */
	@Override
	public String getDescrizione() {
		
		if(super.hasAttrezzo(this.nomeAttrezzoParticolare)==true) {
			return super.toString();
		}
		else
			return "Qui c'è buio pesto";
	}

}
