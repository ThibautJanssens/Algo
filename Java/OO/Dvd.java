
public class Dvd extends Produit{
	private String realisateur;

	public Dvd(String reference, String titre, double prix, String realisateur) {
		super(reference, titre, prix);
		this.realisateur = realisateur;
	}

	public String getRealisateur() {
		return realisateur;
	}

	@Override
	public String toString() {
		return "Dvd [realisateur=" + realisateur + "]";
	}
}