
public class CompteEpargne extends CompteEnBanque{
	public CompteEpargne(String numero){
		super(numero,0,0);
	}
	
	public void emettreVirement(double montant, CompteEnBanque compteTiers)throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Vous ne pouvez pas a partir d'un compte epargne.");
	}
	
	public void setDecouvertMaximum(int decouvertMax)throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Vous ne pouvez pas a partir d'un compte epargne.");
	}
}