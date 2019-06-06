/**
 * 
 * @author Janssens Thibaut IPL 28/09/15
 *
 */
public class B4 {
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	public static void main(String[] args) {
		
		double deuxiemePlusGrandeCote, plusGrandeCote, cote;
		
		System.out.println("Entrez la cote de l'élève (/20).");
		cote = scanner.nextDouble();
		deuxiemePlusGrandeCote = 0;
		plusGrandeCote = cote;
		
		for (int i = 0; i<7; i++){
			System.out.println("Entrez la cote de l'élève (/20).");
			cote = scanner.nextDouble();
			
			if(cote > plusGrandeCote){
				deuxiemePlusGrandeCote = plusGrandeCote;
				plusGrandeCote = cote;
			}
			else
				if (cote > deuxiemePlusGrandeCote)
					deuxiemePlusGrandeCote = cote;
		}
		
		System.out.println("La plus grande cote de l'élève est: "+plusGrandeCote+"/20.");
		System.out.println("La deuxième plus grande cote de l'élève est: "+deuxiemePlusGrandeCote+"/20.");
	}
}
