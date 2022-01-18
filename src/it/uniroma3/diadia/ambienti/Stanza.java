package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
 */

public class Stanza {

	private String nome;
	private Map<String, Attrezzo> attrezzi;
	private Map<String, Stanza> stanzeAdiacenti;
	private Set<String> direzioni;
	private int numeroAttrezzi;
	private AbstractPersonaggio personaggio;


	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	public Stanza(String nome) {
		this.nome = nome;
		this.direzioni = new HashSet<String>();
		this.stanzeAdiacenti = new HashMap<String, Stanza>();
		this.attrezzi = new HashMap<String, Attrezzo>();
		this.numeroAttrezzi=0;
	}



	/**
	 * Imposta una stanza adiacente.
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(String direzione, Stanza stanza) {

		Stanza vecchia;

		if(direzione!="nord" && direzione!="sud" && direzione!="est" && direzione!="ovest") {
			return;
		}

		vecchia=this.stanzeAdiacenti.put(direzione, stanza);
		if(vecchia==null) {
			this.direzioni.add(direzione);

		}
	}



	/**
	 * Restituisce la stanza adiacente nella direzione specificata.
	 * @param direzione.
	 * @return stanza adiacente se esiste, altrimenti null.
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		return this.stanzeAdiacenti.get(direzione);
	}



	/**
	 * Restituisce la nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}



	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}



	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public Map<String, Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}



	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false altrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo==null || this.numeroAttrezzi==10)
			return false;

		this.attrezzi.put(attrezzo.getNome(), attrezzo);
		this.numeroAttrezzi++;
		return true;


	}



	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite:");
		for (String direzione : this.direzioni) {
			if (direzione!=null) 
				risultato.append(" " + direzione);
		}
		risultato.append("\nAttrezzi nella stanza: ");
		risultato.append(this.attrezzi.values().toString()+" ");

		return risultato.toString();
	}




	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}



	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}



	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param attrezzo, l'attrezzo da rimuovere dalla stanza
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {

		if(attrezzo==null || this.hasAttrezzo(attrezzo.getNome())==false)
			return false;

		this.attrezzi.remove(attrezzo.getNome(), attrezzo);
		return true;
	}



	/**
	 * Restituisce direzioni possibili
	 * @return sequenza direzioni ammissibili
	 */
	public Set<String> getDirezioni() {
		return this.stanzeAdiacenti.keySet();
	}


	/**
	 * Verifica che sia presente la direzione passata
	 * @param direzione
	 * @return true se esiste, false altrimenti
	 */
	public boolean hasDirezione(String direzione) {
		return this.direzioni.contains(direzione);
	}

	public Stanza stanzaAdiacentiMaggiore() {
		Stanza max=null;
		int conta=-1;
		for(Stanza s:this.stanzeAdiacenti.values()) {
			if(s!=null) {
				if(s.getAttrezzi().size()>conta) {
					conta=s.getAttrezzi().size();
					max=s;
				}
			}
		}

		return max;
	}


	public Stanza stanzaAdiacentiMinore() {
		Stanza min=null;
		int conta=50000; //assurdo
		for(Stanza s:this.stanzeAdiacenti.values()) {
			if(s!=null) {
				if(s.getAttrezzi().size()<conta) {
					conta=s.getAttrezzi().size();
					min=s;
				}
			}

		}
		return min;
	}

	public AbstractPersonaggio getPersonaggio() {
		return this.personaggio;
	}
	
	public void setPersonaggio(AbstractPersonaggio personaggio) {
		this.personaggio=personaggio;
	}
}