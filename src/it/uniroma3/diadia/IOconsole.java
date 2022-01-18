package it.uniroma3.diadia;
import java.util.Scanner;

/**
 * Classe IOconsole - per le interazioni con utenti.
 * Sostituisce i system.in e i system.out
 * 
 * @author docente di POO
 * @version base
 */

public class IOconsole implements IO {

	/**
	 * Stampa una stringa
	 * @param msg, messaggio da stampare
	 */
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	
	
	/**
	 * Gestisce la lettura delle linee di comando
	 * @return riga
	 */
	public String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();

		return riga;
	}
}
