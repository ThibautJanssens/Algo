
public class Groupes {
	private String nom,nationnalite,style,hitSong;
	private int anneeFormation;
	
	public Groupes(String nom, int anneeFormation, String nationnalite, String style, String hitSong){
		this.nom = nom;
		this.anneeFormation = anneeFormation;
		this.nationnalite = nationnalite;
		this.style = style;
		this.hitSong = hitSong;
	}

	public String getNom() {
		return nom;
	}
	
	public String getNationnalite() {
		return nationnalite;
	}
	
	public String getStyle() {
		return style;
	}
	
	public String getHitSong() {
		return hitSong;
	}
	
	public int getAnneeFormation() {
		return anneeFormation;
	}
	
	public String toString(){
		String res = "";
		return res;
	}	
}
