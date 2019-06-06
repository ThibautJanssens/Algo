
public class Cd extends Produit{
	private String artiste;
	private int nbMorceaux;
	
	public Cd(String reference, String titre, double prix, String artiste, int nbMorceaux) {
		super(reference, titre, prix);
		this.artiste = artiste;
		this.nbMorceaux = nbMorceaux;
	}
	
	public String getArtiste() {
		return artiste;
	}
	
	public int getNbMorceaux() {
		return nbMorceaux;
	}
	
	@Override
	public String toString() {
		return "Cd [artiste=" + artiste + ", nbMorceaux=" + nbMorceaux + "]";
	}
}