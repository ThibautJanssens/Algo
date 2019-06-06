import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.HashMap;
public class Commande {
	private ArrayList<Articles> articles;
	private LocalDate date;
	
	public Commande(){
		date = LocalDate.now();
		articles = new ArrayList<Articles>();
		
		//TODO initialiser l'arraylist
	}
	
	public String toString(){
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		String resultat = date.format(formatter)+" \n";
		//TODO ajouter la liste des articles à la chaîne de caractères ainsi que le prix total
		
		return resultat;
	}
}
