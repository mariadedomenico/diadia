package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe StanzaBloccata - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite, la cui uscita a nord è bloccata.
 * La stanza adiacente a nord puo' essere sbloccata solo se nella stessa corrente è presente
 * l'attrezzo chiave.
 * 
 * @author Maria 
 * @see Attrezzo
 * @version base
 */

public class StanzaBloccata extends Stanza {

	private static final String NOME_DIREZIONE_BLOCCATA = "nord";
	static final private String NOME_ATTREZZO_PARTICOLARE= "chiave";

	private String nomeAttrezzoParticolare;
	private String nomeDirezioneBloccata;
	private Stanza stanzaCorrente;

	/**
	 * Inizializza la stanza
	 * @param nome della stanza
	 */
	public StanzaBloccata(String nome) {
		super(nome);
		this.nomeAttrezzoParticolare=NOME_ATTREZZO_PARTICOLARE;
		this.nomeDirezioneBloccata=NOME_DIREZIONE_BLOCCATA;
	}

	
	/**
	 * Ritorna la stanza adiacente
	 * @param dir, direzione della stanza adiacente
	 * @return stanzaAdiacente se esiste e non è bloccata, altrimenti stanzaCorrente
	 */
	
	@Override
	public Stanza getStanzaAdiacente(String dir) {

		if(dir!=null) {
			if(dir.equals(this.nomeDirezioneBloccata)) {
				if(this.stanzaCorrente.hasAttrezzo(this.nomeAttrezzoParticolare)==true) {

					return super.getStanzaAdiacente(dir);
				}
				else
					return this.stanzaCorrente;
			}
			else
				return super.getStanzaAdiacente(dir);
		}
		else
			return this.stanzaCorrente;


	}

	
	/**
	 * modifica la stanzaCorrete
	 * @param stanza, nuova stanza
	 */
	public void setStanzaCorrente(Stanza stanza) {
		this.stanzaCorrente=stanza;
	}


	
	/**
	 * Ritorna la descrizione della stanza
	 * @return descrizione
	 */
	@Override
	public String getDescrizione() {

		if(super.hasAttrezzo(this.nomeAttrezzoParticolare)==true || super.hasDirezione(NOME_DIREZIONE_BLOCCATA)==false)
			return super.toString();
		else
			return super.toString()+ "\nImpossibile accedere a nord, scegli un'altra direzione per cambiare stanza";
	}


}
