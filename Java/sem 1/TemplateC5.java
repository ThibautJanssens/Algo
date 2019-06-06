/**
 * 
 * @author Janssens Thibaut
 *
 */
public class TemplateC5 {
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	
	public static void main(String[] args) {
	
		double prixHorsTva, tva, prixAvecTva;
		
		System.out.println("Veuillez entrez votre prix hors Tva.");
		prixHorsTva = scanner.nextDouble();
		tva = prixHorsTva * 21 / 100;
		prixAvecTva = prixHorsTva + tva;
		System.out.println("Le prix avec tva vaut: "+prixAvecTva+"€");
	}

}