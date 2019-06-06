
public class Serie {
	private char nom;
	private Etudiant delegue;
	
	public Serie(char nom) {
		this.nom = nom;
		this.delegue = null;
	}
	
	public void elireDelegue(Etudiant etudiant){ 
		if (etudiant == null)throw new IllegalArgumentException("Entrer un étudiant valide.");
		if (etudiant.getSerie() != this)throw new IllegalArgumentException("Etudiant de la mauvaise série.");
		if (this.delegue != null)throw new IllegalArgumentException("La série possède déjà un délégué.");
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
		return "Dans la série " + nom;
	}
}
