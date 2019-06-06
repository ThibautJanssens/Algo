/**
 * 
 * @author Janssens Thibaut IPL - 21/09/15
 * @version 21/09/15
 *
 */
public class AfficheResultat{

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.print("Entrez la moyenne de l'étudiant : ");
		double moyenneEtudiant = scanner.nextDouble();
		String resultatAAfficher = resultat(moyenneEtudiant);
		System.out.println(resultatAAfficher);
	}
		
	public static String resultat(double moyenne){
		if(moyenne < 10)
			return "L'étudiant est refusé";
		if(moyenne < 14)
			return "L'étudiant a satisfait";
		if (moyenne < 16)
			return "L'étudiant a mérité une distinction";
		return "L'étudiant a mérité une grande distinction";
	}
}