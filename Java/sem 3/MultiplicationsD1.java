/**
 * 
 * @author Janssens Thibaut IPL 28/09/15
 *
 */
public class MultiplicationsD1 {
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
	
	
		System.out.println("Entrainement aux multiplications. Voici 5 exercices :");	
		for (int compteur = 0; compteur < 5; compteur++) {
			faireUneMultiplication();
			
		}
	}

	

	public static void faireUneMultiplication(){
		
		int premierNombre, secondNombre, reponseCorrecte, reponseEleve, valeurMax;
		System.out.println("Choississez la valeur maximale des nombres à multiplier.");
		valeurMax = scanner.nextInt();
		
		System.out.println ("Voici un exercice :");
		premierNombre   = unEntierAuHasardEntre (0, valeurMax);
		secondNombre    = unEntierAuHasardEntre (0, valeurMax);
		reponseCorrecte = premierNombre * secondNombre;
		System.out.println ("Calcule: " + premierNombre + "x" + secondNombre + "=");
		reponseEleve = scanner.nextInt(); 

		if (reponseEleve == reponseCorrecte) {
			System.out.println("Tres bien");
		} else {
			System.out.println("Non, c'etait : " + reponseCorrecte);
		}

	}

	public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
		double nombreReel;
		int resultat;

		nombreReel = Math.random();
		resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1))
								+ valeurMinimale;
		return resultat;
	}
}
