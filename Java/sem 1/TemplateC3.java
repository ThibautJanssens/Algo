/**
 * 
 * @author Janssens Thibaut
 *
 */
public class TemplateC3 {
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		
		int nombre1, nombre2;
		
		System.out.println("Entrez un nombre.");
		nombre1 = scanner.nextInt();
		System.out.println("Entrez un deuxième nombre.");
		nombre2= scanner.nextInt();
		if (nombre1 > nombre2)
			System.out.println("Le plus grand est "+ nombre1);
		if (nombre2 > nombre1)
			System.out.println("Le plus grand est "+nombre2);
		else
			System.out.println("Le plus grand nombre est "+nombre1);
	}

}