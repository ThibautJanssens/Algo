
public class Creatures extends Cartes{
	private String nom;
	private int nbrePointsDegats, nbrePointsDeVie;
	
	public Creatures(String nom, int nbrePointsDeVie, int nbrePointsDegats, int cout){
		super(cout);
		if (this.nbrePointsDeVie < 0 || this.nbrePointsDegats < 0) throw new IllegalArgumentException();
		this.nom = nom;
		this.nbrePointsDegats = nbrePointsDegats;
		this.nbrePointsDeVie = nbrePointsDeVie;
	}
	
	public Creatures(String nom,int cout){
		this(nom, 0, 0, 0);
	}
	
	public String getNom() {
		return nom;
	}
	public int getNbrePointsDegats() {
		return nbrePointsDegats;
	}
	public int getNbrePointsDeVie() {
		return nbrePointsDeVie;
	}
	
	public String afficher(){
		return "Creature - cout:"+super.getCout()+" - nom:"+getNom()+"("+getNbrePointsDegats()+"/"+getNbrePointsDeVie()+")";
	}
}