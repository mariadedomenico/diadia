package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;


/**
 * Classe LabirintoBuilder - un insieme di stanze in un gioco di ruolo.
 * Un labirinto e' un luogo fisico nel gioco.
 * Partendo da una stanza corrente, bisogna raggiungere la stanza vincente.
 * Classe che permette la cerazione di un nuovo labirinto
 * 
 * 
 * @author Maria 
 * @see Stanza
 * @see Attrezzo
 * @version base
 */

public class LabirintoBuilder extends Labirinto{

	private Stanza stanzaCorrente;
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	private Stanza ultimaStanza;
	private Map<String, Stanza> mappaStanze;
	
	/**
	 * imposta una mappa di stanze
	 */
	public LabirintoBuilder() {
		this.mappaStanze=new HashMap<String, Stanza>();
	}
	
	/**
	 * aggiunge una stanza iniziale, impostandola come prima stanza corrente
	 * @param nome
	 * @return stanzaIniziale
	 */
	public Stanza addStanzaIniziale(String nome) {
		this.stanzaIniziale=this.addStanza(nome);
		this.stanzaCorrente=this.stanzaIniziale;
		return stanzaIniziale;
	}
	
	
	/**
	 * aggiunge una stanza vincente
	 * @param nome
	 * @return stanzaVincente
	 */
	public Stanza addStanzaVincente(String nome) {
		this.stanzaVincente=this.addStanza(nome);
		return stanzaVincente;
	}
	
	
	/**
	 * aggiunge una stanza, definendola come ultima stanza aggiunta
	 * @param nome
	 * @return stanza
	 */
	public Stanza addStanza(String nome) {
		Stanza stanza=new Stanza(nome);
		this.mappaStanze.put(nome, stanza);
		this.ultimaStanza=stanza;
		return stanza;
	}
	
	
	/**
	 * imposta la stanza corrente
	 * @param s, stanza da impostare
	 */
	@Override
	public void setStanzaCorrente(Stanza s) {
		this.stanzaCorrente=s;
	}
	
	/**
	 * ritorna la stanza corrente
	 * @return stanzaCorrente
	 */
	@Override
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	/**
	 * imposta la stanza iniziale
	 * @param s, stanza da impostare
	 */
	public void setStanzaIniziale(Stanza s) {
		this.stanzaIniziale=s;
	}
	
	
	/**
	 * ritorna la stanza iniziale
	 * @return stanzaIniziale
	 */
	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}
	
	
	/**
	 * imposta la stanza vincente
	 * @param s, stanza da impostare
	 */
	@Override
	public void setStanzaVincente(Stanza s) {
		this.stanzaVincente=s;
	}
	
	
	/**
	 * ritorna la stanza vincente
	 * @return stanzaVincente
	 */
	@Override
	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}
	
	
	/**
	 * ritorna il labirinto
	 * @return this, riferiemnto al labirinto corrente
	 */
	public LabirintoBuilder getLabirinto() {
		return this;
	}
	
	/**
	 * ritorna l'ultima stanza aggiunta
	 * @return ultimaStanza
	 */
	public Stanza getUltimaStanza() {
		return this.ultimaStanza;
	}
	
	
	/**
	 * imposta stanze adiacenti
	 * @param stanza
	 * @param stanzaAdiacente
	 * @param direzione
	 */
	public void addAdiacenza(String stanza, String stanzaAdiacente, String direzione) {
		Stanza stanza1=this.mappaStanze.get(stanza);
		Stanza stanzaAd=this.mappaStanze.get(stanzaAdiacente);
		stanza1.impostaStanzaAdiacente(direzione, stanzaAd);
		
	}
	
	
	/**
	 * ritorna la mappa delle stanze
	 * @return mappaStanze
	 */
	public Map<String, Stanza> getMappaStanza() {
		return this.mappaStanze;
	}
	
	
	/**
	 * aggiunge un attrezzo nell'ultima stanza aggiunta
	 * @param nome
	 * @param peso
	 * @return true se l'attrezzo è stato aggiunto, false altrimenti
	 */
	public boolean addAttrezzoLabBuilder(String nome, int peso) {
		Attrezzo a=new Attrezzo(nome, peso);
		if(this.ultimaStanza==null)
			return false;
		
		return this.ultimaStanza.addAttrezzo(a);
	}
	
	
	
	
	
	
}
