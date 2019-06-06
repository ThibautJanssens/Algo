/**
 * 
 * @author JANSSENS Thibaut - IPL - 17/11/15
 *
 **/
public class Client {
	private String nom;
	private String prenom;
	private double[] tableMontants = new double[10];
	private int nombreMontants = 0;
	
	public Client(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public boolean ajouter (double montant){
		if (nombreMontants == 0){
			tableMontants[0] = montant;
			nombreMontants ++;
			return true;
		}
		if (nombreMontants == tableMontants.length && montant < tableMontants[0])
			return false;

		if (nombreMontants == tableMontants.length && montant > tableMontants[nombreMontants-1]){
			for (int k = 0; k < nombreMontants-1; k++){
				tableMontants[k] = tableMontants[k+1];
			}
			tableMontants[nombreMontants-1] = montant;
			return true;
		}
		
		if (nombreMontants < tableMontants.length){
			nombreMontants ++;
			for(int m = 0; m < nombreMontants-1; m++){
				if (tableMontants[m] < montant && tableMontants[m+1] > montant){
					for (int n = nombreMontants-1; n > m; n--){
						tableMontants[n] = tableMontants[n-1];
					}
					tableMontants[m+1] = montant;
					return true;
				}
				else if (tableMontants[m] < montant && tableMontants[m+1] == 0){
					tableMontants[m+1] = montant;
					return true;
				}
				else if (tableMontants[m] > montant){
					for (int n = nombreMontants-1; n > m; n--){
						tableMontants[n] = tableMontants[n-1];
					}
					tableMontants[m] = montant;
					return true;
				}
			}
			return true;
		}

		else{
			for(int i=0;i<tableMontants.length-1;i++){
				if (montant > tableMontants[i] && montant < tableMontants[i+1]){
					for(int j=0;j<i;j++){
						tableMontants[j] = tableMontants[j+1];
						tableMontants[i] = montant;
					}
				}
			}
			return true;
		}
	}

	
	@Override
	public String toString() {
		String aRenvoyer = "" + nom + " " + prenom + "  montants : ";
		for (int i = 0; i < nombreMontants; i++) {
			aRenvoyer += " "+tableMontants[i];
		}
		return aRenvoyer;
	}
	
	
	
	
	
	
	
}
