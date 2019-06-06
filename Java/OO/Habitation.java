
public class Habitation {
	private Personnes proprietaire;
	private Adresse adresse;
	private double revenuCadastral, surface;
	private int anneeConstruction;
	
	public Habitation(Personnes proprietaire, Adresse adresse, double revenuCadastral, double surface, int anneeConstruction) {
		if (proprietaire == null)throw new IllegalArgumentException("Veuillez entrer un proprietaire valide.");
		if (adresse == null)throw new IllegalArgumentException("Veuillez entrer une adresse valide.");
		if (revenuCadastral < 0)throw new IllegalArgumentException("Veuillez entrer un revenu cadastral valide.");
		if (surface <= 0)throw new IllegalArgumentException("Veuillez entrer une surface valide.");
		if (anneeConstruction < 1000 )throw new IllegalArgumentException("Veuillez entrer une année valide.");
		this.proprietaire = proprietaire;
		this.adresse = adresse;
		this.revenuCadastral = revenuCadastral;
		this.surface = surface;
		this.anneeConstruction = anneeConstruction;
	}

	public Personnes getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Personnes proprietaire) {
		this.proprietaire = proprietaire;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public double getRevenuCadastral() {
		return revenuCadastral;
	}

	public double getSurface() {
		return surface;
	}

	public int getAnneeConstruction() {
		return anneeConstruction;
	}
	
	public void miseAJourRevenu(double coefficient)throws IllegalArgumentException{
		if (coefficient <= 1) throw new IllegalArgumentException("TON COEFFICIENT CONNARD DE MERDE JE T ENCULLE.");
		this.revenuCadastral = this.revenuCadastral*coefficient;
	}
	
	public double calculPrecompte(double pourcentage){
		if (pourcentage <= 0 && pourcentage > 100)throw new IllegalArgumentException("POURCENTAGE INCORRECTEUH. connard du con fdp de pute.");
		return (this.revenuCadastral * pourcentage ) /100;
	}
	
	public String toString() {
		return "Le proprietaire de l'habitation situé "+adresse+" , est " + proprietaire + ".\nLe revenu cadastral est de "
				+ revenuCadastral + ".\nL'habitation fait une surface d'environ " + surface + " et a été contruite en " + anneeConstruction + ".";
	}
}
