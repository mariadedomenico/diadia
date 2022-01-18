package it.uniroma3.diadia;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe IOSimulator - per le interazioni con utenti.
 * Sostituisce i system.in e i system.out
 * 
 * @author Maria
 * @version base
 */

public class IOSimulator implements IO {

	private Map<Integer, String> righeDaLeggere;
	private int indiceRigheDaLeggere;
	private Map<Integer, String> messaggiProdotti;
	private int indiceMessaggiMostrati;
	private int indiceMessaggiProdotti;
	
	/**
	 * imposta console
	 * @param righeDaLeggere
	 */
	public IOSimulator(Map<Integer, String> righeDaLeggere) {
		this.righeDaLeggere=righeDaLeggere;
		this.indiceRigheDaLeggere=0;
		this.indiceMessaggiMostrati=0;
		this.indiceMessaggiProdotti=0;
		this.messaggiProdotti=new HashMap<Integer, String>();
	}
	
	
	/**
	 * salva i messaggi da mostrare
	 * @param messaggio
	 */
	@Override
	public void mostraMessaggio(String messaggio) {
		this.messaggiProdotti.put(indiceMessaggiProdotti, messaggio);
		this.indiceMessaggiProdotti++;

	}

	
	
	/**
	 * prende stringa da mappa righeDaLeggere
	 * @return rigaLetta
	 */
	@Override
	public String leggiRiga() {
		String rigaLetta=this.righeDaLeggere.get(indiceRigheDaLeggere);
		this.indiceRigheDaLeggere++;
		return rigaLetta;
	}
	
	
	/**
	 * Mostra il prossimo messaggio
	 * @return next messaggio
	 */
	public String nextMessaggio() {
		
		String next=this.messaggiProdotti.get(indiceMessaggiMostrati);
		this.indiceMessaggiMostrati++;
		return next;
	}
	
	
	/**
	 * verifica che ci sia un altro messaggio da mostrare
	 * @return true se esiste, false altrimenti
	 */
	public boolean hasNextMessaggio() {
		return this.indiceMessaggiMostrati<this.indiceMessaggiProdotti;
	}

}
