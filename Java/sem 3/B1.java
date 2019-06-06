/**
 * 
 * @author Janssens Thibaut IPL 28/09/15
 *
 */
public class B1 {
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	public static void main(String[] args) {
		
		int nombre, somme = 0;
		
		for (int i = 0; i < 10; i++){
			System.out.println("Entrez un entier.");
			nombre = scanner.nextInt();
			somme += nombre;
		}
		
		System.out.println("La somme vaut: "+ somme);
	}
}
