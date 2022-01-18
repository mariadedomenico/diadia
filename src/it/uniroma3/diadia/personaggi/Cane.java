package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{

	private static final String msg_morso = "Can che abbaia... MORDE!";
	private static final String msg_salvo= "Non svegliare il can che dorme";
	private static final String msg_regalo= "Congratulazioni! Il cane ha apprezzato il regalo";
	private static final String msg_regaloRifiutato= "Aia! Il cane non ha apprezzato il regalo... meglio scappare";
	private static final String preferito= "biscotto";
	
	Attrezzo prefe;
	Attrezzo inBocca;
	
			
	public Cane(String nome, String presentazione) {
		super(nome, presentazione);
		this.prefe=new Attrezzo(preferito, 1);
		this.inBocca=new Attrezzo("chiave", 1);
		
	}
	
	@Override
	public String agisci(Partita partita) {
		
		if(haSalutato()) {
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
			return msg_morso;
		}
		return msg_salvo;
		
	}
	
	@Override
	public String riceviRegalo(Attrezzo a, Partita p) {
		
		if(a.getNome().equals(this.prefe.getNome())) {
			p.getGiocatore().getBorsa().removeAttrezzo(a.getNome());
			p.getLabirinto().getStanzaCorrente().addAttrezzo(this.inBocca);
			this.inBocca=a;
			return msg_regalo;	
		}
		
		p.getGiocatore().setCfu(p.getGiocatore().getCfu()-1);
		return msg_regaloRifiutato;
		
	}
	

}
