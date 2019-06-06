public class Articles {
	private String reference, nom, description;
	private double prixHTVA, tauxTVA;
	private static int nbreArticle = 0;
	
	public Articles(String reference, String nom, String description, double prixHTVA) {
		this(reference, nom, description, prixHTVA,21.0);
	}
	public Articles(String reference, String nom, String description, double prixHTVA, double tauxTVA)throws IllegalArgumentException {
		if (reference == null || reference == " " || nom == " " || nom == null || prixHTVA <= 0 || tauxTVA < 0) throw new IllegalArgumentException("Ton parametre est incorrect.");
		this.reference = reference;
		this.nom = nom;
		this.description = description;
		this.prixHTVA = prixHTVA;
		this.tauxTVA = tauxTVA;
		nbreArticle ++;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getPrixHTVA() {
		return prixHTVA;
	}
	
	public void setPrixHTVA(double prixHTVA) {
		if (prixHTVA <= 0) throw new IllegalArgumentException();
		this.prixHTVA = prixHTVA;
	}
	
	public double getTauxTVA() {
		return tauxTVA;
	}
	
	public void setTauxTVA(double tauxTVA) {
		if (tauxTVA < 0) throw new IllegalArgumentException();
		this.tauxTVA = tauxTVA;
	}
	
	public String getReference() {
		return reference;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String toString() {
		return "Articles [reference=" + reference + ", nom=" + nom + ", description=" + description + "]";
	}
	
	public double calculerPrix(){
		return this.prixHTVA * (1 + (this.tauxTVA / 100));
	}
	
	public double calculerPrix(double remise){
		return this.calculerPrix() * ( 1 - ( remise / 100));
	}
	
	public static int getNbreArticle(){
		return nbreArticle;
	}
}
