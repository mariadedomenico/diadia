//package it.uniroma3.diadia.comandi;
//
//import java.util.Scanner;
//
//import it.uniroma3.diadia.IO;
//
///**
// * classe FabbricaDiComandiFisarmonica
// * Crea i comandi della partita.
// * @author Maria
// * @version base
// *
// */
//
//public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi{
//
//	
//	/**
//	 * crea comandi
//	 * @param istruzione
//	 * @param console
//	 */
//	@Override //implementazione di un metodo nell'interfaccia
//	public Comando costruisciComando(String istruzione, IO console) {
//
//		Scanner scannerDiParole = new Scanner(istruzione);
//		String nomeComando = null;
//		String parametro = null;
//		Comando comando = null;
//		if (scannerDiParole.hasNext())
//			nomeComando = scannerDiParole.next(); // prima parola: nome del comando
//		if (scannerDiParole.hasNext())
//			parametro = scannerDiParole.next(); // seconda parola: eventuale parametro
//		if (nomeComando == null)
//			comando = new ComandoNonValido();
//		else if (nomeComando.equals("vai"))
//			comando = new ComandoVai();
//		 else if (nomeComando.equals("prendi"))
//		 comando = new ComandoPrendi();
//		 else if (nomeComando.equals("posa"))
//		 comando = new ComandoPosa();
//		 else if (nomeComando.equals("aiuto"))
//		 comando = new ComandoAiuto();
//		 else if (nomeComando.equals("fine"))
//		 comando = new ComandoFine();
//		 else if (nomeComando.equals("guarda"))
//		 comando = new ComandoGuarda();
//		 else
//		 comando = new ComandoNonValido();
//		comando.setParametro(parametro);
//		comando.setIOConsole(console);
//		return comando;
//	}
//
//}