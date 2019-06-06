/**
 * 
 * @author Janssens Thibaut
 *
 */
public class TemplateC6 {
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		double taille;
		int poids, bmi;
	
		System.out.println("Veuillez entrer votre taille en m.");
		taille = scanner.nextDouble();
	
		System.out.println("Veuillez entre votre poids en kg.");
		poids = scanner.nextInt();
	
		bmi = poids / (int)Math.pow(2,taille);
	
		if (bmi < 20)
			System.out.println("Vous êtes mince.");
		else {	
			if (bmi <= 25)
				System.out.println("Vous êtes normal");
			else{ 
				if (bmi <= 30)
					System.out.println("Vous êtes embonpoint.");
				else
					System.out.println("Vous êtes obèse.");
			}
		}
	}
}