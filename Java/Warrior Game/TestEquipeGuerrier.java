/**
 * 
 * @author Janssens Thibaut  - IPL - 1/12/15
 *
 */
public class TestEquipeGuerrier {
public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	
	public static void main(String [] args){

		int choix;			
		System.out.println("Projet 2015");
		System.out.println("1ere Informatique IPL");
		System.out.println("***********************************************");
		System.out.println("Programme Test pour la classe EquipeGuerriers :");
		System.out.println("***********************************************");
		System.out.println();
		do{
			System.out.println("1 -> Tester la methode 'nombreGuerrierEnJeu()'");
			System.out.println("2 -> Tester la methode 'estPresent(Guerrier guerrier)'");
			System.out.println("3 -> Tester la methode 'mettreEnJeu(Guerrier guerrier)'");
			System.out.println("4 -> Tester la methode 'selectionner(String nomGuerrier)'");
			System.out.println("5 -> Tester la methode 'mourir(Guerrier guerrier)'");
			System.out.println("6 -> Tester la methode 'tableGuerriersSelonForce(int force)'");
			System.out.println("7 -> Tester la methode 'tableGuerriersAvecPrivileges(int[] privileges)'");
			System.out.println("8 -> Tester la methode 'tableGuerriersSansPrivileges(int[] privileges)'");
			
			System.out.print("\nEntrez votre choix : ");
			choix=scanner.nextInt();
			switch(choix){
			case 1: 
				testNombreGuerrierEnJeu(); 
				break;
			case 2:
				testEstPresent();
				break;
			case 3: 
				testMettreEnJeu();   
				break;
			case 4:
				testSelectionner();
				break;
			case 5:
				testMourir();
				break;
			case 6:
				testTableGuerriersSelonForce();
				break;
			case 7:
				testTableGuerriersAvecPrivileges();
				break;
			case 8:
				testTableGuerriersSansPrivileges();
				break;
			}
		}while(choix >=1&&choix<=8);
		System.out.println("Merci pour votre visite.");
	}
	
	//test le nombre de guerrier que possede l'equipe
	private static void testNombreGuerrierEnJeu(){
		boolean tousReussis = true;
		Guerrier war1 = new Guerrier ("Such name",40);
		Guerrier war2 = new Guerrier ("Much life",40);
		Guerrier war3 = new Guerrier ("So Doge",40);
		Guerrier war4 = new Guerrier ("Wow",40);
		Guerrier war5 = new Guerrier ("Someone",40);
		Guerrier[] warList1 = {war1,war2,war3,war4,war5};
		EquipeGuerriers test1 = new EquipeGuerriers("FFDP",warList1);
		
		//5 guerriers en vie dans l'equipe
		if(test1.nombreGuerriersEnJeu() != 5){
			tousReussis = false;
			System.out.println("Test 1 ko: L equipe compte normalement 5 guerriers.");
		}
		
		//aucun guerriers
		EquipeGuerriers test2 = new EquipeGuerriers("Poupou du dimanche");
		
		if(test2.nombreGuerriersEnJeu() != 0){
			tousReussis = false;
			System.out.println("Test 2 ko: L'equipe ne compte aucun guerrier.");
		}
		
		//3guerriers en vie dans l'equipe
		Guerrier[] warList2 = {war1,war2,war5,null,null};
		EquipeGuerriers test3 = new EquipeGuerriers("BFMV", warList2);
		
		if (test3.nombreGuerriersEnJeu() !=3){
			tousReussis = false;
			System.out.println("Test 3 ko: l'equipe a 3 guerrier en vie.");
		}
		
		//fin du test
		if(tousReussis)
			System.out.println("Tous les tests ont reussi.");
	}
	
	//test si un guerrier est present dans l equipe
	private static void testEstPresent(){
		boolean tousReussis = true;
		Guerrier war1 = new Guerrier ("a",40);
		Guerrier war2 = new Guerrier ("b",40);
		Guerrier war3 = new Guerrier ("c",40);
		Guerrier war4 = new Guerrier ("d",40);
		Guerrier war5 = new Guerrier ("e",40);
		Guerrier[] warList1 = {war1,war2,war3,war4,war5};
		EquipeGuerriers test1 = new EquipeGuerriers("BFMV",warList1);
		
		//guerrier present dans la liste
		if(!test1.estPresent(war2)){
			tousReussis = false;
			System.out.println("Test 1 ko: Le guerrier devrait etre present.");
		}
		
		
		//guerrier n'est pas present dans la liste
		Guerrier warTest = new Guerrier("Afk",10);
		if(test1.estPresent(warTest)){
			tousReussis = false;
			System.out.println("Test 2 ko: La methode trouve un guerrier absent.");
		}
		
		//fin du test
		if(tousReussis)
			System.out.println("Tous les tests ont reussi.");
	}
	
