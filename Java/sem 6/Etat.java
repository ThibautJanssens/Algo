/**
 * 
 * @author Janssens Thibaut - IPL - 20/10/2015
 *
 */
public class Etat {
	private static int[] nbreJetons;	// 0 = blanc	1 = noir  
	private static int[] plateau;   // 0 = blanc    1 = noir   -1 = vide
	private static int joueur;		// 0 = blanc      1 = noir
	private static final String[] COULEURS = {"blanc","noir"};
	
	public Etat(int nbreJetons, int nbreCases) {
		if(nbreJetons*2>nbreCases)throw new IllegalArgumentException("plus de jetons que de cases");
		this.nbreJetons = new int[2];
		this.nbreJetons[0] = nbreJetons;
		this.nbreJetons[1] = nbreJetons;
		this.joueur = 0;
		this.plateau = new int[nbreCases];
		for (int i = 0; i < nbreJetons*2; i++) {
			this.plateau[i]=i%2;
		}
		for (int i = nbreJetons*2; i < this.plateau.length; i++) {
			this.plateau[i] = -1;
		}
	}
	
	public String joueurCourant(){
		return COULEURS[this.joueur];
	}
	
	public String joueurAdverse(){
		return COULEURS[(this.joueur+1)%2];
	}
	public void changerJoueur(){
		joueur = (joueur+1)%2;
	}
	
	public boolean estValide(int numeroCase){
		if(numeroCase < 0 || numeroCase >= plateau.length) throw new IllegalArgumentException("hors plateau");
		if (this.plateau[numeroCase] != joueur)
			return false;
		return true;
	}
	
	public boolean jouer(int numeroCase, int lancerDe){
		if(!estValide(numeroCase)){
			return false;
		}
		if(nbreJetons[this.joueur] == 0){
			return false;
		}
		this.plateau[numeroCase] = -1;
		if (numeroCase + lancerDe >= plateau.length){
			plateau[plateau.length-1] = this.joueur;
			return true;
		}
		else
			if(this.plateau[numeroCase + lancerDe] == (this.joueur+1)%2){
				nbreJetons[(this.joueur+1)%2]--;
				this.plateau[numeroCase+lancerDe] = this.joueur;
				return true;
			}
			if (this.plateau[numeroCase+lancerDe] == (this.joueur)){
				nbreJetons[this.joueur] --;
				this.plateau[numeroCase+lancerDe] = this.joueur;
				return true;
			}
			else{
				this.plateau[numeroCase + lancerDe] = this.joueur;
				return true;
		}
	}
	
	public boolean estEtatFinal(){
		if(nbreJetons[this.joueur] == 0 )
			return true;
		if(this.plateau[plateau.length-1]!=-1)
			return true;
		return false;
	}

	public String toString(){
		String aRenvoyer = "";
		for (int i = 0; i < plateau.length; i++) {
			aRenvoyer+="\n" + i + " : " ;
			if(this.plateau[i]!=-1)
				aRenvoyer+=COULEURS[this.plateau[i]];
		}
		aRenvoyer +="\njoueur --> "+COULEURS[this.joueur];
		return aRenvoyer;
	}
}
