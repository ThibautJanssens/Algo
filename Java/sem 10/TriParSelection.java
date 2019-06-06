/**
 * 
 * @author Janssens Thibaut - IPL - 23/11/15
 *
 */
public class TriParSelection {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void triSelf(int[] t){
		for (int i=0; i<t.length-1; i++) {
			int indiceMin = i;
			for (int j = i+1; j<t.length; j++) {
				if(t[j]<t[indiceMin])
					indiceMin = j;
			}
			int tmp = t[i];
			t[i] = t[indiceMin];
			t[indiceMin] = tmp;
		}
	}
	
	public static int[] tri(int[] t){
		// A COMPLETER
		// La table passe en parametre ne peut etre modifiee
		// Par soucis de clarte, n'hesitez pas a introduire d'autres methodes 
		int[] tmp = copieTable(t);
		triSelf(tmp);
		return tmp;
	}
	
	private static int[] copieTable(int[] t){
		int[] tmp = new int[t.length];
		for (int i = 0; i<t.length; i++) {
			tmp[i] = t[i];
		}
		return tmp;
	}
	
	public static int[] tri5(int[] t){
		// A COMPLETER
		// La table passe en parametre ne peut etre modifiee
		// POUR UNE QUESTION D'EFFICACITE : IL NE FAUT PAS TRIER TOUTE LA TABLE ET ENSUITE PRENDRE LES 5 PREMIERS!!!
		// La table renvoyee contient 5 entiers ou moins
		int[] tmp = tableMin5(t);
		int[] copieProfonde = copieTable(t);
		if (t.length<=5){
			triSelf(copieProfonde);
			return copieProfonde;
		}
		for (int i=0; i<5; i++) {
			int indiceMin = i;
			for (int j = i+1; j<t.length; j++) {
				if(copieProfonde[j]<copieProfonde[indiceMin])
					indiceMin = j;
			}
			int tmp1 = copieProfonde[i];
			copieProfonde[i] = copieProfonde[indiceMin];
			copieProfonde[indiceMin] = tmp1;
		}
		for (int i = 0; i<5; i++){
			tmp[i]=copieProfonde[i];
		}
		return tmp;
	}
	
	private static int[] tableMin5(int[] t){
		if (t.length<=5){
			int[] tmp = new int[t.length];
			return tmp;
		}
		int[] tmp = new int[5];
		return tmp;
	}
	
	public static void triPartiel(int[] t, int borneInf, int borneSup){
		// A COMPLETER
		// IL FAUT TRIER LA SOUS-TABLE qui va de l'indice borneInf a l'indice borneSup compris
		// Cette methode teste ses parametres et lance une exception de type IllegalArgumentException en cas de probleme
		if (borneInf>= borneSup)
			throw new IllegalArgumentException("Les bornes ne sont pas bonnes");

		for (int i=borneInf; i<borneSup; i++) {
			int indiceMin = i;
			for (int j = i+1; j<borneSup+1; j++) {
				if(t[j]<t[indiceMin])
					indiceMin = j;
			}
			int tmp = t[i];
			t[i] = t[indiceMin];
			t[indiceMin] = tmp;
		}
	}
	
