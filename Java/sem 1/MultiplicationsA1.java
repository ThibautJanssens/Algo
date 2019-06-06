/**
 * 
 * @author Janssens Thibaut
 *
 */
public class MultiplicationsA1{

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
	
		System.out.println("Entrainement aux multiplications. Voici un exercice :");
		
		int premierNombre, deuxiemeNombre, troisiemeNombre, reponseCorrecte, reponseEleve;

		premierNombre = unEntierAuHasardEntre (0, 10);
		deuxiemeNombre = unEntierAuHasardEntre (0, 10);
		troisiemeNombre = unEntierAuHasardEntre (0, 10);
		reponseCorrecte = premierNombre * deuxiemeNombre * troisiemeNombre;
		System.out.println("Calculez : " + premierNombre + " x " + deuxiemeNombre + " x " + troisiemeNombre + " = ");
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