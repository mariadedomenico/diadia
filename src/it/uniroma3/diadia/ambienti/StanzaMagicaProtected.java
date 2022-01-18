package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;


/**
 * Classe StanzaMagica - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * Superata una certa soglia, vengono modificati il nome e il peso degli attrezzi aggiunti,
 * invertendo il nome e peso.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
 */

public class StanzaMagicaProtected extends StanzaProtected {


	static final protected int SOGLIA_MAGICA_DEFAULT = 3;
	protected int contatoreAttrezziPosati;
	protected int sogliaMagica;

	
	/**
	 * imposta stanza magica con soglia di default
	 * @param nome della stanza
	 */
	public StanzaMagicaProtected(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}

	
	/**
	 * imposta stanza magica con soglia scelta
	 * @param nome della stanza
	 * @param soglia
	 */
	public StanzaMagicaProtected(String nome, int soglia) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;
	}


	
	/**
	 * aggiunge attrezzi nella stanza, applicando magia una volta superata la soglia
	 * @param attrezzo da aggiungere
	 * @return true se viene aggiunto, altrimenti false
	 */
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		this.contatoreAttrezziPosati++;
		if (this.contatoreAttrezziPosati>this.sogliaMagica)
			attrezzo = this.modificaAttrezzo(attrezzo);
		return super.addAttrezzo(attrezzo);
	}

	
	/**
	 * modifica nome attrezzo, invertendo lettere, e duplica peso
	 * @param attrezzo da modificare
	 * @return attrezzo modificato
	 */
	protected Attrezzo modificaAttrezzo(Attrezzo attrezzo) {

		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo.setNome(nomeInvertito.toString());
		attrezzo.setPeso(pesoX2);
		return attrezzo;
	}
}
