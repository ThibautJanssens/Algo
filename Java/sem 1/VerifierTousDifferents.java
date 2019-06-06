/**
 * 
 * @author Janssens Thibaut 
 *
 */
public class VerifierTousDifferents{

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	
	public static void main(String[] args) {
		System.out.println("Entrez l'entier 1 : ");	
		int entier1 = scanner.nextInt();	
		System.out.println("Entrez l'entier 2 : ");	
		int entier2 = scanner.nextInt();
		System.out.println("Entrez l'entier 3 : ");	
		int entier3 = scanner.nextInt();
		if(sontTousDifferents(entier1,entier2,entier3))
			System.out.println("Les entiers sont tous différents");
			else System.out.println("Les entiers ne sont pas tous différents");
	}

	/**
	 * vérifie si les trois nombres sont tous différents
	 * @param nombre1
	 * @param nombre2
	 * @param nombre3
	 * @return true si nombre1 <> nombre2 <> nombre3, false sinon
	*/
	public static boolean sontTousDifferents(int nombre1, int nombre2, int nombre3){
		return (nombre1 != nombre2) && (nombre2 !=nombre3) && (nombre1 != nombre3);
	}
	
	
}
