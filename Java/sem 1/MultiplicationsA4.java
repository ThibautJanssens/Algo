/**
 * 
 * @author Janssens Thibaut
 *
 */
public class MultiplicationsA4{

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
	
		System.out.println("Entrainement aux multiplications. Voici un exercice :");
		
		int premierNombre, secondNombre, min1, min2, max1, max2, temp, reponseCorrecte, reponseEleve;

		System.out.println("Choisis la valeur minimale du premier nombre");
		min1 = scanner.nextInt();
		System.out.println("Choisis la valeur maximale du premier nombre");
		max1 = scanner.nextInt();
		
		if (min1 > max1){
			temp = min1;
			min1 = max1;
			max1 = temp;
		}
		
		System.out.println("Choisis la valeur minimale du second nombre");
		min2 = scanner.nextInt();
		System.out.println("Choisis la valeur maximale du second nombre");
		max2 = scanner.nextInt();

		if (min2 > max2 ){
			temp = min2;
			min2 = max2;
			max2 = temp;
		}
		
		premierNombre = unEntierAuHasardEntre (min1, max1);
		secondNombre = unEntierAuHasardEntre (min2, max2);
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