package it.uniroma3.diadia;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Properties;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.comandi.AbstractComando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessiva;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 * 
 * @see Partita
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	

	private Partita partita;
	private IO ioconsole;


	/**
	 * Inizia la partita.
	 */
	public DiaDia(Labirinto lab, IO ioconsole) {
		this.partita = new Partita(lab);
		this.ioconsole=ioconsole;
	}
	
	public DiaDia(IO ioconsole) {
		this.partita = new Partita();
		this.ioconsole=ioconsole;
	}

	public Partita getPartita() {
		return this.partita;
	}
	
	/**
	 * Legge istruzioni.
	 * @throws Exception 
	 * 
	 */
	public void gioca() throws Exception {

		this.ioconsole.mostraMessaggio(MESSAGGIO_BENVENUTO);
		String istruzione;

		do		{
			istruzione = this.ioconsole.leggiRiga();
			if(istruzione==null)
				break;
		}
		while (!processaIstruzione(istruzione));
	}   



	/**
	 * Processa una istruzione 
	 * @param istruzione, da processare
	 * @return false se l'istruzione e' eseguita e il gioco continua, true altrimenti
	 * @throws Exception 
	 */
	private boolean processaIstruzione(String istruzione) throws Exception {
		
		
		AbstractComando comandoDaEseguire;
		FabbricaDiComandiRiflessiva factory = new FabbricaDiComandiRiflessiva();
		comandoDaEseguire = factory.costruisciComando(istruzione, ioconsole);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())
			this.ioconsole.mostraMessaggio("Hai vinto!");
		
		if (!this.partita.giocatoreIsVivo())
			this.ioconsole.mostraMessaggio("Hai esaurito i CFU...");
			
		return this.partita.isFinita();
	}


	public static void main(String[] argc) throws Exception {
		
		IO io=new IOconsole();
		Labirinto labirinto = new LabirintoBuilder();
		LabirintoBuilder lab=(LabirintoBuilder) labirinto;
		lab.addStanzaIniziale("LabCampusOne");
		lab.addStanzaVincente("Biblioteca");
		lab.addAdiacenza("LabCampusOne","Biblioteca","ovest");

		
		Properties prop=new Properties();
		prop.setProperty("cfu_iniziali", "10");
		prop.setProperty("peso_max_borsa", "20");
		prop.setProperty("nome direzione stanza bloccata", "nord");
		prop.setProperty("nome oggetto sbloccante", "chiave");
		prop.setProperty("nome oggetto stanza buia", "torcia");
		prop.setProperty("soglia magica", "3");
		prop.setProperty("comando aiuto", "vai, aiuto, fine, prendi, posa, guarda, regala, saluta, interagisci");
		prop.setProperty("nome oggetto preferito dal cane", "biscotto");
		prop.store(new FileWriter("diadia.properties"), "Configurazione del gioco DIADIA");
		
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
	}
}