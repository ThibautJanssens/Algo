/**
 * 
 * @author Janssens Thibaut IPL - 21/09/15
 * @version 21/09/15
 *
 */
public class MultiplicationsB2 {
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
	
		System.out.println("Entrainement aux multiplications. Voici un exercice :");
		
		int premierNombre, secondNombre, reponseCorrecte, reponseEleve;

		premierNombre = unEntierAuHasardEntre (0, 10);
		secondNombre = unEntierAuHasardEntre (0, 10);
		reponseCorrecte = premierNombre * secondNombre;
		System.out.println("Calculez : " + premierNombre + " x " + secondNombre + " = ");
		reponseEleve = scanner.nextInt(); 

		if (reponseEleve == reponseCorrecte) {
			System.out.println("Tres bien");
		} else {
			System.out.println("Non, 2 essais restants.");
			System.out.println("Calculez : " + premierNombre + " x " + secondNombre + " = ");
			reponseEleve = scanner.nextInt(); 
			
			if (reponseEleve == reponseCorrecte)
				System.out.println("Bien");
			else{
				System.out.println("Non, 1 essai restant.");
				System.out.println("Calculez : " + premierNombre + " x " + secondNombre + " = ");
				reponseEleve = scanner.nextInt(); 

				if (reponseEleve == reponseCorrecte)
					System.out.println("Correcte");
				else
					System.out.println("Non, la réponse était: "+reponseCorrecte);
			}
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