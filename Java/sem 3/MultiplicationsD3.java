/**
 * 
 * @author Janssens Thibaut IPL 28/09/15
 *
 */
public class MultiplicationsD3{

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
	
		int score, points;
		double pourcentage;
		score = 0;
		System.out.println("Entrainement aux multiplications.");	
		System.out.println("Combien de multiplication voulez-vous faire?");
		int choix = scanner.nextInt();
		while (choix <= 0){
			System.out.println("Veuillez choisir un nombre supérieur à 0.");
			choix = scanner.nextInt();
		}
		for (int compteur = 0; compteur < choix; compteur++) {
			points = resultatUneMultiplication();
			score = score + points;
		}
		pourcentage = ((double)score / choix) * 100;
		System.out.println("Voici ton score : " + score+" ("+pourcentage+"%)");
	}

	

	public static int resultatUneMultiplication(){
		
		int premierNombre, secondNombre, reponseCorrecte, reponseEleve;

		System.out.println ("Voici un exercice :");
		premierNombre   = unEntierAuHasardEntre (0, 10);
		secondNombre    = unEntierAuHasardEntre (0, 10);
		reponseCorrecte = premierNombre * secondNombre;
		System.out.println ("Calcule: " + premierNombre + "x" + secondNombre + "=");
		reponseEleve = scanner.nextInt(); 

		if (reponseEleve == reponseCorrecte) {
			System.out.println("Tres bien");
			return 1;
		} else {
			System.out.println("Non, c'etait : " + reponseCorrecte);
			return 0;
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