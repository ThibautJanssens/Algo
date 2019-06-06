/**
 * 
 * @author Janssens Thibaut - IPL 6/10/15
 *
 */
public class B1 {
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	public static void main(String[] args) {
		char continuer = 'o';
		double moyenne;
		int compteur = 1, entier, entierPlusEleve = 0, entierPlusBas, sommeEntier;
		
		System.out.println("Entrez un entier.");
		entier = scanner.nextInt();
		sommeEntier = entier;
		entierPlusBas = entier;
		entierPlusEleve = entier;
		System.out.println("Voulez-vous entrez d'autres entiers. O pour continuer.");
		continuer = scanner.next().charAt(0);
		
		while (continuer == 'O' || continuer == 'o'){
			compteur ++;
			System.out.println("Entrez un entier.");
			entier = scanner.nextInt();
			sommeEntier += entier;
			
			if (entierPlusEleve < entier)
				entierPlusEleve = entier;
			if (entierPlusBas > entier)
				entierPlusBas = entier;	
			System.out.println("Voulez-vous entrez d'autres entiers. O pour continuer.");
			continuer = scanner.next().charAt(0);
		}
		moyenne = (double)(sommeEntier/compteur);
		System.out.println("Votre entier le plus grand est :"+entierPlusEleve);
		System.out.println("Votre entier le plus petit est :"+entierPlusBas);
		System.out.println("Votre moyenne est de :"+moyenne);
	}
}
