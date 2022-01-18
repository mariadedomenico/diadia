package it.uniroma3.diadia.giocatore;

public class Giocatore {
	
	/**
	 * Classe Giocatore - un personaggio in un gioco di ruolo.
	 * Possiede una borsa per raccogliere attrezzi utili.
	 * Ha disposizione dei cfu che diminuiscono nel corso della partita. 
	 * Arrivati a 0 cfu, la partita è persa.
	 * 
	 * @author Maria 
	 * @see Borsa
	 * @version base
	 */
	
	static final private int CFU_INIZIALI = 20;
	private int cfu;
	private Borsa borsa;
	
	
	
	/**
	 * Crea giocatore.
	 */
	public Giocatore() {
		this.borsa=new Borsa();
		this.cfu = CFU_INIZIALI;
	}
	
	
	
	/**
	 * Ritorna la borsa.
	 * @return borsa
	 */
	public Borsa getBorsa() {
		return this.borsa;
	}
	
	
	
	/**
	 * Imposta la borsa.
	 * @param borsa da impostare.
	 */
	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;		
	}
	
	
	
	/**
	 * Ritorna i cfu correnti.
	 * @return cfu
	 */
	public int getCfu() {
		return this.cfu;
	}

	
	
	
	/**
	 * Imposta cfu
	 * @param cfu
	 */
	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	
	public boolean isVivo() {
		return this.cfu>0;
	}
}

