/**
 * 
 * @author Janssens Thibaut IPL 28/09/15
 *
 */
public class B3 {
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	public static void main(String[] args) {
		
		double plusPetiteCote, plusGrandeCote, cote, moyenne;
		
		System.out.println("Entrez la cote de l'�l�ve (/20).");
		cote = scanner.nextDouble();
		moyenne = cote;
		plusGrandeCote = cote;
		plusPetiteCote = cote;
		
		for (int i = 0; i<4; i++){
			System.out.println("Entrez la cote de l'�l�ve (/20).");
			cote = scanner.nextDouble();
			moyenne += cote;
			
			if(cote>plusGrandeCote)
				plusGrandeCote = cote;
			
			if(cote<plusPetiteCote)
				plusPetiteCote = cote;
		}
		
		moyenne = moyenne / 5;
		
		System.out.println("La plus grande cote de l'�l�ve est: "+plusGrandeCote+"/20.");
		System.out.println("La plus petite cote de l'�l�ve est: "+plusPetiteCote+"/20.");
		System.out.println("Sa moyenne est de "+moyenne+"/20.");
	}
}
