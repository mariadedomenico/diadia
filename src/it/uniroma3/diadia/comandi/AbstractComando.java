package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public abstract class AbstractComando {

	private IO io;
	private String parametro;
	
	abstract public void esegui(Partita partita);
	public IO getIo() {
		return this.io;
	}
	
	public void setIOConsole(IO console) {
		this.io=console;
	}
	
	public String getNome() {
		int indice=this.getClass().getCanonicalName().indexOf("Comando"); //primo indice in cui appare Comando
		return this.getClass().getCanonicalName().substring(indice+7).toLowerCase();
	}
	
	
	public String getParametro() {
		return this.parametro;
	}
	
	public void setParametro(String parametro) {
		this.parametro=parametro;
	}
	
	
}
