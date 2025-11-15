package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {

	private Innlegg[] samling;
	private int antall;
	public Blogg() {
		this.samling = new Innlegg[20];
		this.antall = 0;
	}

	public Blogg(int lengde) {
		this.samling = new Innlegg[lengde];
		this.antall = 0;
	}

	public int getAntall() {
		return this.antall;
	}
	
	public Innlegg[] getSamling() {
		return this.samling;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		for (int i = 0; i < antall; i++) {
			if (samling[i].erLik(innlegg)) {
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		return finnInnlegg(innlegg) >= 0;
	}

	public boolean ledigPlass() {
		return antall < samling.length;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		if (ledigPlass()) {
			samling[antall] = innlegg;
			antall++;
			return true;
		}
		return false;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(antall).append("\n");
		for (int i = 0; i < antall; i++) {
			sb.append(samling[i].toString());
		}
		return sb.toString();
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] nySamling = new Innlegg[samling.length * 2];
		for (int i = 0; i < samling.length; i++) {
			nySamling[i] = samling[i];
		}
		samling = nySamling;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		if (ledigPlass()) {
			return leggTil(innlegg);
		} else {
			utvid();
			return leggTil(innlegg);
		}
		
	}
	
	public boolean slett(Innlegg innlegg) {
		int index = finnInnlegg(innlegg);
		if (index >= 0) {
			for (int i = index; i < antall - 1; i++) {
				samling[i] = samling[i + 1];
			}
			samling[antall - 1] = null;
			antall--;
			return true;
		}
		return false;
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}