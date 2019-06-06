

public class Livres{
	private String isbn;
	private String nom;
	private String prenom;
	private String titre;
	private int nbPages;
	private double prixConseille;
	private int anneeEdition ;

	public Livres(String isbn, String nom, String titre,
			int nbPages, double prixConseille, int anneeEdition) {
		this(isbn, nom, null, titre, nbPages, prixConseille, anneeEdition);
	}
	
	public Livres(String isbn, String nom, String prenom, String titre,
			int nbPages, double prixConseille, int anneeEdition) {
		if (isbn == null) throw new NullPointerException("L'isbn ne peut pas être null");
		if (nom == null) throw new NullPointerException("Le nom ne peut pas être null");
		if (titre == null) throw new NullPointerException("Le titre ne peut pas être null");
		if (isbn.equals("")) throw new IllegalArgumentException("L'isbn ne peut pas être une chaîne de caractères vide.");
		if (nom.equals("")) throw new IllegalArgumentException("Le nom ne peut pas être une chaîne de caractères vide.");
		if (prenom.equals("")) throw new IllegalArgumentException("Le prenom ne peut pas être une chaîne de caractères vide.");
		if (titre.equals("")) throw new IllegalArgumentException("Le titre ne peut pas être une chaîne de caractères vide."); 
		if (nbPages <=0) throw new IllegalArgumentException("Le nombre de pages doit être strictement positif");
		this.isbn = isbn;
		this.nom = nom;
		this.prenom = prenom;
		this.titre = titre;
		this.nbPages = nbPages;
		this.setPrixConseille(prixConseille);
		this.anneeEdition = anneeEdition;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitre() {
		return titre;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public int getNbPages() {
		return nbPages;
	}

	public double getPrixConseille() {
		return prixConseille;
	}
	

	public int getAnneeEdition() {
		return anneeEdition;
	}

	public void setPrixConseille(double prixConseille)  {
		if (prixConseille < 0) throw new IllegalArgumentException("Le prix ne peut pas être négatif");
		this.prixConseille = prixConseille;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livres other = (Livres) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}

	public String toString(){
		return titre +  " de " + nom + " " + prenom;
	}
}
