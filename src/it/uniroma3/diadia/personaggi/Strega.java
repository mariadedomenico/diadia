package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio{
	
	private static final String msg_salutato="Higitus figitus abracazè, andrai nella stanza con più attrezzi per te!";
	private static final String msg_permaloso="Parim-pam-pum, nella stanza con meno attrezzi andrai tu!";
	
	Attrezzo a;

	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
		this.a=null;
	}

	@Override
	public String agisci(Partita partita) {
		
		Stanza min=partita.getLabirinto().getStanzaCorrente().stanzaAdiacentiMinore();
		Stanza max=partita.getLabirinto().getStanzaCorrente().stanzaAdiacentiMaggiore();
		
		if(haSalutato()) {
			partita.getLabirinto().setStanzaCorrente(max);
			return msg_salutato;
		}
		
		partita.getLabirinto().setStanzaCorrente(min);
		return msg_permaloso;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		
		this.a=attrezzo;
		partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo.getNome());
		return "AHAHAHAHHAHAHAH MIOOOOO";
	}
	
	
	
	

}
