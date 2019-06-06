/**
 * 
 * @author Janssens Thibaut IPL 28/09/15
 *
 */
public class B6 {
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	public static void main(String[] args) {
		String nom, nomVainqueur;
		double resultat, resultatVainqueur;
		
		System.out.println("Veuillez entrer le nom du participant.");
		nomVainqueur = scanner.next();
		System.out.println("Veuillez entrer son résultat (/100).");
		resultatVainqueur = scanner.nextDouble();
		
		for (int i = 0; i < 9; i++){
			System.out.println("Veuillez entrer le nom du participant.");
			nom = scanner.next();
			System.out.println("Veuillez entrer son résultat (/100).");
			resultat = scanner.nextDouble();
			
			if (resultat > resultatVainqueur){
				resultatVainqueur = resultat;
				nomVainqueur = nom;
			}
		}
		System.out.println("Le vainqueur est "+nomVainqueur+" avec un score de "+resultatVainqueur+"/100.");
	}
}
