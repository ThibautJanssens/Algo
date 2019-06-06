/**
 * 
 * @author Janssens Thibaut - IPL - 13 octobre 2015
 *
 */
public class D1 {
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	
	private static int[] nbreJetons = new int[2];	// 0 = blanc	1 = noir  
	private static int[] plateau = new int[16];   // 0 = blanc    1 = noir   -1 = vide
	private static int joueur;		// 0 = blanc      1 = noir
	private static final String[] COULEURS = {"blanc","noir"};
	
	public static void main(String[] args) {
		int nombreJetons = 3, choix, caseAction;
		
		for (int i = 0; i < nbreJetons.length;i++){
			nbreJetons[i] = nombreJetons;
		}
		
		for (int i = 0; i < nombreJetons*2; i++){
			if (i%2 == 0)
				plateau[i] = 0;
			else
				plateau[i] = 1;
		}
		
		for (int i = 6;i < plateau.length;i++){
			plateau[i] = -1;
		}
		
		while(!estTermine()){
			int de = lancerDe();
			System.out.println("Le joueur "+joueur()+" a lancé le dé et obtient "+de);
			System.out.println("Quel case voulez vous jouez? (case de 0 à 15)");
			afficher(plateau);
			choix = scanner.nextInt();
			if (choix+de > plateau.length-1)
				caseAction = plateau.length-1;
			else
				caseAction = choix+de;
			
			if (joueur() == "blanc" && plateau[choix] == 0){
				plateau[choix]=-1;
				if(plateau[caseAction] == 1){
					System.out.println("Joli coup, vous venez de manger un pion ennemi.");
					nbreJetons[1] --;
				}
				if (plateau[caseAction] == 0) {
					System.out.println("Vous venez de manger un de vos pions...");
					nbreJetons[0] --;
				}
				plateau[caseAction] = 0;
				passerTour();
			}
			if(joueur() == "noir" && plateau[choix] == 1){
				plateau[choix]=-1;
				if(plateau[caseAction] == 0){
					System.out.println("Joli coup, vous venez de manger un pion ennemi.");
					nbreJetons[0] --;
				}
				if(plateau[caseAction] == 1){
					System.out.println("Vous venez de manger un de vos pions...");
					nbreJetons[1] --;
				}
				plateau[caseAction] = 1;
				passerTour();
			}	
			else{
				if(joueur() == "blanc" && plateau[choix] == 1){
					System.out.println("Vous avez tenté de jouer une case qui n'est pas la votre. Passez votre tour.");
					passerTour();
				}
				else if(joueur() == "noir" && plateau[choix] == 0){
					System.out.println("Vous avez tenté de jouer une case qui n'est pas la votre. Passez votre tour.");
					passerTour();
				}
				else if (joueur() == "blanc" && plateau[choix] == -1){
					System.out.println("Vous avez tenté de jouer une case vide. Passez votre tour.");
					passerTour();
				}
				else if (joueur() == "noirc" && plateau[choix] == -1){
					System.out.println("Vous avez tenté de jouer une case vide. Passez votre tour.");
					passerTour();
				}
			}
			
		}
		if (nbreJetons[0] == 0){
			System.out.println("Les blancs n'ont plus de pions. Les noirs gagnent.");
		}
		if (nbreJetons[1] == 0){
			System.out.println("Les noirs n'ont plus de pions. Les blancs gagnent.");
		}
		if (plateau[plateau.length-1] == 0){
			System.out.println("Un des pions blanc est arrivé au bout du plateau. Les blancs gagnent.");
		}
		if (plateau[plateau.length-1] == 1){
			System.out.println("Un des pions noir est arrivé au bout du plateau. Les noirs gagnent.");
		}
	}
	
	public static String joueur(){
		return COULEURS[joueur];
	}
	
	public static void passerTour(){
		joueur = (joueur+1)%2;
	}
	
	public static boolean estTermine(){
		if(nbreJetons[joueur] == 0 )
			return true;
		if(plateau[plateau.length-1]!=-1)
			return true;
		return false;
	}
	
	public static int lancerDe() {
		double reel;
		int resultat;
		reel = Math.random();
		resultat = (int) (reel * (6)) + 1;
		return resultat;
	}
	
	public static void afficher(int[] table){
		for (int i = 0; i < table.length; i++) {
			System.out.print(" "+table[i]);
		}
		
	}
}
