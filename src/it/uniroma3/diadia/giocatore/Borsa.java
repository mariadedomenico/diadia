package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Borsa - una borsa in un gioco di ruolo.
 * Una borsa e' un oggetto fisico a disposizione del giocatore nel gioco.
 * Puo' contenere degli attrezzi.
 * 
 * @author docente di POO e Maria
 * @see Attrezzo
 * @version base
 */

public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map<String, Attrezzo> attrezzi;
	private int pesoMax;
	private int pesoAttuale;



	/**
	 * Crea borsa che puo' sopportare al massimo 10kg.
	 */
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}



	/**
	 * Inizializza borsa. Non ci sono attrezzi e il peso massimo è 10.
	 * @param pesoMax, peso massimo sopportato.
	 */
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<String, Attrezzo>(); 
		this.pesoAttuale=0;
	}



	/**
	 * Aggiunge un attrezzo nella borsa.
	 * @param attrezzo, attrezzo da aggiungere.
	 * @return true se attrezzo aggiunto, altrimenti false.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo==null)
			return false;
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		Attrezzo vecchio=this.attrezzi.put(attrezzo.getNome(), attrezzo);
		if(vecchio!=null)
			this.pesoAttuale=this.pesoAttuale-vecchio.getPeso();
		this.pesoAttuale+=attrezzo.getPeso();
		return true;
	}



	/**
	 * Ritorna il peso massimo.
	 * @return pesoMax.
	 */
	public int getPesoMax() {
		return pesoMax;
	}




	/**
	 * Ritorna attrezzo desiderato.
	 * @param nomeAttrezzo da ritornare.
	 * @return attrezzo cercato se esiste, altrimenti null.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {

		return this.attrezzi.get(nomeAttrezzo);
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public Map<String, Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}

	/**
	 * Ritorna il peso totale degli attrezzi in borsa.
	 * @return peso totale.
	 */
	public int getPeso() {

		return this.pesoAttuale;
	}



	/**
	 * Verifica se nella borsa non ci siano attrezzi.
	 * @return true se la borsa è vuota, altrimenti false.
	 */
	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}



	/**
	 * Verifica che sia presente l'attrezzo ricercato.
	 * @param nomeAttrezzo da cercare.
	 * @return true se presente, altrimenti false.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}



	/**
	 * Rimuove un attrezzo dalla borsa.
	 * @param nomeAttrezzo da rimuovere
	 * @return attrezzo rimosso, se esistente, altrimenti null.
	 */
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		if(this.hasAttrezzo(nomeAttrezzo))
			this.pesoAttuale-=this.getAttrezzo(nomeAttrezzo).getPeso();
		return this.attrezzi.remove(nomeAttrezzo);
	}

	/**
	 * Restituisce una rappresentazione stringa della borsa, stampandone il contenuto.
	 * @return la rappresentazione stringa.
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			s.append(this.attrezzi.values().toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}


	/**
	 * Ritorna il contenuto della borsa in una lista ordinata per peso, o,
	 * a parità di peso, per nome
	 * @return attrezziPerPeso
	 */
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		List<Attrezzo> attrezziPerPeso=new ArrayList <Attrezzo>(this.attrezzi.values());
		Collections.sort(attrezziPerPeso, new ComparatoreAttrezziPerPeso());
		return attrezziPerPeso;
	}


	/**
	 * Ritorna il contenuto della borsa in un insieme ordinato per nome
	 * @return set
	 */
	public SortedSet <Attrezzo> getContenutoOrdinatoPerNome() {
		return new TreeSet<Attrezzo>(this.attrezzi.values());
	}

	
	/**
	 *restituisce una mappa che associa un intero (rappresentante un peso) con l’insieme degli attrezzi di 
	 *tale peso: tutti gli attrezzi dell'insieme che figura come valore hanno lo stesso peso pari 
	 *all'intero che figura come chiave
	 * @return mappa
	 */
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		Map<Integer, Set<Attrezzo>> mappa=new HashMap<Integer, Set<Attrezzo>>();
		Set<Attrezzo> tmp;
		Iterator<Attrezzo> it=this.attrezzi.values().iterator();

		while(it.hasNext()) {
			Attrezzo a=it.next();
			if(mappa.containsKey(a.getPeso())==false) {
				tmp=new HashSet<Attrezzo>();
				tmp.add(a);
				mappa.put(a.getPeso(), tmp);
			}
			else
				mappa.get(a.getPeso()).add(a);

		}

		return mappa;

	}

	/**
	 * restituisce l'insieme gli attrezzi nella borsa ordinati per peso e quindi, 
	 * a parità di peso, per nome
	 * @return attrezziPerPeso
	 */
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
		SortedSet<Attrezzo> attrezziPerPeso=new TreeSet <Attrezzo>(new ComparatoreAttrezziPerPeso());
		attrezziPerPeso.addAll(this.attrezzi.values());
		return attrezziPerPeso;
	}
}
