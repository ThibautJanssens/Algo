import java.util.ArrayList;

public abstract class CompteEnBanque  {
	private String numero;
	private double solde;
	private int decouvertMaximum;
	private boolean cloture;
	private int numOp = 0;
	private ArrayList<Operation> operation;
	
	public CompteEnBanque(String numero, double solde, int decouvertMaximum){
		if(decouvertMaximum < 0)throw new IllegalArgumentException("Veuillez mettre un découvert raisonable.");
		if(solde < 0)throw new IllegalArgumentException("Veuillez creer un compte avec un solde raisonable.");
		
		this.numero = numero;
		this.solde = solde;
		this.decouvertMaximum = decouvertMaximum;
	}

	public String getNumero() {
		return numero;
	}

	public double getSolde() {
		return solde;
	}

	public int getDecouvertMaximum() {
		return decouvertMaximum;
	}

	public void setDecouvertMaximum(int decouvertMaximum) {
		if(decouvertMaximum < 0) throw new IllegalArgumentException("Decouvert non raisonable.");
		
		this.decouvertMaximum = decouvertMaximum;
	}
	
	public boolean isCloture() {
		return cloture;
	}
	
	public void deposer(double montant) throws IsClosedException{
		if(this.cloture)throw new IsClosedException();
		if(montant <= 0)throw new IllegalArgumentException("Veuillez déposer un montant realiste.");
		
		this.solde += montant;
		this.numOp ++;
		
		Operation op = new Operation(numOp,montant, 0);
		operation.add(op);
	}
	
	public void retirer(double montant)throws IsClosedException, TooPoorException{
		if(this.cloture)throw new IsClosedException();
		if(montant <= 0)throw new IllegalArgumentException("Veuillez retiré un montant realiste.");
		if(this.solde - montant < this.decouvertMaximum) throw new TooPoorException();
		
		this.numOp++;
		this.solde -= montant;
		
		Operation op = new Operation(numOp, montant, 1);
		operation.add(op);
	}
	
	private void recevoirVirement(double montant, CompteEnBanque compteTiers)throws IsClosedException{
		if(this.cloture)throw new IsClosedException();
		if(montant <= 0)throw new IllegalArgumentException("Veuillez déposer un montant realiste.");
		if(compteTiers.cloture)throw new IsClosedException("Compte Tiers est fermé.");
	
		this.numOp++;
		this.solde += montant;
		
		Operation op = new Operation(numOp, montant, 3, compteTiers);
		operation.add(op);
	}
	
	public void emettreVirement(double montant, CompteEnBanque compteTiers)throws IsClosedException, TooPoorException{
		if(this.cloture)throw new IsClosedException();
		if(montant <= 0)throw new IllegalArgumentException("Veuillez déposer un montant realiste.");
		if(compteTiers.cloture)throw new IsClosedException("Compte Tiers est fermé.");
		if(this.solde - montant < this.decouvertMaximum) throw new TooPoorException();
		
		this.numOp++;
		this.solde -= montant;
		
		Operation op = new Operation(numOp, montant, 2, compteTiers);
		operation.add(op);
	}
	
	public int nombreDOperations(){
		return operation.size();
	}
	
	public void cloturer(){
		this.cloture = true;
	}

	@Override
	public String toString() {
		return "CompteEnBanque [numero=" + numero + ", solde=" + solde + ", decouvertMaximum=" + decouvertMaximum
				+ ", cloture=" + cloture + ", nombreDOperations()=" + nombreDOperations() + "]";
	}
	
}