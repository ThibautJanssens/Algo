/**
 * 
 * @author Janssens Thibaut IPL - 21/09/15
 * @version 21/09/15
 *
 */
public class C3 {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	public static void main(String[] args) {
		int jour, moisChiffre;
		String moisLettre="";
		
		System.out.println("Entrez le jour et le mois en chiffre svp. \nJour:");
		jour = scanner.nextInt();
		System.out.println("Mois:");
		moisChiffre = scanner.nextInt();
		
		switch (moisChiffre) {
		case 1:
			moisLettre = "Janvier";
			break;
		case 2:
			moisLettre = "Février";
			break;
		case 3:
			moisLettre = "Mars";
			break;
		case 4:
			moisLettre = "Avril";
			break;
		case 5:
			moisLettre = "Mai";
			break;
		case 6:
			moisLettre = "Juin";
			break;
		case 7:
			moisLettre = "Juillet";
			break;
		case 8:
			moisLettre = "Aout";
			break;
		case 9:
			moisLettre = "Septembre";
			break;
		case 10:
			moisLettre = "Octobre";
			break;
		case 11:
			moisLettre = "Novembre";
			break;
		case 12:
			moisLettre = "Decembre";
			break;
		default:
			break;
		}
		
		System.out.println(jour+" "+moisLettre);
	}
}
