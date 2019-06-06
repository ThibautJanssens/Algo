
public class Etudiant {
	private String matricule, nom, prenom;
	private Serie serie;
	
	public Etudiant(String matricule, String nom, String prenom, Serie serie) {	
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.serie = serie;
	}
	
	public void changerSerie(Serie newSerie){
		if (newSerie == null)throw new IllegalArgumentException("Veuillez une série valide.");
		if (this.serie == newSerie || this.matricule == this.serie.getDelegue().getMatricule())throw new IllegalArgumentException("L'étudiant est soit le délégue, soit appartient déjà à la série.");
		else{
			this.serie = newSerie;
		}
	}
	
	public String getMatricule() {
		return this.matricule;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	
	public Serie getSerie() {
		return this.serie;
	}
	
	public String toString() {
		return this.matricule + " " + this.nom + " "+ this.prenom + " est dans la série " + this.serie;
	}
	
}
