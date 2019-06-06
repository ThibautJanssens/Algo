/**
 * 
 * @author Janssens Thibaut
 *
 */
public class TemplateE1{

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	
	public static void main(String[] args) {
		System.out.println("Veuillez entrer la moyenne de l'étudiant");
		int moyenneEtudiant = scanner.nextInt();
		
		if (moyenneEtudiant < 10)
			System.out.println("L'étudiant est refusé.");
		else{
			if(moyenneEtudiant < 14)
				System.out.println("L'étudiant a satisfait.");
			else{
				if (moyenneEtudiant < 16)
					System.out.println("L'étudiant mérite une distinction.");
				else
					System.out.println("L'étudiant mérite une grande distinction.");
			}
		}
	}
}