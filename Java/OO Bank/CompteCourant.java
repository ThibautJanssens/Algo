
public class CompteCourant extends CompteEnBanque{
	public CompteCourant(String numero, double solde, int decouvertMax){
		super(numero, solde, decouvertMax);
	}
	
	public CompteCourant(String numero, int decouvertMax){
		super(numero, 0, decouvertMax);
	}
}