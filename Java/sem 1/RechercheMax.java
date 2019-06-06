/**
 * 
 * @author Janssens Thibaut
 *
 */
public class RechercheMax {
	
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
	 * recherche le max entre 2 nombres
	 * @param nombre1
	 * @param nombre2
	 * @return le max
	*/
	public static int max2(int nombre1, int nombre2){
		if(nombre1 > nombre2){ 
			return nombre1;
		} else {
			return nombre2;
		}
	}
	
	/**
	 * recherche le max entre 3 nombres
	 * @param nombre1
	 * @param nombre2
 	 * @param nombre3
	 * @return le max
	*/
	public static int max3(int nombre1, int nombre2, int nombre3){
		return max2(max2(nombre1,nombre2),nombre3);
		// UTILISEZ max2
		// N'UTILISEZ PAS DE IF!
		// CETTE METHODE S'ECRIT EN UNE LIGNE!
	}	
}
