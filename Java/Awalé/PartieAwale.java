//IPL, algorithmique (I1010), projet awale
//
// Q1, 2014
//
// Thibaut Janssens :
// Sébastien Place :
public class PartieAwale {
  private static int n;
  private static Etat[] etats;
  
  public static java.util.Scanner scanner = new java.util.Scanner(System.in);


  /*
  affiche l'historique de la partie.
  L'historique est stocké dans le tableau etats[].
  */
  public static void afficheDeroulement() {
  	for(int i=0; i<n+1; i++){
  		System.out.println("*****");
  		System.out.println("Tour n° "+(i+1));
  		System.out.println(etats[i]);
  		System.out.println("*****");
  	}
  }
  /*
  Le main fait fonctionner l'ensemble du programme.
  */
  public static void main(String args[]) {
  	String[] joueurs = new String[2];
  	joueurs[0] = "Nord";
  	joueurs[1] = "Sud";
  	Etat etatCourant = new Etat();
  	n = 0;
  	etats = new Etat[1];
  	etats[0] = etatCourant;

  	while(!(etatCourant.estTerminee())){
  		System.out.print("Choisissez votre trou à jouer, pour avoir de ");
  		System.out.print("l'aide taper 12,\npour afficher le déroulement");
  		System.out.print("du jeu, taper 13\n\n");

  		System.out.println("Tour n°"+n+1);

  		System.out.println("Joueur "+ joueurs[n%2]+"\n");

  		System.out.println(etatCourant);

  		int choix;
  		choix = scanner.nextInt();

  		if(doUserInput(choix, etatCourant)){
  			if (etatCourant.estLegal(choix)){
  				etatCourant = etatCourant.joue(choix);
  			}
  			n++;
  			ajouterEtat(etatCourant);
  		}
  	}
  }

  /*
  Fonction qui analyse les input de l'utilisateur,
  elle vérifie si tout d'abord l'utilisateur à rentré des valeurs correctes.
  Elle donne le classement des trou si la valeur donnée est égale à 12.
  Elle affiche le déroulement du jeux si la valeur donnée est égale à 13.
  Pour le reste elle renvoie true et les autre nombre seront traité plus haut dans le main.
  */
  private static boolean doUserInput(int input, Etat etat){
  	if (input >=0 && input <= 13){
  		if (input == 12){
  			int[] classement = etat.classementDesTrous();
  			System.out.println("Affichage des trous et le nombre de pois");
  			System.out.print("captures\n");
  			for (int i = 0; i<classement.length; i++){
  				System.out.print(classement[i]+" ");
  			}
  			return false;
  		}
  		if (input == 13){
  			afficheDeroulement();
  			return false;
  		}
  		else{
  			return true;
  		}
  	}
  	System.out.println("Le nombre donné n'est pas valide, choississez");
  	System.out.print(" un nombre entre 0 et 13");
  	return false;	
  }

  /*
  Fonction qui ajoute un Etat à la table d'états, afin de stocker le cours de la partie.
  A chaques ajout, on arandi la table d'une unité qui contiendra le nouvel état.
  */
  private static void ajouterEtat(Etat etat){
  	Etat[] tmp = etats;
  	etats = new Etat[n+1];
  	for (int i = 0; i<tmp.length; i++){
  		etats[i]=tmp[i];
  	}
  	etats[tmp.length] = etat;
  }
}