	//test de mettre dans une equpie un guerrier
	private static void testMettreEnJeu(){
		boolean tousReussis = true;
		Guerrier war1 = new Guerrier ("a",40);
		Guerrier war2 = new Guerrier ("b",40);
		Guerrier war3 = new Guerrier ("c",40);
		Guerrier war4 = new Guerrier ("d",40);
		Guerrier war5 = new Guerrier ("e",40);
		Guerrier war6 = new Guerrier ("f",40);
		Guerrier[] warList1 = {war1,war2,war3,war4,war5};
		EquipeGuerriers test1 = new EquipeGuerriers("Disturbed",warList1);
		
		//ajout dans une equipe pleine
		if(test1.mettreEnJeu(war6)){
			tousReussis = false;
			System.out.println("Test 1 ko: Votre methode ajoute un guerrier alors que l'equipe est complete");
		}
		
		//tentative d'ajout d'un guerrier deja present dans l equipe
		Guerrier[] warList2 = {war1,war2,war3,null,null};
		EquipeGuerriers test2 = new EquipeGuerriers("Trivium",warList2);
		
		if(test2.mettreEnJeu(war2)){
			System.out.println("Test 2 ko: On ajoute un guerrier deja present dans l'equipe");
			tousReussis = false;
		}
		
		//ajout d'une guerrier dans une equipe vide
		EquipeGuerriers test3 = new EquipeGuerriers("Linkin Park");
		
		if(!test3.mettreEnJeu(war1)){
			System.out.println("Test 3.1 ko: On n'a pas pu ajouter un guerrier alors que l'equipe est vide.");
			tousReussis = false;
		}
		
		if(test3.nombreGuerriersEnJeu() != 1){
			System.out.println("Test 3.2 ko: Le nombre de guerrier n'est pas mis a jour.");
			tousReussis = false;
		}
		
		if(!test3.mettreEnJeu(war2)){
			System.out.println("Test 3.3 ko: on n'a pas pu rajouter un deuxieme guerrier dans l'equipe.");
			tousReussis = false;
		}
			
		if(test3.nombreGuerriersEnJeu() != 2){
			System.out.println("Test 3.4 ko: Le nombre de guerrier n'est pas mis a jour.");
			tousReussis = false;
		}
		
		//ajout d'un guerrier dans une equipe en construction
		Guerrier[] warList4 = {war1,war3,war4,war5,null};
		EquipeGuerriers test4 = new EquipeGuerriers("BMTH", warList4);
		
		if(!test4.mettreEnJeu(war2) && test4.nombreGuerriersEnJeu() != 5){
			System.out.println("Test 4 ko: L'ajout du guerrier n'a pas eu lieu ou il n'a pas le bon nombre de guerrier.");
			tousReussis = false;
		}
		
		//fin du test
		if(tousReussis)
			System.out.println("Tous les tests ont reussi.");
	}
	
	//test si on peut choisir un guerrier a envoye au combat
	private static void testSelectionner(){
		boolean tousReussis = true;
		Guerrier war1 = new Guerrier ("a",40);
		Guerrier war2 = new Guerrier ("b",40);
		Guerrier war3 = new Guerrier ("c",40);
		Guerrier war4 = new Guerrier ("d",40);
		Guerrier war5 = new Guerrier ("e",40);
		Guerrier[] warList1 = {war1,war2,war3,war4,war5};
		EquipeGuerriers test1 = new EquipeGuerriers("Frog Leap Studio",warList1);
		
		//test avec un guerrier existant dans l equipe
		if (test1.selectionner("a") != war1){
			tousReussis = false;
			System.out.println("Test 1 ko: La methode renvoie le mauvais guerrier.");
		}
		
		//test avec le guerrier n etant pas dans la liste.
		if (test1.selectionner("f") != null){
			tousReussis = false;
			System.out.println("Test 2 ko: La methode trouve un guerrier qui n'est pas dans l equipe.");
		}

		//fin du test.
		if(tousReussis)
			System.out.println("Tous les tests ont reussi.");
	}
	
