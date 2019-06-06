
/**
 * Championnat.java
 * @author Annick Dupont IPL / Janssens Thibaut IPL
 * @version 3/10/11  /          28/09/15
 *
 */
public class Deliberation {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	
	public static void main(String[] args) {
		double moyenneEtudiant, moyenneClasse = 0;
		for (int i=0; i < 25;i++){
			moyenneEtudiant = moyenneUnEtudiant();
			moyenneClasse += moyenneEtudiant;
		}
		moyenneClasse = moyenneClasse / 25;
		System.out.println("La moyenne de la classe est de "+moyenneClasse+"/20.");
	}

	/**
	 * lit les cotes, calcule et renvoie la moyenne d'un étudiant
	 * @return le resultat du concurrent
	*/
	public static double moyenneUnEtudiant() {
		double moyenneEtudiant = 0, cote;
		for (int i=0; i<10; i++){
			System.out.println("Entrez la cote n°"+(i+1)+" de l'etudiant (/20).");
			cote = scanner.nextDouble();
			moyenneEtudiant += cote;
		}
		moyenneEtudiant = moyenneEtudiant / 10;
		System.out.println("La moyenne de cet étudiant est de "+moyenneEtudiant+".\n");
		
		return moyenneEtudiant;
	}

}
