/**
 * 
 * @author Janssens Thibaut IPL 28/09/15
 *
 */
public class B5 {
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	public static void main(String[] args) {
		
		int nombre, resultat;
		System.out.println("Tapez un entier pour avoir sa table de multiplication.");
		nombre = scanner.nextInt();
		
		for(int i = 1; i < 11; i++){
			resultat = nombre * i;
			System.out.println(i+" x "+nombre+" = "+resultat);
		}	
	}
}