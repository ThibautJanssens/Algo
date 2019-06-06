/**
 * 
 * @author Janssens Thibaut - IPL - 13 octobre 2015
 *
 */
public class B2 {
public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.print("Entrez n : ");
		int n = scanner.nextInt();
		int[] t = new int[n];
		int i;
		
		for(i=1;i<n+1;i++){
			t[i-1]=7*i;
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
