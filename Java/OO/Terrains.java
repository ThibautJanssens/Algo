
public class Terrains extends Cartes{
	private final char[] COULEURS = {'B','b','n','r','v'};
	private char couleur;
	
	public Terrains(char couleur){
		super(0);		
		if (couleur != 'B' && couleur != 'b' && couleur != 'n' && couleur != 'r' && couleur != 'v')
			this.couleur = 'i';
		else
			this.couleur = couleur;
	}

	public char getCouleur() {
		return couleur;
	}
	
	public String afficher(){
		return "Terrain - cout:"+super.getCout()+" - couleur:"+getCouleur();
	}
}