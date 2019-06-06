/**
 * 
 * @author Janssens Thibaut IPL - 21/09/15
 * @version 21/09/15
 *
 */
public class C5 {
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	public static void main(String[] args) {
		
		int jourChiffre, moisChiffre;
		String jourLettre= "", moisLettre="";
		
		System.out.println("Entrez le jour la date en chiffre svp. \nJour:");
		jourChiffre = scanner.nextInt();
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
		
		switch (jourChiffre%7) {
		case 0:
			jourLettre = "Mardi";
			break;
		case 1:
			jourLettre = "Mercredi";
			break;
		case 2:
			jourLettre = "Jeudi";
			break;
		case 3:
			jourLettre = "Vendredi";
			break;
		case 4:
			jourLettre = "Samedi";
			break;
		case 5:
			jourLettre = "Dimanche";
			break;
		case 6:
			jourLettre = "Lundi";
			break;
		default:
			break;
		}
		
		System.out.println(jourLettre + " "+jourChiffre+" "+moisLettre+" 2014");
		
	}
}
