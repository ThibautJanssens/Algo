import java.util.ArrayList;

public class Panier {
	private ArrayList<Produit> produits;
	
	public Panier(){
		produits = new ArrayList<Produit>(10);
	}
	
	public void rajouter(Produit p) throws CaddiePleinException{
		if (produits.size() == 10)
			throw new CaddiePleinException();
		else
			produits.add(p);
	}
	
	public void supprimer(Produit p)throws CaddieVideException, ProduitNonPresent{
		if (produits.size()==0)
			throw new CaddieVideException();
		
		if (!produits.contains(p))
			throw new ProduitNonPresent();
		
		else
			produits.remove(p);
	}
	
	public int nbProduit(){
		return produits.size();
	}

	@Override
	public String toString() {
		return "Panier [produits=" + produits + "]";
	}
}