	//test si un guerrier peut mourir
	private static void testMourir(){
		boolean tousReussis = true;
		Guerrier war1 = new Guerrier ("a",40);
		Guerrier war2 = new Guerrier ("b",40);
		Guerrier war3 = new Guerrier ("c",40);
		Guerrier war4 = new Guerrier ("d",40);
		Guerrier war5 = new Guerrier ("e",40);
		Guerrier[] warList1 = {null,null,null,null,null};
		EquipeGuerriers test1 = new EquipeGuerriers("Gorillaz",warList1);
		
		//test avec une equipe vide.
		if (test1.mourir(war1)){
			tousReussis = false;
			System.out.println("Test 1 ko: La methode a tue un guerrier non existant.");
		}

		//test avec un guerrier qui n'est pas dans une equipe pleine
		Guerrier[] warList2 = {war1,war2,war3,war4,war5};
		Guerrier war6 = new Guerrier ("f",40);
		EquipeGuerriers test2 = new EquipeGuerriers("Girugamesh",warList2);
		if (test2.mourir(war6)){
			tousReussis = false;
			System.out.println("Test 2 ko: La methode tue un guerrier qui n'est pas dans une equipe pleine.");
		}
			
		//test avec un guerrier qui n'est pas dans une equipe non pleine
		Guerrier[] warList3 = {war1,war2,war3,null,null};
		EquipeGuerriers test3 = new EquipeGuerriers("Maximum The Hormone", warList3);
		if(test3.mourir(war6)){
			tousReussis = false;
			System.out.println("Test 3 ko: La methode tue un guerrier qui n'est pas dans une equipe non pleine.");
		}
		
		//test avec un guerrier qui est dans une equipe pleine
		if(!test2.mourir(war1) && test2.nombreGuerriersEnJeu() != 4){
			tousReussis = false;
			System.out.println("Test 4 ko: La methode ne tue pas le guerrier qui de l equipe(pleine) ou ne met pas a jour le nombre de guerrier en vie.");
		}
		
		//test avec un guerrier qui est dans une equipe non pleine
		if(!test3.mourir(war1) && test3.nombreGuerriersEnJeu() != 2){
			tousReussis = false;
			System.out.println("Test 5 ko: La methode ne tue pas le guerrier qui de l equipe(non pleine) ou ne met pas a jour le nombre de guerrier en vie.");
		}
		
		//fin du test
		if(tousReussis)
			System.out.println("Tous les tests ont reussi.");
	}
	
	public static void testTableGuerriersSelonForce(){
		boolean tousReussis = true;
		Guerrier war1 = new Guerrier ("a",30);
		Guerrier war2 = new Guerrier ("b",25);
		Guerrier war3 = new Guerrier ("c",35);
		Guerrier war4 = new Guerrier ("d",40);
		Guerrier war5 = new Guerrier ("e",15);
		Guerrier[] warList1 = {war1,war3,war5,war2,war4};
		Guerrier[] warListCorrecte = {war1,war3,war4};
		EquipeGuerriers test1 = new EquipeGuerriers("Disturbed",warList1);
		
		Guerrier[] testList = test1.tableGuerriersSelonForce(10);
		
		//test si la taille est la bonne.
		if(testList.length != warListCorrecte.length){
			tousReussis = false;
			System.out.println("Test 1 ko: La table renvoye par la methode n'a pas la bonne taille.");	
		}
		//test si le contenu est correctement trie.
		for (int i=0; i<warListCorrecte.length;i++){
			if(testList[i] != warListCorrecte[i]){
				tousReussis = false;
				System.out.println("Test 2 ko: La table renvoye n'est pas bien trie.");
			}
		}
		
		//test avec guerrier ne possedant pas la force minimum demandee.
		Guerrier war6 = new Guerrier ("a",15);
		Guerrier war7 = new Guerrier ("b",15);
		Guerrier war8 = new Guerrier ("c",15);
		Guerrier war9 = new Guerrier ("d",15);
		Guerrier war10 = new Guerrier ("e",15);
		Guerrier[] warList2 = {war6,war7,war8,war9,war10};
		EquipeGuerriers test2 = new EquipeGuerriers("Avenged Sevenfold", warList2);
		
		Guerrier[] testList2 = test2.tableGuerriersSelonForce(30);
		if(testList2 != null){
			tousReussis = false;
			System.out.println("Test 3 ko: Votre methode a cree une table alors qu'aucun guerrier n'est qualifie pour.");
		}
		//fin du test
		if(tousReussis)
			System.out.println("Tous les tests ont reussi.");
	}
	
