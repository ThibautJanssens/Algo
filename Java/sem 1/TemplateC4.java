/**
 * 
 * @author Janssens Thibaut
 *
 */
public class TemplateC4 {
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		
		int nombre1, nombre2, nombre3;
		
		System.out.println("Entrez un nombre.");
		nombre1 = scanner.nextInt();
		System.out.println("Entrez un deuxième nombre.");
		nombre2= scanner.nextInt();
		System.out.println("Entrez un troisième nombre.");
		nombre3= scanner.nextInt();
		
		if (nombre1 >= nombre2 && nombre1 > nombre3)
			System.out.println("Le plus grand nombre est "+ nombre1);
		else if (nombre2 >= nombre1 && nombre2 > nombre3)
			System.out.println("Le plus grand nombre est "+nombre2);
		else if (nombre1 >= nombre2 && nombre1 < nombre3)
			System.out.println("Le plus grand nombre est "+nombre3);
		else if (nombre2 >= nombre1 && nombre2 < nombre3)
			System.out.println("Le plus grand nombre est "+nombre3);
		else if (nombre1 == nombre2 && nombre2 == nombre3)
			System.out.println("Le plus grand nombre est "+nombre1);
	}	
}