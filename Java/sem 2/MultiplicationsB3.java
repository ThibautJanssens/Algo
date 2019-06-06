/**
 * 
 * @author Janssens Thibaut IPL - 21/09/15
 * @version 21/09/15
 *
 */
public class MultiplicationsB3 {
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
	
		System.out.println("Entrainement aux multiplications. Voici un exercice :");
		
		int premierNombre, deuxiemeNombre,troisiemeNombre, reponseCorrecte, reponseIntermediaire, reponseEleve;

		premierNombre = unEntierAuHasardEntre (0, 10);
		deuxiemeNombre = unEntierAuHasardEntre (0, 10);
		troisiemeNombre = unEntierAuHasardEntre (0,10);
		reponseCorrecte = premierNombre * deuxiemeNombre * troisiemeNombre;
		reponseIntermediaire = premierNombre * deuxiemeNombre;
		System.out.println("Calculez : " + premierNombre + " x " + deuxiemeNombre+" x "+troisiemeNombre + " = ");
		reponseEleve = scanner.nextInt(); 

		if (reponseEleve == reponseCorrecte)
			System.out.println("Tres bien");
		else {
			System.out.println("Non. Commence par calculer ceci: " +premierNombre +" x "+ deuxiemeNombre);
			reponseEleve = scanner.nextInt(); 
			if (reponseEleve == reponseIntermediaire){
				System.out.println("Ok. Maintenant il reste à faire "+reponseIntermediaire+" x "+troisiemeNombre+" = ");
				reponseEleve = scanner.nextInt(); 
				if (reponseEleve == reponseCorrecte) 
					System.out.println("Tu vois, ce n'était pas si difficile: "+premierNombre+" x "+deuxiemeNombre+" x "+troisiemeNombre+" = "+reponseCorrecte);
				else
					System.out.println("Non, c'était "+reponseCorrecte);
			}else{
				System.out.println("Non, c'était : "+reponseIntermediaire);
				System.out.println("Maintenant il reste à faire "+reponseIntermediaire+" x "+troisiemeNombre+" = ");reponseEleve = scanner.nextInt(); 
				if (reponseEleve == reponseCorrecte) 
					System.out.println("Tu vois, ce n'était pas si difficile: "+premierNombre+" x "+deuxiemeNombre+" x "+troisiemeNombre+" = "+reponseCorrecte);
				else
					System.out.println("Non, c'était "+reponseCorrecte);
			}
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