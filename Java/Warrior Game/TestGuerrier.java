/**
 * 
 * @author Janssens Thibaut  - IPL - 1/12/15
 *
 */
public class TestGuerrier {
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	
	public static void main(String [] args){

		int choix;			
		System.out.println("Projet 2015");
		System.out.println("1ere Informatique IPL");
		System.out.println("********************************************");
		System.out.println("Programme Test pour la classe Guerrier :");
		System.out.println("********************************************");
		System.out.println();
		do{
			System.out.println("1 -> Tester la methode 'forceDeFrappe()'");
			System.out.println("2 -> Tester la methode 'donnerPrivilege(int privilege)'");
			System.out.println("3 -> Tester la methode 'retirePrivilege(int privilege)'");
			System.out.println("4 -> Tester la methode 'possede(int priviliege)'");
			System.out.println("5 -> Tester la methode 'possedeTous(int[] privilege)'");
			System.out.println("6 -> Tester la methode 'possedeAucun(int[] privilege)'");
			
			
			System.out.print("\nEntrez votre choix : ");
			choix=scanner.nextInt();
			switch(choix){
			case 1: 
				testForceDeFrappe(); 
				break;
			case 2:
				testDonnerPrivilege();
				break;
			case 3:
				testRetirePrivilege();
				break;
			case 4: 
				testPossede();   
				break;
			case 5:
				testPossedeTous();
				break;
			case 6:
				testPossedeAucun();
				break;
			
			}
		}while(choix >=1&&choix<=6);
		System.out.println("Merci pour votre visite.");
	}

	 // test la force de frappe d'un guerrier
	private static void testForceDeFrappe(){
		boolean tousReussis = true;
		Guerrier test = new Guerrier("Nom",30);
		
		//test si la force d'un guerrier est bien donne (1/3 de la vie).
		if (test.donnerForceDeFrappe() != 10){
			System.out.println("Attention! test 1 ko: methode donne une force non reglementaire.");
			tousReussis = false;
		}
		
		//fin du test
		if(tousReussis)
			System.out.println("Tous les tests ont reussi.");
	}
	
	//test de donner un privilege a un guerrier
	private static void testDonnerPrivilege(){
		boolean tousReussis = true;
	// test1 : le guerrier ne possedait pas le privilege
		int[] tableTestee1 = {1,1,1,0,0,0};
		Guerrier war = new Guerrier("Michel",40,tableTestee1);
		
		if(!war.donnerPrivilege(4)){
			tousReussis = false;
			System.out.println("Echec du test1 n'a pas pu ajoute le privilege.");
		}
		
				
	//test2: possede deja tout les privileges
		int[] tableTestee2 = {1,1,1,1,1,1};
		Guerrier war2 = new Guerrier("Jambon",40, tableTestee2);
		
		for(int i=1; i<7;i++){
			war2.donnerPrivilege(i);
		}
		
		if(war2.donnerPrivilege(5)){
			tousReussis = false;
			System.out.println("Test2 raté. Ajout d'un privilege qu'il possede deja.");
		}
	//fin du test
		
		if(tousReussis)
			System.out.println("Tous les tests ont reussi.");
		}
		
	//test de retirer un privilege a un guerrier
	private static void testRetirePrivilege(){
		boolean tousReussis = true;
	// test1 : le guerrier ne possedait pas le privilege a retirer
		int[] tableTestee1 = {1,1,1,1,1,0};
		Guerrier war = new Guerrier("Limite-Pissenlit aka Le Franc",40,tableTestee1);
				
		if(!war.retirePrivilege(4)){
			tousReussis = false;
			System.out.println("Echec du test1 n'a pas pu retirer le privilege.");
		}
				
	//test2: possede tout les privileges
		int[] tableTestee2 = {1,1,1,1,1,1};
		Guerrier war2 = new Guerrier("Jambon",40, tableTestee2);
	
		for(int i=1; i<7;i++){
			war2.retirePrivilege(i);
		}
				
		if(war2.retirePrivilege(5)){
			tousReussis = false;
			System.out.println("Test2 raté. Retrait d'un privilege qu'il ne possede pas.");
		}
	
	//fin du test
				
		if(tousReussis)
			System.out.println("Tous les tests ont reussi.");
	}
		
