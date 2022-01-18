package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Labirinto
 * @see Giocatore
 * @version base
 */

public class Partita {


	private boolean finita;
	private Labirinto lab;
	private Giocatore giocatore;
	
	
	/**
	 * Crea una partita
	 */
	public Partita(){
		
		this.lab= new Labirinto(/*"it/uniroma3/diadia/ambienti/labirinto1.txt"*/);
		this.finita = false;
		this.giocatore= new Giocatore();

	}
	
	/**
	 * Crea una partita con labirinto
	 * @param lab 
	 */
	public Partita(Labirinto lab){
		
		this.lab= lab;
		this.finita = false;
		this.giocatore= new Giocatore();

	}
	
	public void setLabirinto(Labirinto lab) {
		this.lab=lab;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		
		return this.lab.getStanzaCorrente()==this.lab.getStanzaVincente(); 
	}

	
	
	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (giocatore.getCfu() == 0);
	}
	
	
	
	/**
	 * Restituisce il labirinto
	 * @return labirinto
	 */
	public Labirinto getLabirinto() {
		
		return this.lab;
	}
	
	
	
	/**
	 * Restituisce il giocatore
	 * @return giocatore
	 */
	public Giocatore getGiocatore() {
		
		return this.giocatore;
	}
	
	
	
	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	public boolean giocatoreIsVivo() {
		return this.getGiocatore().isVivo();
	}
	
}
