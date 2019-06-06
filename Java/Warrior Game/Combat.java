
/**
 * 
 * @author Janssens Thibaut  - IPL - 1/12/15
 *
 */
public class Combat {
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	
	private static int tour = 0;
	private static EquipeGuerriers[] equipes = new EquipeGuerriers[2];
	private static String[] privilegesString = {"bouclier","précision","esprit vif","coup double","arme affutée","cotte épineuse"};
	public static void main(String[] args) {
		Guerrier guerrierSelectionne1= null;
		Guerrier guerrierSelectionne2 = null;
	
		int choix;
			System.out.println("          /\\ ");
			System.out.println(" _        )(  ______________________");
			System.out.println("(_)///////(**)______________________>");
			System.out.println("          )(");
			System.out.println("          \\/");
			System.out.println("Bienvenue dans ce jeu de simulation de combats en équipes.");
			System.out.println("Avant tout, c'est au joueur 1 de créer son équipe. Quel nom allez-vous lui donner?(Un seul mot)");
			equipes[0] = creerEquipe();
			System.out.println("Maintenant, c'est au tour du joueur 2! Choisissez votre nom d'équipe.");
			equipes[1] = creerEquipe();
			
			while(!estTermine(equipes[0],equipes[1])){
				System.out.println(equipes[tour%2].getNom()+ ", c'est à  vous!");
				System.out.println("Menu :");
				System.out.println("1: Force de frappe.");
				System.out.println("2: Guerriers avec privilèges donnés");
				System.out.println("3: Guerriers sans les privilèges donnés.");
				System.out.println("4: Liste des privilèges existants.");
				System.out.println("5: Liste des guerriers en vie;");
				System.out.println("0: Retour au jeu(Choisir un guerrier)");
				choix = scanner.nextInt();
				switch (choix) {
				case 1:
					forceDeFrappe();
					break;	
				case 2 :
					guerriersAvec();
					break;
				case 3 :
					guerriersSans();
					break;
				case 4 :
					listePrivileges();
					break;
				case 5 :				
					Utilitaires.afficherEquipe(equipes[tour%2]);
					break;
				default:
						if(tour%2 == 0){
							guerrierSelectionne1 = selectionnerGuerrier();
						}
						else{
							guerrierSelectionne2 = selectionnerGuerrier();
						}
						if(guerrierSelectionne1 != null && guerrierSelectionne2!= null){
							jouer(guerrierSelectionne1,guerrierSelectionne2);
							tour++;
							guerrierSelectionne1 = null;
							guerrierSelectionne2 = null;
						}
						tour ++;
					
					break;
				}
			}
			System.out.println("Partie terminée! L'équipe gagnante est : " + equipes[tour%2].getNom()+ " Félicitations!");
	}
	//verifie que le joueur possede encore des guerriers, si non fini la partie.
	
	public static boolean estTermine(EquipeGuerriers equipe1, EquipeGuerriers equipe2){
		if (equipe1.nombreGuerriersEnJeu() <= 0 || equipe2.nombreGuerriersEnJeu() <= 0)
			return true;
		return false;
	}
	//CrÃ©e l'Ã©quipe.
	public static EquipeGuerriers creerEquipe(){
		String nomEquipe = scanner.next();
		EquipeGuerriers equipe = new EquipeGuerriers(nomEquipe);
		System.out.println("Choisissez maintenant le nom de vos 5 guerriers.");
		for(int i = 0; i < 5; i++){
			System.out.println("Nom du guerrier numéro "+ (i+1));
			String nom = scanner.next();
			Guerrier guerrier = new Guerrier(nom,30);
			equipe.mettreEnJeu(guerrier);
			
		}
		return equipe;
	}

	public static void forceDeFrappe(){
		System.out.println("Entrez la force dÃ©sirÃ©e:");
		int force = scanner.nextInt();
		System.out.println("Voici la liste des guerriers possÃ©dant au minimum une force de :" + force);
		Utilitaires.afficherTableGuerrier(equipes[tour%2].tableGuerriersSelonForce(force));
	}
	
