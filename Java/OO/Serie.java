
public class Serie {
	private char nom;
	private Etudiant delegue;
	
	public Serie(char nom) {
		this.nom = nom;
		this.delegue = null;
	}
	
	public void elireDelegue(Etudiant etudiant){ 
		if (etudiant == null)throw new IllegalArgumentException("Entrer un �tudiant valide.");
		if (etudiant.getSerie() != this)throw new IllegalArgumentException("Etudiant de la mauvaise s�rie.");
		if (this.delegue != null)throw new IllegalArgumentException("La s�rie poss�de d�j� un d�l�gu�.");
		else{
			this.delegue = etudiant;
		}
	}

	public char getNom() {
		return this.nom;
	}

	public Etudiant getDelegue() {
		return this.delegue;
	}
	
	public String toString() {
		return "Dans la s�rie " + nom;
	}
}
