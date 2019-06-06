
/**
 * Championnat.java
 * @author Annick Dupont IPL / Thibaut Janssens IPL
 * @version 29/09/08		 /   29/09/15
 *
 */
public class Championnat {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	
	public static void main(String[] args) {
		int nombreFinaliste = 0, nombreConcurrent;
		
		System.out.println("Veuillez entrer le nombre de concurrent au concours.");
		nombreConcurrent = scanner.nextInt();
		for (int i =0; i < nombreConcurrent;i++){
		System.out.println("Concurrent n° "+(i+1));
		double moyenneCandidat = resultatUnConcurrent();
		if (moyenneCandidat >= 8)
				nombreFinaliste += 1;
		}
		System.out.println("Le nombre de finaliste est de "+nombreFinaliste);
	}

	/**
	 * lit les cotes, calcule et renvoie le resultat d'un concurrent
	 * @return le resultat du concurrent
	*/
	public static double resultatUnConcurrent() {
		double coteLaPlusHaute = 0, coteLaPlusBasse = 20, moyenne = 0;
		

		for(int i = 0 ; i < 8; i++){
			System.out.println("Entrez la cote du concurrent.(/10)");
			double cote = scanner.nextInt();
			moyenne += cote;
			
			if (coteLaPlusHaute < cote){
				coteLaPlusHaute = cote;
			}
			else
				if (coteLaPlusBasse > cote)
					coteLaPlusBasse = cote;
		}
		moyenne = moyenne - coteLaPlusBasse - coteLaPlusHaute;
		moyenne = moyenne / 6;
		System.out.println("Moyenne candidat: "+ moyenne);
		
		return moyenne;
	}
}