	//Donne un coup.
	public static int donnerCoup(int vie){
		int forceMax = vie/3;
		int forceMin = 1;
		int force = Utilitaires.lancerDe(forceMin, forceMax);
		
		return force;
	}
	public static void guerriersAvec(){
		System.out.println("Entrez le nombre de privilèges que vos guerriers devraient posséder.");
		int nombrePrivileges = scanner.nextInt();
		int[] privileges = new int[nombrePrivileges];
		for(int i = 0; i < privileges.length;i++){
			System.out.println("Entrez le privilège désiré numéro " + (i+1));
			privileges[i] = scanner.nextInt();
		}
		Guerrier[] table = equipes[tour%2].tableGuerriersAvecPrivileges(privileges);
		if(table== null){
			System.out.println("Vous ne possedez pas de guerrier possédant ce privilèges");
		}
		else{
			System.out.println("Voici les guerriers possédants le(s) privilège(s) demandé(s)");
			Utilitaires.afficherTableGuerrier(table);
		}
	}
	public static void guerriersSans(){
		System.out.println("Entrez le nombre de privilèges que vos guerriers ne devraient pas posséder.");
		int nombrePrivilegesAbsents = scanner.nextInt();
		int[] privilegesAbsents = new int[nombrePrivilegesAbsents];
		for(int i = 0; i < privilegesAbsents.length;i++){
			System.out.println("Entrez le privilège désiré numéro " + (i+1));
			privilegesAbsents[i] = scanner.nextInt();
		}
		Guerrier[] tableAbsents = equipes[tour%2].tableGuerriersSansPrivileges(privilegesAbsents);
		if(tableAbsents== null){
			System.out.println("Vous ne possedez pas de guerrier ne possédant pas ce privilèges");
		}
		else{
			System.out.println("Voici les guerriers ne possédants pas le(s) privilège(s) demandé(s)");
			Utilitaires.afficherTableGuerrier(tableAbsents);
		}
	}
	public static void listePrivileges(){
		System.out.println("1 : "+ privilegesString[0]);
		System.out.println("Les guerriers possÃ©dants le privilège bouclier subissent 2 de dégats en moins à  chaque coup.\n");
		System.out.println("2 : "+privilegesString[1]);
		System.out.println("Les guerriers possÃ©dants le privilège précision ont 10% de chance de faire un coup critique. \nLes coups critiques infliges le maximum de dégats que le guerrier est capable de faire.\n");
		System.out.println("3 : "+privilegesString[2]);
		System.out.println("Les guerriers possÃ©dants le privilège esprit vif ont 10% de chance d'esquiver un coup et donc de ne pas prendre de dégats.\n");
		System.out.println("4 : "+privilegesString[3]);
		System.out.println("Les guerriers possÃ©dants le privilège coup double infligent 2 fois leurs dégats une fois sur 4.\n");
		System.out.println("5 : "+privilegesString[4]);
		System.out.println("Les guerriers possÃ©dants le privilège arme affutée infligent 2 de dégats en plus à  chaque coup.\n");
		System.out.println("6 : "+privilegesString[5]);
		System.out.println("Les guerriers possÃ©dants le privilège cotte épineuse renvoie à  l'adversaire 10% des dégats qu'ils subissent.\n");
	}
	public static Guerrier selectionnerGuerrier(){
		System.out.println("Saisissez le nom du guerrier que vous dÃ©sirez. Veillez à  ce qu'il appartienne Ã  votre équipe.");
		String guerrier = scanner.next();
		Guerrier guerrierSelectionne = equipes[tour%2].selectionner(guerrier);
		while(guerrierSelectionne == null){
			System.out.println("Mettez un nom d'un guerrier que vous possédez SVP. Faites attention à  l'orthographe.");
			guerrier = scanner.next();
			guerrierSelectionne = equipes[tour%2].selectionner(guerrier);
		}
		return guerrierSelectionne;
	}
	public static void jouer(Guerrier guerrier1, Guerrier guerrier2){
		EquipeGuerriers equipe1 = equipes[0];
		EquipeGuerriers equipe2 = equipes[1];
		int degats1,degats2, vie1 = guerrier1.getPointsDeVie(),vie2 = guerrier2.getPointsDeVie(), compteur = 0;
	
		while(vie1 > 0 && vie2 > 0){
			degats1 = donnerCoup(vie1);
			if(guerrier2.getPrivilege()[0] == 1){
				if(degats1 > 3){
					System.out.println("Le bouclier de " + guerrier2.getNom()+ " réduit de 2 les dégats.");
					degats1 -= 2;
					}
			}
			if(guerrier1.getPrivilege()[1] == 1){
				if(Utilitaires.lancerDe(1,10) == 10){
					System.out.println("COUP CRITIQUE!");
					degats1 = guerrier1.donnerForceDeFrappe();
				}
			}
			if(guerrier2.getPrivilege()[2] == 1){
				if(Utilitaires.lancerDe(1,10) == 10){
					System.out.println("ESQUIVE!");
					degats1 = 0;
				}
			}
			if(guerrier1.getPrivilege()[3] == 1){
				if(compteur != 0 && compteur%4 == 0)
					System.out.println("Coup double!");
					degats1 = degats1*2;
			}
			if(guerrier1.getPrivilege()[4] == 1){
				System.out.println("L'arme affutée occasionne 2 de dégats supplémentaires.");
				degats1 += 2;
			}
			if(guerrier2.getPrivilege()[5] == 1){
				System.out.println(guerrier2.getNom()+ " renvoie une partie des dégats!");
				vie1 -= 1;
			}
			vie2 -= degats1;
			guerrier2.setPointsDeVie(vie2);
			System.out.println(guerrier1.getNom()+" inflige " + degats1 + " point(s) de dégat(s) à  " +guerrier2.getNom());
			System.out.println("Il reste "+vie2+" point(s) de vie à  "+guerrier2.getNom());
			if(vie2 <= 0){
				System.out.println(guerrier2.getNom()+" est mort.");
				for(int i = 0; i < guerrier1.getPrivilege().length; i++){
					if(guerrier2.possede(i+1)){
						guerrier2.retirePrivilege(i+1);
						guerrier1.donnerPrivilege(i+1);
						System.out.println(guerrier1.getNom() + " prend le privilège " + privilegesString[i] + " de " + guerrier2.getNom());
					}
				}
				equipe2.mourir(guerrier2);
			}
			
			
			
			if(vie2 > 0){
			degats2 = donnerCoup(vie2);
			
			if(guerrier1.getPrivilege()[0] == 1){
				if(degats2 > 3){
				System.out.println("Le bouclier de " + guerrier1.getNom()+ " réduit de 2 les dégats.");
				degats2 -= 2;
				}
			}
			if(guerrier2.getPrivilege()[1] == 1){
				if(Utilitaires.lancerDe(1,10) == 10){
					System.out.println("COUP CRITIQUE!");
					degats2 = guerrier2.donnerForceDeFrappe();
				}
			}
			if(guerrier1.getPrivilege()[2] == 1){
				if(Utilitaires.lancerDe(1,10) == 10){
					System.out.println("ESQUIVE!");
					degats2 = 0;
				}
			}
			if(guerrier2.getPrivilege()[3] == 1){
				if(compteur != 0 && compteur%4 == 0)
					System.out.println("Coup double!");
					degats2 = degats2*2;
			}
			if(guerrier2.getPrivilege()[4] == 1){
				System.out.println("L'arme affutée occasionne 2 de dégats supplémentaires.");
				degats2 += 2;
			}
			if(guerrier1.getPrivilege()[5] == 1){
				System.out.println(guerrier1.getNom()+ " renvoie une partie des dégats!");
				vie2 -= 1;
			}
			vie1 -= degats2;
			guerrier1.setPointsDeVie(vie1);
			System.out.println(guerrier2.getNom()+" inflige " + degats2 + " point(s) de dégat(s) à  "+ guerrier1.getNom());
			System.out.println("Il reste "+vie1+" point(s) de vie à  " + guerrier1.getNom());
			}
			if(vie1 <= 0){
				System.out.println(guerrier1.getNom()+" est mort.");
				for(int i = 0; i < guerrier2.getPrivilege().length; i++){
					if(guerrier1.possede(i+1)){
						guerrier1.retirePrivilege(i+1);
						guerrier2.donnerPrivilege(i+1);
						System.out.println(guerrier2.getNom() + " prend le privilège " + privilegesString[i] + " de " + guerrier1.getNom());
					}
				}
				equipe1.mourir(guerrier1);
			}
			compteur++;
		}
		
		equipes[0] = equipe1;
		equipes[1] = equipe2;
	}
	
}