package it.uniroma3.diadia.giocatore;

import java.util.Comparator;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComparatoreAttrezziPerPeso implements Comparator<Attrezzo> {

	@Override
	public int compare(Attrezzo o1, Attrezzo o2) {
		int cmp=o1.getPeso()-o2.getPeso();
		if(cmp==0)
			return o1.getNome().compareTo(o2.getNome());
		return cmp;
	}
}
