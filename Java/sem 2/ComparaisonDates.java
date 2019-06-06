import java.util.Scanner;

/**
 * 
 * @author Gregory Seront  / Janssens Thibaut IPL - 21/09/15
 * @version 21/09/15
 *
 */

public class ComparaisonDates {
	public static Scanner scanner = new Scanner(System.in);

	/**
	 * 
	 * @param jourDate1
	 * @param moisDate1
	 * @param anneeDate1
	 * @param jourDate2
	 * @param moisDate2
	 * @param anneeDate2
	 * @return un nombre negatif si la premiere date est anterieure a
	 *         la deuxieme date, un nombre positif si la premiere est 
	 *         posterieure a la deuxieme et 0 si elles sont egales.
	 */
	public static int compareDate(int jourDate1, int moisDate1, int anneeDate1,
								  int jourDate2, int moisDate2, int anneeDate2) {
		if (anneeDate1 < anneeDate2)
			return -1;
		if (anneeDate1 > anneeDate2)
			return 1;
		else{
			if (moisDate1 < moisDate2)
				return -1;
			if (moisDate1 > moisDate2)
				return 1;
			else{
				if(jourDate1 < jourDate2)
					return -1;
				if(jourDate1 > jourDate2)
					return 1;
				else
					return 0;
			}
		}
	}



	public static int[] lireJJMMAA(){

		
		String date1 = scanner.next();
		String [] JJMMAA1 = date1.split("/");
		if (JJMMAA1.length != 3){
			System.out.println("Vous n'avez pas utilisé le bon format!");
			System.exit(1);
		}
		
		int [] tableauDate = new int[3];
		for (int i=0; i<3; i++)
			tableauDate[i] = Integer.parseInt(JJMMAA1[i]);
		
		return tableauDate;
	}
	
	public static void main(String[] args) {
		
		System.out.println("Tests de la methode compareDate");
		System.out.println("Entrez la date1 sous le format JJ/MM/AA");
		int [] date1 = lireJJMMAA();
		
		System.out.println("Entrez la date2 sous le format JJ/MM/AA");
		int [] date2 = lireJJMMAA();
		
		int comparaison = compareDate(date1[0], date1[1], date1[2], 
				date2[0], date2[1], date2[2]);
		
		if (comparaison == 0)
			System.out.println("Les deux dates sont égales");
		
		if (comparaison>0)
			System.out.println("La premiere date est  posterieure a la deuxieme ");
		
		if (comparaison<0)
			System.out.println("La premiere date est  antérieure a la deuxieme ");
		
	}	
}
