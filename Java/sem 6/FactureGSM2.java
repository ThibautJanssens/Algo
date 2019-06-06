/**
 * 
 * @author Janssens Thibaut - IPL - 20/10/2015
 * 
 */
import java.util.Scanner;
 
public class FactureGSM2 {
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		int tarifAvant19H, tarifApres19H;
		int nbreAppels;
		double facture;
    
		System.out.println("Entrez le tarif avant 19h.");
		tarifAvant19H = Utilitaires.lireEntierPositif();
		System.out.println("Entrez le tarif après 19h.");
		tarifApres19H = Utilitaires.lireEntierPositif();
		System.out.println("Entrez le nombre d'appels.");
		nbreAppels = Utilitaires.lireEntierPositif();
		facture = Utilitaires.calculFacture(nbreAppels, tarifAvant19H, tarifApres19H);
		System.out.println("Vous devez payer " + facture/100.0 + "Euros");
	}
}