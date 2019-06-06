
public class TestCatalogue {
	
	public static void main(String[] args) {
		Catalogue catalogue = new Catalogue();
		
		if(catalogue.estVide())
			System.out.println("Le catalogue est vide");
		else
			System.out.println(catalogue.nombreLivres());
		
		Livres livre1 = new Livres("978-2754055888","Burd","Barry","Java pour les nuls",466,24.95,2014);
		System.out.println("Ajout livre1");
		catalogue.ajouter(livre1);

		if (!catalogue.contient(livre1))
			System.out.println("Il y a un soucis soit avec la m�thode ajouter, soit avec la m�thode contient.");
		else
			System.out.println(catalogue.contient(livre1) +" (devrait �tre true)");
		
		Livres livre2 = new Livres("978-2290107096","R-R Martin","George","Le tr�ne de fer l'int�grale",1200,20.95,2015);
		System.out.println("Ajout livre2");
		catalogue.ajouter(livre2);

		if(catalogue.nombreLivres()!=2)
			System.out.println("Il y a un probl�me avec la m�thode ajouter ou nombreLivres.");
		else 
			System.out.println("Nombre de livre dans le catalogue:" + catalogue.nombreLivres());
		
		Livres livre3 = new Livres("978-2754055888","Burd","Barry","Java pour les nuls",466,24.95,2014);
		System.out.println("Tentative d'ajout livre3 dans le catalogue.");
		catalogue.ajouter(livre3);
		System.out.println("Nombre de livre dans le catalogue:" + catalogue.nombreLivres());
		System.out.println("Affichage du catalogue: \n" + catalogue);
		
		System.out.println("Tentative de r�cup�ration du livre avec isbn 978-2290107096 :\n"+catalogue.recuperer("978-2290107096"));
		System.out.println("Retrait du livre1 du catalogue:");
		catalogue.supprimer(livre1);
		System.out.println("Nombre de livre dans le catalogue: "+ catalogue.nombreLivres());
	}
}
