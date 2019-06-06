/**
 * 
 * @author Janssens Thibaut - IPL - 20/10/2015
 *
 */
public class Jeu {
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	public static void main(String[] args) {
		Etat jeu = new Etat(3,16);
		System.out.println(jeu.toString());
		
		while(!jeu.estEtatFinal()){
			int lancerDe = Utilitaires.lancerDe();
			System.out.println("Le dé affiche: "+lancerDe);
			System.out.println("Choix d'un numero de case.");
			int numCase = scanner.nextInt();
			if(!jeu.estValide(numCase)){
				System.out.println("Vous n'avez pas jouer une case qui vous appartient.");
				System.out.println("Vous passez votre tour.");
				jeu.changerJoueur();
			}
			else{
				jeu.jouer(numCase, lancerDe);
				jeu.changerJoueur();
			}
			System.out.println(jeu.toString());
		}
		System.out.println("\nLe jeu est termine");
		System.out.println("Bravo au joueur "+jeu.joueurAdverse());
	}
}
