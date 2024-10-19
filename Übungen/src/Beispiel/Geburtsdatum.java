package Beispiel;
public class Geburtsdatum {
	private int geburtstag;
	private int geburtsmonat;
	private int geburtsjahr;

	public Geburtsdatum(String geburtstag, String geburtsmonat, String geburtsjahr) {
		this.geburtstag = Integer.parseInt(geburtstag);
		this.geburtsmonat = Integer.parseInt(geburtsmonat);
		this.geburtsjahr = Integer.parseInt(geburtsjahr);
	}

	public String gibGeburtsdatumZurueck() {
		return this.getGeburtstag() + "." + this.getGeburtsmonat() + "." + this.getGeburtsjahr();
	}

	public int getGeburtstag() {
		return geburtstag;
	}

	public void setGeburtstag(int geburtstag) {
		this.geburtstag = geburtstag;
	}

	public int getGeburtsmonat() {
		return geburtsmonat;
	}

	public void setGeburtsmonat(int geburtsmonat) {
		this.geburtsmonat = geburtsmonat;
	}

	public int getGeburtsjahr() {
		return geburtsjahr;
	}

	public void setGeburtsjahr(int geburtsjahr) {
		this.geburtsjahr = geburtsjahr;
	}

}