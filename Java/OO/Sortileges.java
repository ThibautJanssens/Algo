
public class Sortileges extends Cartes{
	private String nom, description;
	
	public Sortileges (String nom, int cout, String description){
		super(cout);
		this.nom = nom;
		this.description = description;
	}

	public String getNom() {
		return nom;
	}

	public String getDescription() {
		return description;
	}
	
	public String afficher(){
		return "Sortilege - cout:"+super.getCout()+" - nom:"+getNom();
	}
}