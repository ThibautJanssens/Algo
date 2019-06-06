import java.time.LocalDate;

public class Client {
	private String numeroRegistreNational;
	private String nom;
	private String prenom;
	private String adresse;
	private LocalDate dateDeNaissance;
	private String telephonne;
	private CompteCourant compteCourant;
	private CompteEpargne compteEpargne;
	
	public Client(String numeroRegistreNational, String nom, String prenom, String adresse, LocalDate dateDeNaissance, 
			String telephonne, CompteCourant compteCourant, CompteEpargne compteEpargne){
		if (this.numeroRegistreNational == null || this.nom == null || this.prenom == null ||
				this.adresse == null || this.dateDeNaissance == null || compteCourant == null || compteEpargne == null)
			throw new IllegalArgumentException();
		this.numeroRegistreNational = numeroRegistreNational;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.dateDeNaissance = dateDeNaissance;
		this.telephonne = telephonne;
		this.compteCourant = compteCourant;
		this.compteEpargne = compteEpargne;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephonne() {
		return telephonne;
	}

	public void setTelephonne(String telephonne) {
		this.telephonne = telephonne;
	}

	public String getNumeroRegistreNational() {
		return numeroRegistreNational;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}

	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroRegistreNational == null) ? 0 : numeroRegistreNational.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (numeroRegistreNational == null) {
			if (other.numeroRegistreNational != null)
				return false;
		} else if (!numeroRegistreNational.equals(other.numeroRegistreNational))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [numeroRegistreNational=" + numeroRegistreNational + ", nom=" + nom + ", prenom=" + prenom
				+ ", adresse=" + adresse + ", dateDeNaissance=" + dateDeNaissance + ", telephonne=" + telephonne + "]";
	}
}
