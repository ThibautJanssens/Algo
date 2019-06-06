
public class Personnes {
	private String nom,prenom;
	private Date dateNaissance;
	private Adresse domicile;
	
	public Personnes(String nom, String prenom, Date dateNaissance, Adresse domicile){
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.domicile = domicile;
	}
	
	public int donnerAgeEn2014(){
		return 2014 - this.dateNaissance.getAnnee(); 
	}
	
	public int donnerAgeEn(int anneeDonnee){
		return anneeDonnee - this.dateNaissance.getAnnee();
	}
	
	public Adresse fournirDomicile(){
		return this.domicile;
	}
	
	public Date dateNaissance(){
		return this.dateNaissance;
	}
	
	public String toString(){
		return this.nom + " "+ this.prenom +" "+ fournirDomicile()+ ". "+dateNaissance();
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void demenager(String rue,String numero , String codePostal, String ville) {
		Adresse demenagement = new Adresse(rue,numero, codePostal, ville);
		this.domicile = demenagement;
	}
}
