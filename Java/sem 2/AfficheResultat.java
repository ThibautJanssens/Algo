/**
 * 
 * @author Janssens Thibaut IPL - 21/09/15
 * @version 21/09/15
 *
 */
public class AfficheResultat{

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.print("Entrez la moyenne de l'�tudiant : ");
		double moyenneEtudiant = scanner.nextDouble();
		String resultatAAfficher = resultat(moyenneEtudiant);
		System.out.println(resultatAAfficher);
	}
		
	public static String resultat(double moyenne){
		if(moyenne < 10)
			return "L'�tudiant est refus�";
		if(moyenne < 14)
			return "L'�tudiant a satisfait";
		if (moyenne < 16)
			return "L'�tudiant a m�rit� une distinction";
		return "L'�tudiant a m�rit� une grande distinction";
	}
}