/**
 * 
 * @author Janssens Thibaut IPL - 21/09/15
 * @version 21/09/15
 *
 */
public class MultiplicationsB1 {
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
	
		System.out.println("Entrainement aux multiplications. Voici un exercice :");
		
		int premierNombre, secondNombre, reponseCorrecte, reponseEleve;

		premierNombre = unEntierAuHasardEntre (5, 10);
		secondNombre = unEntierAuHasardEntre (11, 19);
		reponseCorrecte = premierNombre * secondNombre;
		System.out.println("Calculez : " + premierNombre + " x " + secondNombre + " = ");
		reponseEleve = scanner.nextInt(); 

		if (reponseEleve == reponseCorrecte) {
			System.out.println("Tres bien");
		} else {
			System.out.println("Non, c'etait : " + reponseCorrecte);
			premierNombre = unEntierAuHasardEntre(1,6);
			secondNombre = unEntierAuHasardEntre(3,10);
			reponseCorrecte = premierNombre * secondNombre;
			System.out.println("Calculez : "+ premierNombre + " x "+ secondNombre + " = ");
			reponseEleve = scanner.nextInt();
			
			if (reponseEleve == reponseCorrecte)
				System.out.println("Très bien.");
			else
				System.out.println("Non, c'était : "+reponseCorrecte);
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