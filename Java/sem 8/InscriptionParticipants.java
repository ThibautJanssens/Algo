
public class InscriptionParticipants {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	public static Participants p;
	
	public static void main(String [] args){

		int choix;			
		System.out.println("Exercices d'algorithmique et Java");
		System.out.println("1ere Informatique IPL");
		System.out.println();
		System.out.println("******************************");
		System.out.println("Inscription des participants :");
		System.out.println("******************************");
		System.out.println();
		System.out.print("Entrez le nombre maximum de participants : ");
		int nombreMax = scanner.nextInt();
		p = new Participants(nombreMax);
		do{ 
			System.out.println();
			System.out.println("1 -> Afficher tous les inscrits");
			System.out.println("2 -> Ajouter un participant");
			System.out.println("3 -> verifier presence d'un participant");
			System.out.println("4 -> Supprimer un participant");
			System.out.println("5 -> Supprimer tous les participants d'un meme nom");
			System.out.println("6 -> verifier tri");
			System.out.println("7 -> verifier presence d'ex-aequo");
			System.out.println("8 -> Supprimer ex-aequo");
			System.out.print("\nEntrez votre choix : ");
			choix=scanner.nextInt();
			System.out.println();
			switch(choix){
			case 1: afficher(); 
			break;
			case 2: ajouter();   
			break;
			case 3: verifierPresence();   
			break;
			case 4: supprimerUn();   
			break;
			case 5: supprimerTous();   
			break;
			case 6: verifierTri();   
			break;
			case 7: verifierExAequo();   
			break;
			case 8: supprimerExAequo();   
			break;

			}
		}while(choix >=1&&choix<=8);
		System.out.println("Merci pour votre visite.");
	}

	private static void supprimerExAequo() {
		int nombreSuppressions = p.supprimerTousLesExAequos();
		if(nombreSuppressions>0)
			System.out.println(nombreSuppressions+ " ex-aequos ont été supprimés");
		else
			System.out.println("La table ne contient aucun ex-aequo");
	}

	private static void verifierExAequo() {
		if(p.contientExAequo())
			System.out.println("La table des participants contient des ex-aequos");
		else
			System.out.println("La table des participants ne contient pas d'ex-aequo");
		
	}

	private static void verifierTri() {
		if(p.estTrie())
			System.out.println("La table des participants est triee selon l'ordre alphabetique");
		else
			System.out.println("La table des participants n'est pas triee selon l'ordre alphabetique");
		
	}

	private static void supprimerTous() {
		System.out.print("Entrez le nom du participant a supprimer : ");
		String participant = scanner.next();
		int nombreSuppressions = p.supprimerTousLesParticipants(participant);
		if(nombreSuppressions>0)
			System.out.println("Le participant a ete supprime "+ nombreSuppressions+ " fois.");
		else
			System.out.println("Le participant n'a pas ete supprime car il n'est pas inscrit");
		
	}

	private static void supprimerUn() {
		System.out.print("Entrez le nom du participant a supprimer : ");
		String participant = scanner.next();

		if (p.supprimerUnParticipant(participant))
			System.out.println("Le participant a ete supprime avec succes" );
		else
			System.out.println("Le participant n'a pas ete supprime car il n'est pas inscrit");
			
	}

	private static void verifierPresence() {
		System.out.print("Entrez le nom du participant : ");
		String participant = scanner.next();
		if(p.contient(participant))
			System.out.println("Le participant est inscrit");
		else 
			System.out.println("Le participant n'est pas inscrit");
		
	}

	private static void ajouter() {
		System.out.print("Entrez le nom du participant : ");
		String participant = scanner.next();
		if(p.ajouterUnParticipant(participant))
			System.out.println("Le participant a ete ajoute avec succes");
		else 
			System.out.println("Le participant n'a pas ete ajoute car le nombre maximum d'inscriptions est atteint");
		
		
	}

	private static void afficher() {
		System.out.println(p.toString());
		System.out.println();
		
	}
	
}
