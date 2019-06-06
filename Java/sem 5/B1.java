/**
 * 
 * @author Janssens Thibaut - IPL - 13 octobre 2015
 *
 */
public class B1 {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.print("Entrez n : ");
		int n = scanner.nextInt();
		int[] t = new int[n];
		int i=0;
		
		for(i = 0;i<n;i++){
			t[i]= i*2+1;
		}
		
		// CONSIGNES :
		// N'INTRODUISEZ AUCUNE VARIABLE SUPPLEMENTAIRE
		// N'UTILISEZ PAS DE METHODE DE LA CLASSE MATH
		// N'AJOUTEZ AUCUNE METHODE 
		
		System.out.println("Voici la suite demandee : ");
		for (i = 0; i < t.length; i++) {
			System.out.println(t[i]);
		}
	}

}
