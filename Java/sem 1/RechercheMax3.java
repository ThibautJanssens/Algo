/**
 * 
 * @author Janssens Thibaut
 *
 */
public class RechercheMax3{

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	
	public static void main(String[] args) {
		System.out.println("Entrez l'entier 1 : ");	
		int entier1 = scanner.nextInt();	
		System.out.println("Entrez l'entier 2 : ");	
		int entier2 = scanner.nextInt();
		System.out.println("Entrez l'entier 3 : ");	
		int entier3 = scanner.nextInt();
		int max = max3(entier1,entier2,entier3);
		System.out.println("Le plus grand est : " + max);
	}

	/**
	 * recherche le max 
	 * @param nombre1
	 * @param nombre2
 	 * @param nombre3
	 * @return le max
	*/
	public static int max3(int nombre1, int nombre2, int nombre3){
		if (nombre1 > nombre2 && nombre1 > nombre3)
			return nombre1;
		if (nombre1 < nombre2 && nombre2 > nombre3)
			return nombre2;
		else
			return nombre3;
		
	}	
}
