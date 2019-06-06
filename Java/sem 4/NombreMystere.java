/**
 * 
 * @author Janssens Thibaut - IPL 6/10/15
 *
 */
public class NombreMystere {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Ne modifiez pas le main
		System.out.println("Nombre Mystere");
		System.out.println("Vous avez mis " + nombreMystere() + " essais pour decouvrir le nombre");

	}

	
	/**
	 * Demande a l'utilisateur de trouver un nombre entre 0 et 100
	 * @return Le nombre d'essais qu'il a fallu pour trouver le nombre
	 */
	public static int nombreMystere() {
		int compteur = 1, nombreMystere, nombreUtilisateur=-2;
		
		nombreMystere = unEntierAuHasardEntre(0, 100);
			
		while (nombreUtilisateur != nombreMystere){
			System.out.println("Entrer votre nombre.");
			nombreUtilisateur = scanner.nextInt();		
			
			if (nombreUtilisateur > nombreMystere){
			System.out.println("Non, le nombre mystère est plus petit.");
			compteur ++;
			}else
				if (nombreMystere > nombreUtilisateur){
					System.out.println("Non, le nombre mystère est plus grand.");
					compteur ++;
				}
		}
			return compteur;
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
