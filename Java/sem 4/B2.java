/**
 * 
 * @author Janssens Thibaut - IPL 6/10/15
 *
 */
public class B2 {
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		int pointsDeVieCognedur = 25, pointsDeVieFrappefort = 25, degats;
		
		System.out.println("Bienvenue au combat entre Cognedur et Frappefort.");
		
		while(pointsDeVieCognedur > 0 && pointsDeVieFrappefort > 0){
			degats = unEntierAuHasardEntre(1,6);
			System.out.println("Cognedur inflige "+degats+" points de dégât à Frappefort.");
			pointsDeVieFrappefort -= degats; 
			System.out.println("Il reste "+pointsDeVieFrappefort+" points de vie à Frappefort.");
			if (pointsDeVieFrappefort > 0){
				degats = unEntierAuHasardEntre(1, 6);
				System.out.println("Frappefort inflige "+degats+" points de dégât à Cognedur.");
				pointsDeVieCognedur -= degats;
				System.out.println("Il reste "+pointsDeVieCognedur+" points de vie à Cognedur.");
			}
		}
		if(pointsDeVieCognedur <= 0)
			System.out.println("CogneDur est mort. Paix à son âme, il est mort en brave.");
		else
			System.out.println("Frappefort est mort. Paix à son âme, il est mort en brave.");	
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
