/**
 * 
 * @author Janssens Thibaut - IPL - 20/10/2015
 *
 */
public class TestCarre {
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	
	public static void main(String[] args) {
		int choix;
		System.out.println("***********************************");
		System.out.println("Programme Test pour la classe Carre");
		System.out.println("***********************************");
		do{
			System.out.println();
			System.out.println("1 -> Tester si un point est inclu dans un carr�.");
			System.out.println("2 -> Tester si deux carr� sont en intersection.");
			System.out.print("\nEntrez votre choix : ");
			choix=scanner.nextInt();
			switch(choix){
				case 1: verifierPointIncluDansCarre(); break;
				case 2: verifierCarreEnIntersection(); break;
				}
			}while(choix >= 1 && choix <= 8);
			System.out.println("Merci pour votre visite.");
	}
	
	public static void verifierPointIncluDansCarre(){
		double positionXCarre, positionYCarre, largeur, positionXPoint, positionYPoint;
		boolean inclu;
		char continuer = 'O';
	
		System.out.println("Veuillez introduire la position x du coin inf�rieur gauche.");
		positionXCarre = scanner.nextDouble();
		System.out.println("Veuillez introduire la position y du coin inf�rieur gauche.");
		positionYCarre = scanner.nextDouble();
		System.out.println("Veuillez introduire la largeur du carr�.");
		largeur = scanner.nextDouble();
		
		Carre carre1 = new Carre(positionXCarre, positionYCarre, largeur);
		
		while (continuer == 'O'){
			System.out.println("Veuillez introduire la position X d'un point quelconque.");
			positionXPoint = scanner.nextDouble();
			System.out.println("Veuillez introduire maintenant sa position Y.");
			positionYPoint = scanner.nextDouble();
		
			inclu = carre1.pointIncluDansCarre(positionXPoint, positionYPoint);
			if (inclu)
				System.out.println("Votre point de coordonn�e ("+positionXPoint+";"+positionYPoint+") est compris dans le carr�.");
			else
				System.out.println("Votre point de coordonn�e ("+positionXPoint+";"+positionYPoint+") n'est pas compris dans le carr�.");
			
			System.out.println("Voulez-vous tester un autre point? (O ou N)");
			Utilitaires.lireOouN();
		}
	}
	
	public static void verifierCarreEnIntersection(){
		double positionXCarre1, positionYCarre1, largeurCarre1, positionXCarre2, positionYCarre2, largeurCarre2;
		boolean intersection;
		char continuer = 'O';
				
		while (continuer == 'O'){
			System.out.println("Veuillez introduire la position x du coin inf�rieur gauche du premier carr�.");
			positionXCarre1 = scanner.nextDouble();
			System.out.println("Veuillez introduire la position y du coin inf�rieur gauche du premier carr�.");
			positionYCarre1 = scanner.nextDouble();
			System.out.println("Veuillez introduire la largeur du premier carr�.");
			largeurCarre1 = scanner.nextDouble();
			
			Carre carre1 = new Carre(positionXCarre1, positionYCarre1, largeurCarre1);
			
			System.out.println("Veuillez introduire la position x du coin inf�rieur gauche du second carr�.");
			positionXCarre2 = scanner.nextDouble();
			System.out.println("Veuillez introduire la position y du coin inf�rieur gauche du second carr�.");
			positionYCarre2 = scanner.nextDouble();
			System.out.println("Veuillez introduire la largeur du second carr�.");
			largeurCarre2 = scanner.nextDouble();
			
			Carre carre2 = new Carre(positionXCarre2, positionYCarre2, largeurCarre2);
					
			intersection = carre1.carreEnIntersection(carre2);
			
			if (intersection)
				System.out.println("Vos carr�s sont en intersection l'un de l'autre.");
			else
				System.out.println("Vos carr�s ne sont pas en intersection l'un de l'autre.");
			
			System.out.println("Voulez-vous tester un autre point? (O ou N)");
			Utilitaires.lireOouN();
		}
	}
}
