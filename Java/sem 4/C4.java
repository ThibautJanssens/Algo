/**
 * 
 * @author Janssens Thibaut - IPL 6/10/15
 *
 */
public class C4 {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);	
	
	public static void main(String[] args) {
		System.out.println("Nombre Mystere");
		System.out.println("La réponse a été trouvée après " + nombreMystere() + " essais.");
	}
		
	public static int nombreMystere() {
		int borneMax = 100, borneMin = 0, nombre, compteur = 0;
		char reponse = ' ';
		
		System.out.println("Pensez à un nombre entre 0 à 100.");
		while (reponse != '='){
			compteur ++;
			nombre = unEntierAuHasardEntre(borneMin, borneMax);
			System.out.println("Est-ce "+nombre+"?");
			reponse = lireCharPlusMoinsEgal();
			
			if (reponse == '+'){
				borneMin = nombre+1;
			}
			if (reponse == '-')
				borneMax = nombre-1;
		}
		return compteur;
	}
	
	
	public static char lireCharPlusMoinsEgal(){
		char reponse = ' ';
		
		while (reponse != '+' || reponse != '-' || reponse != '='){
			System.out.println("Plus, moins ou égal? (+/-/=)");
			reponse = scanner.next().charAt(0);
			if(reponse == '+' || reponse == '-' || reponse == '=')
				return reponse;
		}
		return reponse;
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
