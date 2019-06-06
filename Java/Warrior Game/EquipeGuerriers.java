/**
 * 
 * @author Janssens Thibaut  - IPL - 1/12/15
 *
 */
public class EquipeGuerriers {
	private String nom;
	private Guerrier[] war; 
	int nombreGuerrierEnVie;
	
	public EquipeGuerriers(String nom){
		this.nom = nom;
		this.war = new Guerrier[5];
		nombreGuerrierEnVie = 0;
	}
	
	//constructeur pour les tests
	public EquipeGuerriers(String nom,Guerrier[] guerriers){
		this.nom = nom;
		this.war = guerriers;
		this.nombreGuerrierEnVie = 0;
		for(int i = 0; i < 5;i++){
			if (war[i] != null)
				this.nombreGuerrierEnVie ++;
		}
	}
	
	public String getNom(){
		return this.nom;
	}
	
	//sert pour les tests
	public Guerrier[] getWarList(){
		return this.war;
	}
	
	//donne le nombre de guerrier en vie dans l equipe
	public int nombreGuerriersEnJeu(){
		return nombreGuerrierEnVie;
	}
	
	//recherche un guerrier de maniere sequentielle pour trouver sa place dans l equipe
	private int trouverIndice(Guerrier guerrier){
		for (int i = 0; i < this.nombreGuerrierEnVie; i++) {
			if(this.war[i]==guerrier)
				return i;
		}
		return -1;
	}
	
	//verifie qu'un guerrier est present (et donc en vie)
	public boolean estPresent(Guerrier guerrier){
		if (trouverIndice(guerrier) != -1)
			return true;
		return false;
	}
	
	//ajoute un guerrier a son equipe 
	public boolean mettreEnJeu(Guerrier guerrier){		
		if (estPresent(guerrier)){
			System.out.println("Le guerrier fait deja partie de l'equipe");
	        return false;
	    }
	         
	    if (this.nombreGuerrierEnVie >= 5){
	    	System.out.println("Vous avez atteint la limite de guerrier.(5)");
	        return false;
	    }
	         
	    if(this.nombreGuerrierEnVie == 0){
	    	this.war[this.nombreGuerrierEnVie] = guerrier;
	        this.nombreGuerrierEnVie ++;
	        return true;
	    }
	         
	    else{
	    	this.war[this.nombreGuerrierEnVie] = guerrier;
	        this.nombreGuerrierEnVie ++;
	        this.war = Utilitaires.trierTableAlphabetique(this.war);
	        return true;
	    }
	}
	
	//permet au joueur de selectionner un guerrier en donnant le nom de celui-ci
	public Guerrier selectionner(String nomGuerrier){
		Guerrier warrior;
		for (int i = 0; i < nombreGuerrierEnVie; i++){
			warrior = war[i];
			if(warrior.getNom().compareTo(nomGuerrier) == 0)
				return warrior;
		}
		System.out.println("Vous ne possedez aucun guerrier de ce nom.");
		return null;
	}
	
	//retire le guerrier de la table
	public boolean mourir(Guerrier guerrier){
		if(nombreGuerrierEnVie == 0) 
			return false;
		
		if(!estPresent(guerrier))
			return false;
		
		else{
			for (int i = 0; i<nombreGuerrierEnVie; i++){
				if (war[i] == guerrier){
					for(int j = i; j<nombreGuerrierEnVie-1; j++){
						war[j] = war[j+1];
					}
					nombreGuerrierEnVie --;
					return true;
				}
			}
			return false;
		}
	}
	
	//renvoie une table avec les guerriers une force equivalente.
	public Guerrier[] tableGuerriersSelonForce(int force){
		int taille = 0;
		int position = 0;
		for(int i = 0; i < this.nombreGuerrierEnVie; i++){
			if (this.war[i].donnerForceDeFrappe() >= force)
				taille ++;
		}
		
		if(taille == 0){
			System.out.println("Vous n'avez pas de guerrier possedant au moins cette force.");
			return null;
		}
		
		else{
			Guerrier[] aRenvoyer = new Guerrier[taille];
			for (int j=0; j < this.nombreGuerrierEnVie; j++){
				if(this.war[j].donnerForceDeFrappe() >= force){
					aRenvoyer[position] = war[j];
					position ++;
				}
			}
		aRenvoyer = Utilitaires.trierTableVie(aRenvoyer);
		return aRenvoyer;
		}
	}
	
	//renvoie une table avec les guerriers possedant les privileges passe en parametre.
	public Guerrier[] tableGuerriersAvecPrivileges(int[] privileges){
		int taille = 0;
		int position = 0;
		for(int i = 0; i < this.nombreGuerrierEnVie; i++){
			if(this.war[i].possedeTous(privileges))
				taille++;
		}
		if (taille == 0){
			System.out.println("Vous ne possedez aucun guerrier possedant ces privileges.");
			return null;
		}
		else{
			Guerrier[] aRenvoyer = new Guerrier[taille];
			for(int j = 0; j < this.nombreGuerrierEnVie; j++){
				if(this.war[j].possedeTous(privileges)){
					aRenvoyer[position] = this.war[j];
					position ++;
				}
			}
			return aRenvoyer;
		}
	}
	
	//renvoie une table avec les guerriers ne possedants pas les privileges passe en parametre.
	public Guerrier[] tableGuerriersSansPrivileges(int[] privileges){
		int taille = 0;
		int position = 0;
		for(int i = 0; i < this.nombreGuerrierEnVie; i++){
			if(this.war[i].possedeAucun(privileges))
				taille++;
		}
		if (taille == 0){
			System.out.println("Vous ne possedez aucun guerrier ne possedant pas ces privileges.");
			return null;
		}
		else{
			Guerrier[] aRenvoyer = new Guerrier[taille];
			for(int j = 0; j < this.nombreGuerrierEnVie; j++){
				if(this.war[j].possedeAucun(privileges)){
					aRenvoyer[position] = this.war[j];
					position ++;
				}
			}
			return aRenvoyer;
		}
	}
	
	//affiche la liste des guerriers
	public String toString(){
		if(this.nombreGuerrierEnVie == 0)
			return"Tout vos guerriers sont morts.";
		String aRenvoyer = "\nLes guerriers :";
		for (int i = 0; i < nombreGuerrierEnVie; i++)
			aRenvoyer = aRenvoyer + "\n    " + this.war[i];
		return aRenvoyer;
	}
}