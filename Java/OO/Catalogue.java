import java.util.ArrayList;

public class Catalogue {
	private ArrayList<Livres> livres;

	public Catalogue() {
		livres = new ArrayList<Livres>();
	}

	public boolean contient(Livres livre){
		if (livre == null)throw new IllegalArgumentException("Veuillez entrer un livre valide.");
		return livres.contains(livre);
	}
	
	public void ajouter(Livres livre){
		if (livre == null)throw new IllegalArgumentException("Veuillez entrer un livre valide.");
		if (contient(livre))
			System.out.println("Ce livre est déjà dans le catalogue.");
		else
			livres.add(livre);
	}
	
	public void supprimer(Livres livre){
		if (livre == null)throw new IllegalArgumentException("Veuillez entrer un livre valide.");
		if (!contient(livre))
			System.out.println("Votre livre n'est pas dans le catalogue.");
		else
			livres.remove(livre);
	}
	
	public int nombreLivres(){
		return livres.size();
	}
	
	public boolean estVide(){
		return livres.isEmpty();
	}
	
	public Livres recuperer(String isbn){
		if (isbn == null || isbn == " ")throw new IllegalArgumentException("Veuillez entrer un isbn valide.");
		return livres.get(isbn.hashCode());
	}
	
	public String toString() {
		return livres.toString();
	}
}
