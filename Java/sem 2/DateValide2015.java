/**
 * 
 * @author Janssens Thibaut IPL - 21/09/15
 * @version 21/09/15
 *
 */
public class DateValide2015 {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.print("Entrez le jour : ");
		int jour = scanner.nextInt();
		System.out.print("Entrez le mois : ");
		int mois = scanner.nextInt();
		if(estValide(jour,mois))
			System.out.println("date valide");
		else
			System.out.println("date non valide");
	}
		
	public static boolean estValide(int jour, int mois){
		if (jour < 1)
			return false;
		
		switch (mois) {
		case 1:
			if (jour>31)
				return false;
			else
				return true;
		case 2:
			if(jour>28)
				return false;
			else
				return true;
		case 3:
			if (jour>31)
				return false;
			else
				return true;
		case 4:
			if (jour>30)
				return false;
			else
				return true;
		case 5:
			if (jour>31)
				return false;
			else
				return true;
		case 6:
			if (jour>30)
				return false;
			else
				return true;
		case 7:
			if (jour>31)
				return false;
			else
				return true;
		case 8:
			if (jour>31)
				return false;
			else
				return true;
		case 9:
			if (jour>30)
				return false;
			else
				return true;
		case 10:
			if (jour>31)
				return false;
			else
				return true;
		case 11:
			if (jour>30)
				return false;
			else
				return true;
		case 12:
			if (jour>31)
				return false;
			else
				return true;
		default:
			return false;
		}
	}
	
}
