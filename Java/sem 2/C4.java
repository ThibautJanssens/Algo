/**
 * 
 * @author Janssens Thibaut IPL - 21/09/15
 * @version 21/09/15
 *
 */
public class C4 {
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	public static void main(String[] args) {
		int jour, mois;
		String saison="";
		
		System.out.println("Entrez le jour et le mois en chiffre svp. \nJour:");
		jour = scanner.nextInt();
		System.out.println("Mois:");
		mois = scanner.nextInt();
		
		if (mois == 3 && jour >= 21)
			saison = "Printemps";
		else {
			if (mois > 3 && mois < 6)
				saison = "Printemps";
			else{
				if (mois == 6 && jour <= 20)
					saison = "Printemps";
				else{
					if (mois == 6 && jour >= 21)
						saison = "Eté";
					else {
						if (mois > 6 && mois < 9)
							saison = "Eté";
						else{
							if (mois == 9 && jour <= 20)
								saison = "Eté";
							else{
								if (mois == 9 && jour >= 21)
									saison = "Automne";
								else {
									if (mois > 9 && mois < 12)
										saison = "Automne";
									else{
										if (mois == 12 && jour <= 20)
											saison = "Automne";
										else
											saison = "Hiver";
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println("Le "+jour+"/"+mois+" est en "+saison);
	}
}
