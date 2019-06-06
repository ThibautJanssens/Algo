/**
 * 
 * @author Janssens Thibaut IPL 
 * @version 29/09/15
 *
 */
public class B7 {
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	public static void main(String[] args) {
		String nomTemp,nomVainqueur;
		int[] dateNaissanceTemp, dateNaissanceVainqueur;
		
		System.out.println("Veuillez entrer le nom du participant.");
		nomTemp = scanner.next();
		nomVainqueur = nomTemp;
		
		System.out.println("Veuillez entrer sa date de naissance.(JJ/MM/AA)");
		dateNaissanceTemp = lireJJMMAA();
		dateNaissanceVainqueur=dateNaissanceTemp;
		
		for(int i = 0; i<9;i++){
			System.out.println("Veuillez entrer le nom du participant.");
			nomTemp = scanner.next();
			System.out.println("Veuillez entrer sa date de naissance. (JJ/MM/AA)");
			dateNaissanceTemp = lireJJMMAA();
			
			if (compareDate(dateNaissanceTemp[0],dateNaissanceTemp[1], dateNaissanceTemp[2],dateNaissanceVainqueur[0],dateNaissanceVainqueur[1],dateNaissanceVainqueur[2])==1){
				dateNaissanceVainqueur = dateNaissanceTemp;
				nomVainqueur = nomTemp;
			}
		}
		System.out.println("Le participant le plus jeune est "+nomVainqueur+" (né le "+dateNaissanceVainqueur[0]+"/"+dateNaissanceVainqueur[1]+"/"+dateNaissanceVainqueur[2]+").");
	}
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
}