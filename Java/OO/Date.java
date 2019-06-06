
public class Date {
	private int jour, mois, annee;
	
	public Date(int jour, int mois, int annee){
		if (mois > 12 || mois < 1) throw new IllegalArgumentException("Mois invalide.");
		if (jour > 31 || jour < 1) throw new IllegalArgumentException("Jour invalide.");
		this.jour = jour;
		this.mois = mois;
		this.annee = annee;
	}
	
	public int getJour(){
		return this.jour;
	}
	
	public int getMois(){
		return this.mois;
	}
	
	public int getAnnee(){
		return this.annee;
	}
	
	public String toString(){
		return "Ne le "+jour+"/"+mois+"/"+annee;
	}	
}