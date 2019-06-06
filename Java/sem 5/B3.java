/**
 * 
 * @author Janssens Thibaut - IPL - 13 octobre 2015
 *
 */
public class B3 {
public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.print("Entrez n : ");
		int n = scanner.nextInt();
		
		if(n==0)
			System.out.println("1");
		else{
			int[] t = new int[n];
			int i;
		
			t[0]=1;
		
			for(i=1;i<n;i++){
				t[i]=t[i-1]*2;
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
}