	//test si le guerrier possede un privilege
	private static void testPossede(){
		boolean tousReussis = true;
		// test1 : le guerrier ne possege pas le privilege
		int[] tableTestee = {0,0,0,1,0,0};
		Guerrier war = new Guerrier("Such Name",40,tableTestee);
		
		if (war.possede(2)){
			tousReussis = false;
			System.out.println("Test1 ko: le guerrier ne possede pas le privilege testé.");
		}
		
		//test2: le guerrier possede le privilege
		int[] tableTestee2 = {1,1,1,1,1,1};
		Guerrier war2 = new Guerrier("Much Privilege",40,tableTestee2);
		
		if(!war2.possede(2)){
			System.out.println("Test 2 ko: le guerrier possede le privilege testé.");
			tousReussis = false;
		}
	
	//fin du test
		if(tousReussis)
			System.out.println("Tous les tests ont reussi.");
	}
	//test si le guerrier possede tous les privilege
	private static void testPossedeTous(){
		boolean tousReussis = true;
		
		// test 1 le parametre est null.
		int[] aucunPrivilege = {0,0,0,0,0,0};
		Guerrier war = new Guerrier("Such Name",40,aucunPrivilege);
		try {
			war.possedeTous(null);
		}catch (Exception e) {
			System.out.println("Test 1 ok: Exception attrapee.((parametre null)");			
		}

		//test 2 parametre est une table avec juste 0.
		int[] toutPrivilege = {1,1,1,1,1,1};
		Guerrier war2 = new Guerrier("Much Privilege",40,toutPrivilege);
		int[] tableTestee2 = {0};
		try {
			war2.possedeTous(tableTestee2);
		}catch (Exception e) {
			System.out.println("Test 2 ok: Exception attrapee.(privileges position -1)");
		}
				
		//test 3 parametre est une table avec une valeur qui depasse la table des privileges.
		int[]tableTestee3 = {7};
		try{
			war2.possedeTous(tableTestee3);
		}catch(Exception e){
			System.out.println("Test 3 ok: Exception attrapee (valeur depassant la table).");
		}
		
		//test 4 Le guerrier possede tout les privileges passe en parametre.
		int[] tableTestee4 = {2,3,4};
		if(!war2.possedeTous(tableTestee4)){
			tousReussis = false;
			System.out.println("Test 4 ko: Le guerrier est cense posseder ces privileges.");
		}
		
		//test 5 Le guerrier ne possede aucun privileges passe en parametre.
		if(war.possedeTous(tableTestee4)){
			tousReussis = false;
			System.out.println("Test 5 ko: Le guerrier ne possede aucun des privileges.");
		}
		
		//test 6 Le guerrier possede une partie des privileges passe en parametre.
		int[] pasToutPrivileges = {1,1,0,1,0,1};
		int[] tableTestee5 = {2,3,4};
		Guerrier war4 = new Guerrier("Tom", 20, pasToutPrivileges);
		if(war4.possedeTous(tableTestee5)){
			tousReussis = false;
			System.out.println("Test 6 ko: Le guerrier n'est pas cense posseder tout les privileges.");
		}
		
		//test 7 Les privileges ne sont pas mis dans l'ordre.
		int[] tableTestee6 = {6,3,1,4,2,5};
		if(!war2.possedeTous(tableTestee6)){
			tousReussis = false;
			System.out.println("Test 7 ko: Le guerrier possde tout les privileges.");
		}
		
		// fin du test.
		if(tousReussis)
			System.out.println("Tous les tests ont reussi.");
	}
	
	//test si le guerrier ne possede aucun privilege
	private static void testPossedeAucun(){
		boolean tousReussis = true;
		
		// test 1 le parametre est null.
		int[] aucunPrivilege = {0,0,0,0,0,0};
		Guerrier war = new Guerrier("Such Name",40,aucunPrivilege);
		try {
			war.possedeAucun(null);
		}catch (Exception e) {
			System.out.println("Test 1 ok: Exception attrapee.((parametre null)");			
		}

		//test 2 parametre est une table avec juste 0.
		int[] toutPrivilege = {1,1,1,1,1,1};
		Guerrier war2 = new Guerrier("Much Privilege",40,toutPrivilege);
		int[] tableTestee2 = {0};
		try {
			war2.possedeAucun(tableTestee2);
		}catch (Exception e) {
			System.out.println("Test 2 ok: Exception attrapee.(privileges position -1)");
		}
				
		//test 3 parametre est une table avec une valeur qui depasse la table des privileges.
		int[]tableTestee3 = {7};
		try{
			war2.possedeAucun(tableTestee3);
		}catch(Exception e){
			System.out.println("Test 3 ok: Exception attrapee (valeur depassant la table).");
		}
		
		//test 4 Le guerrier possede tout les privileges passe en parametre.
		int[] tableTestee4 = {2,3,4};
		if(war2.possedeAucun(tableTestee4)){
			tousReussis = false;
			System.out.println("Test 4 ko: Le guerrier possede ces privileges.");
		}
		
		//test 5 Le guerrier ne possede aucun privileges passe en parametre.
		if(!war.possedeAucun(tableTestee4)){
			tousReussis = false;
			System.out.println("Test 5 ko: Le guerrier ne possede aucun des privileges.");
		}
		
		//test 6 Le guerrier possede une partie des privileges passe en parametre.
		int[] pasToutPrivileges = {1,1,0,1,0,1};
		int[] tableTestee5 = {2,3,4};
		Guerrier war4 = new Guerrier("Tom", 20, pasToutPrivileges);
		if(war4.possedeAucun(tableTestee5)){
			tousReussis = false;
			System.out.println("Test 6 ko: Le guerrier n'est pas cense posseder tout les privileges.");
		}
		
		//test 7 Les privileges ne sont pas mis dans l'ordre.
		int[] tableTestee6 = {6,3,1,4,2,5};
		if(war2.possedeAucun(tableTestee6)){
			tousReussis = false;
			System.out.println("Test 7 ko: Le guerrier possede tout les privileges.");
		}
		
		//test 8
		if(!war.possedeAucun(tableTestee6)){
			tousReussis = false;
			System.out.println("Test 8 ko: Le guerrier ne possede aucun privilege.");
		}
		
		// fin du test.
		if(tousReussis)
			System.out.println("Tous les tests ont reussi.");
	}	
}