	public static void testTableGuerriersAvecPrivileges(){
		boolean tousReussis = true;
		int[] aucunPrivilege = {0,0,0,0,0,0};
		int[] toutPrivilege = {1,1,1,1,1,1};
		int[] quelquesPrivileges = {1,0,0,1,1,1,0};
		Guerrier war1 = new Guerrier ("a",30,aucunPrivilege);
		Guerrier war2 = new Guerrier ("b",25,toutPrivilege);
		Guerrier war3 = new Guerrier ("c",35,quelquesPrivileges);
		Guerrier war4 = new Guerrier ("d",40,quelquesPrivileges);
		Guerrier war5 = new Guerrier ("e",15,quelquesPrivileges);
		Guerrier[] warList1 = {war1,war2,war3,war4,war5};
		Guerrier[] warListCorrecte = {war2,war3,war4,war5};
		EquipeGuerriers test1 = new EquipeGuerriers("Disturbed",warList1);
		
		int[] tableTestee = {1,4,5};
		Guerrier[] testList = test1.tableGuerriersAvecPrivileges(tableTestee);
		
		//test si la taille est la bonne.
		if(testList.length != warListCorrecte.length){
			tousReussis = false;
			System.out.println("Test 1 ko: La table renvoye par la methode n'a pas la bonne taille.");	
		}
		//test si le contenu est correctement trie.
		for (int i=0; i<warListCorrecte.length;i++){
			if(testList[i] != warListCorrecte[i]){
				tousReussis = false;
				System.out.println("Test 2 ko: La table renvoye n'est pas bien trie.");
			}
		}
		
		//test quand aucun guerrier ne correspond.
		war2 = war3;
		Guerrier[] warList2 = {war1,war2,war3,war4,war5};
		EquipeGuerriers test2 = new EquipeGuerriers("ACDC",warList2);
		int[] tableTestee2 = {2,3};
		
		if(test2.tableGuerriersAvecPrivileges(tableTestee2) != null){
			tousReussis = false;
			System.out.println("Test 3 ko: Aucun guerrier ne correspond a la liste de privileges.");
		}
		
		//fin du test
		if(tousReussis)
			System.out.println("Tous les tests ont reussi.");
	}
	
	public static void testTableGuerriersSansPrivileges(){
		boolean tousReussis = true;
		int[] aucunPrivilege = {0,0,0,0,0,0};
		int[] toutPrivilege = {1,1,1,1,1,1};
		int[] quelquesPrivileges = {1,0,0,1,1,1,0};
		Guerrier war1 = new Guerrier ("a",30,aucunPrivilege);
		Guerrier war2 = new Guerrier ("b",25,toutPrivilege);
		Guerrier war3 = new Guerrier ("c",35,quelquesPrivileges);
		Guerrier war4 = new Guerrier ("d",40,quelquesPrivileges);
		Guerrier war5 = new Guerrier ("e",15,quelquesPrivileges);
		Guerrier[] warList1 = {war1,war2,war3,war4,war5};
		Guerrier[] warListCorrecte = {war1,war3,war4,war5};
		EquipeGuerriers test1 = new EquipeGuerriers("Disturbed",warList1);
		
		int[] tableTestee = {2,3};
		Guerrier[] testList = test1.tableGuerriersSansPrivileges(tableTestee);
		
		//test si la taille est la bonne.
		if(testList.length != warListCorrecte.length){
			tousReussis = false;
			System.out.println("Test 1 ko: La table renvoye par la methode n'a pas la bonne taille.");	
		}
		
		//test si le contenu est correctement trie.
		for (int i=0; i<warListCorrecte.length;i++){
			if(testList[i] != warListCorrecte[i]){
				tousReussis = false;
				System.out.println("Test 2 ko: La table renvoye n'est pas bien trie.");
			}
		}
		
		//test quand aucun guerrier ne correspond.
		war1 = war3;
		Guerrier[] warList2 = {war1,war2,war3,war4,war5};
		EquipeGuerriers test2 = new EquipeGuerriers("ACDC",warList2);
		int[] tableTestee2 = {1,4,5};
				
		if(test2.tableGuerriersSansPrivileges(tableTestee2) != null){
			tousReussis = false;
			System.out.println("Test 3 ko: Aucun guerrier ne correspond a la liste de privileges.");
		}
		
		//fin du test
		if(tousReussis)
			System.out.println("Tous les tests ont reussi.");
	}
}