	public static void main(String[] args) {
		int choix;			
		System.out.println("******************************************");
		System.out.println("Programme Test pour le tri par selection :");
		System.out.println("******************************************");
		System.out.println();
		do{
			System.out.println("1 -> Tester la methode 'triSelf()'");
			System.out.println("2 -> Tester la methode 'tri()'");
			System.out.println("3 -> Tester la methode 'tri5()'");
			System.out.println("4 -> Tester la methode 'triPartiel()'");
			System.out.print("\nEntrez votre choix : ");
			choix=scanner.nextInt();
			switch(choix){

			case 1: testTriSelf(); 
			break;
			case 2: testTri();
			break;
			case 3: testTri5();
			break;
			case 4: testTriPartiel();
			}
		}while(choix >=1&&choix<=4);
		System.out.println("Merci pour votre visite.");
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

	private static void testTriSelf(){
		
		// test1 table tout a fait quelconque
		int[] t1 = {4,6,3,9,1,5,8,2,7,0};
		int[]t1Triee = {0,1,2,3,4,5,6,7,8,9};
		triSelf(t1);
		if(!sontIdentiques(t1, t1Triee)){
			System.out.println("\nAttention test 1 ko");
			System.out.println("La table a trier est 4 6 3 9 1 5 8 2 7 0");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t1);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);

		}
		// test 2 table vide
		int[] t2 = {};
		int[]t2Triee = {};
		triSelf(t2);
		if(!sontIdentiques(t2, t2Triee)){
			System.out.println("\nAttention test 2 ko");
			System.out.println("La table a trier est vide");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t2);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		// test 3 table avec 1 entier
		int[] t3 = {9};
		int[]t3Triee = {9};
		triSelf(t3);
		if(!sontIdentiques(t3, t3Triee)){
			System.out.println("\nAttention test 3 ko");
			System.out.println("La table a trier est : 9 ");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t3);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		// test 4 table deja triee
		int[] t4 = {1,2,3,4,5};
		int[]t4Triee = {1,2,3,4,5};
		triSelf(t4);
		if(!sontIdentiques(t4, t4Triee)){
			System.out.println("\nAttention test 4 ko");
			System.out.println("La table a trier est 1 2 3 4 5");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t4);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);

		}
		// test 5 table avec ex-aequo
		int[] t5 = {2,7,3,2,7,5,1,1,2};
		int[]t5Triee = {1,1,2,2,2,3,5,7,7};
		triSelf(t5);
		if(!sontIdentiques(t5, t5Triee)){
			System.out.println("\nAttention test 5 ko");
			System.out.println("La table a trier est 2 7 3 2 7 5 1 1 2");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t5);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		System.out.println("Tous les tests ont reussi!");
		System.out.println();
	}

	private static void testTri(){
		// test1 table tout a fait quelconque
		int[] t1 = {4,6,3,9,1,5,8,2,7,0};
		int[] t1Recopiee = {4,6,3,9,1,5,8,2,7,0};
		int[]t1Triee = {0,1,2,3,4,5,6,7,8,9};
		int[] t1Renvoyee = tri(t1);
		if(!sontIdentiques(t1Renvoyee, t1Triee)){
			System.out.println("\nAttention test 1 ko");
			System.out.println("La table a trier est 4 6 3 9 1 5 8 2 7 0");
			System.out.print("Votre methode fournit la table : ");
			afficher(t1);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		if(!sontIdentiques(t1, t1Recopiee)){
			System.out.println("\nAttention test 1 ko");
			System.out.println("La table a trier a ete modifiee");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		// test2 table vide
		int[] t2 = {};
		int[] t2Recopiee = {};
		int[]t2Triee = {};
		int[] t2Renvoyee = tri(t2);
		if(!sontIdentiques(t2Renvoyee, t2Triee)){
			System.out.println("\nAttention test 2 ko");
			System.out.println("La table a trier est vide");
			System.out.print("Votre methode fournit la table : ");
			afficher(t2);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		if(!sontIdentiques(t2, t2Recopiee)){
			System.out.println("\nAttention test 2 ko");
			System.out.println("La table a trier a ete modifiee");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		// test3 table avec 1 entier
		int[] t3 = {4};
		int[] t3Recopiee = {4};
		int[]t3Triee = {4};
		int[] t3Renvoyee = tri(t3);
		if(!sontIdentiques(t3Renvoyee, t3Triee)){
			System.out.println("\nAttention test 3 ko");
			System.out.println("La table a trier est 4");
			System.out.print("Votre methode fournit la table : ");
			afficher(t3);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		if(!sontIdentiques(t3, t3Recopiee)){
			System.out.println("\nAttention test 3 ko");
			System.out.println("La table a trier a ete modifiee");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		// test 4 table avec ex-aequo
		int[] t4 = {2,7,3,2,7,5,1,1,2};
		int[]t4Triee = {1,1,2,2,2,3,5,7,7};
		int[] t4Recopiee = {2,7,3,2,7,5,1,1,2};
		int[] t4Renvoyee = tri(t4);
		if(!sontIdentiques(t4Renvoyee, t4Triee)){
			System.out.println("\nAttention test 4 ko");
			System.out.println("La table a trier est 2 7 3 2 7 5 1 1 2");
			System.out.print("Votre methode fournit la table : ");
			afficher(t4);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		if(!sontIdentiques(t4, t4Recopiee)){
			System.out.println("\nAttention test 4 ko");
			System.out.println("La table a trier a ete modifiee");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		System.out.println("Tous les tests ont reussi!");
		System.out.println();
	}
	
	private static void testTri5(){
		// test1 table tout a fait quelconque
		int[] t1 = {4,6,3,9,1,5,8,2,7,0};
		int[] t1Recopiee = {4,6,3,9,1,5,8,2,7,0};
		int[]t1Triee = {0,1,2,3,4};
		int[] t1Renvoyee = tri5(t1);
		if(!sontIdentiques(t1Renvoyee, t1Triee)){
			System.out.println("\nAttention test 1 ko");
			System.out.println("La table a trier est 4 6 3 9 1 5 8 2 7 0");
			System.out.print("Votre methode fournit la table : ");
			afficher(t1Renvoyee);
			System.out.println("Cette table n'est pas triee et/ou ne contient pas 5 entiers!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		if(!sontIdentiques(t1, t1Recopiee)){
			System.out.println("\nAttention test 1 ko");
			System.out.println("La table a trier a ete modifiee");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		// test2 table avec 5 entiers
		int[] t2 = {4,1,3,5,2};
		int[] t2Recopiee = {4,1,3,5,2};
		int[]t2Triee = {1,2,3,4,5};
		int[] t2Renvoyee = tri5(t2);
		if(!sontIdentiques(t2Renvoyee, t2Triee)){
			System.out.println("\nAttention test 2 ko");
			System.out.println("La table a trier est 4 1 3 5 2");
			System.out.print("Votre methode fournit la table : ");
			afficher(t2Renvoyee);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		if(!sontIdentiques(t2, t2Recopiee)){
			System.out.println("\nAttention test 2 ko");
			System.out.println("La table a trier a ete modifiee");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		// test3 table avec 1 entier
		int[] t3 = {4};
		int[] t3Recopiee = {4};
		int[]t3Triee = {4};
		int[] t3Renvoyee = tri5(t3);
		if(!sontIdentiques(t3Renvoyee, t3Triee)){
			System.out.println("\nAttention test 3 ko");
			System.out.println("La table a trier est 4");
			System.out.print("Votre methode fournit la table : ");
			afficher(t3Renvoyee);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		if(!sontIdentiques(t3, t3Recopiee)){
			System.out.println("\nAttention test 3 ko");
			System.out.println("La table a trier a ete modifiee");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		// test 4 table avec ex-aequo
		int[] t4 = {2,7,3,2,7,5,1,1,2};
		int[]t4Triee = {1,1,2,2,2};
		int[] t4Recopiee = {2,7,3,2,7,5,1,1,2};
		int[] t4Renvoyee = tri5(t4);
		if(!sontIdentiques(t4Renvoyee, t4Triee)){
			System.out.println("\nAttention test 4 ko");
			System.out.println("La table a trier est 2 7 3 2 7 5 1 1 2");
			System.out.print("Votre methode fournit la table : ");
			afficher(t4);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		if(!sontIdentiques(t4, t4Recopiee)){
			System.out.println("\nAttention test 4 ko");
			System.out.println("La table a trier a ete modifiee");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		System.out.println("Tous les tests ont reussi!");
		System.out.println();
	}
	
	private static void testTriPartiel(){
		// test1 table tout a fait quelconque
		int[] t1 = {4,6,3,9,1,5,8,2,7,0};
		int[]t1Triee = {0,1,2,3,4,5,6,7,8,9};
		triPartiel(t1, 0, 9);
		if(!sontIdentiques(t1, t1Triee)){
			System.out.println("\nAttention test 1 ko");
			System.out.println("La table a trier est 4 6 3 9 1 5 8 2 7 0");
			System.out.print("Apres appel de votre methode avec borneInf=0 et borneSup=9, la table est ");
			afficher(t1);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		// test2 table tout a fait quelconque
		int[] t2 = {4,6,3,9,1,5,8,2,7,0};
		int[]t2Triee = {4,6,1,3,5,8,9,2,7,0};
		triPartiel(t2, 2, 6);
		if(!sontIdentiques(t2, t2Triee)){
			System.out.println("\nAttention test 2 ko");
			System.out.println("La table a trier est 4 6 3 9 1 5 8 2 7 0");
			System.out.print("Apres appel de votre methode avec borneInf=2 et borneSup=6, la table est ");
			afficher(t2);
			System.out.println("Cette table n'est pas triee partiellement!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		System.out.println("Tous les tests ont reussi!");
		System.out.println();
	}

}
