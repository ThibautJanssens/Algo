/**
 * 
 * @author Janssens Thibaut IPL 28/09/15
 *
 */
public class B2 {
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	public static void main(String[] args) {
		
int nombre, sommePos = 0, sommeNeg = 0;
		
		for (int i = 0; i < 6; i++){
			System.out.println("Entrez un entier.");
			nombre = scanner.nextInt();
			if (nombre >= 0){
				sommePos += nombre;
			}
			else{
				sommeNeg += nombre;
			}
		}
		
		System.out.println("La somme des positifs vaut: "+ sommePos+"\nLa somme des négatifs vaut: "+sommeNeg);
	}
}
