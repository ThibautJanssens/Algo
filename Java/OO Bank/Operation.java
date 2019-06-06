import java.time.LocalDateTime;

public class Operation {
	public static final String[] TYPEOP = {"Depot","Retrait","Virement Donneur","Virement Receveur"};
	
	private int numero;
	private LocalDateTime dateDeCreation;
	private double montant;
	private String type;
	private CompteEnBanque compteTiers;
	
	public Operation(int numero, double montant, int typeOp){
		this(numero, montant, typeOp, null);
	}

	public Operation(int numero, double montant, int typeOp, CompteEnBanque compteTiers){
		if (this.montant <= 0)throw new IllegalArgumentException("Montant non raisonable.");
		if (typeOp < 0 || typeOp > 3)throw new IllegalArgumentException("Le type d'operation n'est pas reconnu.");
		
		this.numero = numero;
		this.montant = montant;
		this.type = TYPEOP[typeOp];
		this.compteTiers = compteTiers;
		this.dateDeCreation = LocalDateTime.now();
	}

	public int getNumero() {
		return numero;
	}

	public LocalDateTime getDateDeCreation() {
		return dateDeCreation;
	}

	public double getMontant() {
		return montant;
	}

	public String getType() {
		return type;
	}

	public CompteEnBanque getCompteTiers() {
		return compteTiers;
	}

	@Override
	public String toString() {
		return "Operation [numero=" + numero + ", dateDeCreation=" + dateDeCreation + ", montant=" + montant + ", type="
				+ type + "]";
	}

}
