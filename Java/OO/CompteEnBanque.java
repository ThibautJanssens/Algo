
public class CompteEnBanque {
	private String numero;
	private double solde;
	private Personnes titulaire;
	
	public CompteEnBanque(String numero, double solde, Personnes titulaire){
		this.numero = numero;
		this.solde = solde;
		this.titulaire = titulaire;
	}
	
	public boolean retrait(double montant){
		if (montant < solde){
			this.solde = this.solde - montant;
			return true;
		}else{
			System.out.println("Solde de votre compte insuffisant.");
			return false;
		}
	}
	
	public void depot(double montant){
		solde += montant;
	}
	
	public boolean virement(double montant, CompteEnBanque autre){
		if (montant > solde){
			System.out.println("Solde de votre compte insuffisant.");
			return false;
		}
		else{
			solde -= montant;
			autre.solde +=montant;
			return true;
		}
	}
	
	public String getNumero(){
		return this.numero;
	}
	
	public double getSolde(){
		return this.solde;
	}
	
	public Personnes getTitulaire(){
		return this.titulaire;
	}
	
	public String toString(){
		return this.titulaire.getNom()+" "+this.titulaire.getPrenom()+" (n de compte: "+this.numero+") a actuelement "+this.solde+" € sur son compte.";
	}
}
