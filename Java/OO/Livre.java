
public class Livre extends Produit{
	private String auteur;
	private int nbPages;
	
	public Livre(String reference, String titre, double prix, String auteur, int nbPages) {
		super(reference, titre, prix);
		this.auteur = auteur;
		this.nbPages = nbPages;
	}

	public String getAuteur() {
		return auteur;
	}

	public int getNbPages() {
		return nbPages;
	}

	@Override
	public String toString() {
		return "Livre [auteur=" + auteur + ", nbPages=" + nbPages + "]";
	}
}