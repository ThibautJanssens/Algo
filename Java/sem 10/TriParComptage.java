/**
 * 
 * @author Janssens Thibaut - IPL - 23/11/15
 *
 */
public class TriParComptage {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void tri(int[] t, int borneSup){
		// Les entiers contenus dans la table sont contenus entre 0 et borneSup
		// A ne pas verifier
		int[] tableComptage = new int [borneSup+1]; 
		for (int i=0;i<t.length;i++){
			tableComptage[t[i]]+=1;
		}
		int indice = 0;
		for (int j=0;j<tableComptage.length;j++){
			while(tableComptage[j]!=0){
				t[indice] = j;
				tableComptage[j]--;
				indice++;
			}
		}
	}
	
	private static void afficher(int[] table){
		for(int i = 0 ; i < table.length ; i++)
			System.out.print(" "+ table[i]);
		System.out.println();
	}

	private static boolean sontIdentiques(int[] table1, int[] table2){
		if(table1.length != table2.length)
			return false;
		for(int i = 0 ; i < table1.length ; i++)
			if(table1[i]!=table2[i])
				return false;
		return true;

	}

	public static void main(String[] args) {		
		System.out.println("*****************************************");
		System.out.println("Programme Test pour le tri par comptage :");
		System.out.println("*****************************************");
		System.out.println();
		
		int[] t = {4,2,2,7,2,0,2,5,0,9,2,7,5,2,5,5};
		int[]tTriee = {0,0,2,2,2,2,2,2,4,5,5,5,5,7,7,9};
		tri(t,9);
		if(!sontIdentiques(t, tTriee)){
			System.out.println("\nAttention test  ko");
			System.out.println("La table a trier est 4 2 2 7 2 0 2 5 0 9 2 7 5 2 5 5");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);

		}
      System.out.println("Le test a reussi!");
	}
}
