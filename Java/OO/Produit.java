
public abstract class Produit {
	private String reference;
	private double prix;
	private String titre;
	
	public Produit(String reference, String titre, double prix) {
		this.reference = reference;
		this.prix = prix;
		this.titre = titre;
	}

	public String getReference() {
		return reference;
	}

	public String getTitre() {
		return titre;
	}
	

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public boolean equals(Object o){
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		Produit produit = (Produit) o;
		return this.getReference() == produit.getReference();
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reference == null) ? 0 : reference.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		return "Produit [reference=" + reference + ", prix=" + prix + ", titre=" + titre + "]";
	}
}