/**
 * 
 * @author Janssens Thibaut IPL - 21/09/15
 * @version 21/09/15
 *
 */
public class AfficheSaison{

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.print("Entrez le jour : ");
		int jour = scanner.nextInt();
		System.out.print("Entrez le mois : ");
		int mois = scanner.nextInt();
		String saisonAAfficher = saison(jour,mois);
		System.out.println("saison : "+saisonAAfficher);
	}
		
	public static String saison(int jour, int mois){
		if (mois == 3 && jour >= 21)
			return "Printemps";
		if (mois > 3 && mois < 6)
			return "Printemps";
		if (mois == 6 && jour <= 20)
			return"Printemps";
		if (mois == 6 && jour >= 21)
			return "Eté";
		if (mois > 6 && mois < 9)
			return "Eté";
		if (mois == 9 && jour <= 20)
			return "Eté";
		if (mois == 9 && jour >= 21)
			return "Automne";
		if (mois > 9 && mois < 12)
			return "Automne";
		if (mois == 12 && jour <= 20)
			return "Automne";
		else
			return "Hiver";
	}
}