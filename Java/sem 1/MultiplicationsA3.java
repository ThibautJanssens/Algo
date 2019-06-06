/**
 * 
 * @author Janssens Thibaut
 *
 */
public class MultiplicationsA3{

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
	
		System.out.println("Entrainement aux multiplications. Voici un exercice :");
		
		int premierNombre, secondNombre, max1, max2, reponseCorrecte, reponseEleve;

		System.out.println("Choisis la valeur maximale du premier nombre");
		max1 = scanner.nextInt();
		System.out.println("Choisis la valeur maximale du second nombre");
		max2 = scanner.nextInt();
		premierNombre = unEntierAuHasardEntre (0, max1);
		secondNombre = unEntierAuHasardEntre (0, max2);
		reponseCorrecte = premierNombre * secondNombre;
		System.out.println("Calculez : " + premierNombre + " x " + secondNombre + " = ");
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