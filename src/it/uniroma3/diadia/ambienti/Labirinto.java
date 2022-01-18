package it.uniroma3.diadia.ambienti;


import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;


/**
 * Classe Labirinto - un insieme di stanze in un gioco di ruolo.
 * Un labirinto e' un luogo fisico nel gioco.
 * Partendo da una stanza corrente, bisogna raggiungere la stanza vincente.
 * 
 * 
 * @author Maria 
 * @see Stanza
 * @version base
 */

public class Labirinto {
	
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private Stanza stanzaIniziale;
	
	/**
     * Crea tutte le stanze e le porte di collegamento
     */
	public Labirinto() {
		
		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo chiave=new Attrezzo("chiave", 1);
		Attrezzo biscotto=new Attrezzo("biscotto", 1);
    	
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		StanzaBloccata aulaN10 = new StanzaBloccata("Aula N10");
		aulaN10.setStanzaCorrente(aulaN10);
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		
		/*crea personaggi*/
		AbstractPersonaggio strega=new Strega("Hermione", " Sono una strega permalosa, ti conviene salutarmi");
		AbstractPersonaggio mago=new Mago("Merlino", " Sono il mago generoso", new Attrezzo("bacchetta", 1));
		AbstractPersonaggio cane=new Cane("Fuffi", " Sono un cane da temere");
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

        /* pone gli attrezzi nelle stanze */
		
		aulaN10.addAttrezzo(lanterna);
		aulaN10.addAttrezzo(chiave);
		atrio.addAttrezzo(osso);
		atrio.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		atrio.addAttrezzo(osso);
		aulaN10.addAttrezzo(biscotto);
		
		
		/*pone i personaggi*/
		atrio.setPersonaggio(cane);
		aulaN10.setPersonaggio(strega);
		aulaN11.setPersonaggio(mago);
		
		
		// il gioco comincia nell'atrio
        stanzaCorrente = atrio;  
		stanzaVincente = biblioteca;
	}
	
	

	
	/**
	 * Restituisce la stanza vincente
	 * @return stanzaVincente
	 */
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	
	/**
	 * imposta stanza corrente
	 * @param stanzaCorrente, stanza in cui si trova il giocatore
	 */
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	

	/**
	 * imposta stanza vincente
	 * @param stanzaVincente, stanza in cui gioco finisce
	 */
	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}
	
	/**
	 * Restituisce la stanza corrente
	 * @return stanzaCorrente
	 */
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}


	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}


	public void setStanzaIniziale(Stanza stanzaIniziale) {
		this.stanzaIniziale = stanzaIniziale;
	}

}
