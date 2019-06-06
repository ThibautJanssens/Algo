/**
 * 
 * @author Janssens Thibaut - IPL - 27/10/2015
 *
 */
public class B1 {
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	public static void main(String[] args) {
		int tableDeMultiplicationDe, reponseCorrecte, reponseEleve, terme=1;

		tableDeMultiplicationDe = unEntierAuHasardEntre(1,10);
		System.out.println("Vous etes sur le point de faire la table de multiplication de "+ tableDeMultiplicationDe);
		reponseCorrecte = 0;
		reponseEleve = 0;
		while (reponseEleve == reponseCorrecte && terme <= 10){
			System.out.println(terme +"x" + tableDeMultiplicationDe + "=");
			reponseCorrecte = terme*tableDeMultiplicationDe;
			reponseEleve = scanner.nextInt();
			terme++;
		}
		if(reponseEleve != reponseCorrecte)
			System.out.println("Non la bonne reponse etait " + reponseCorrecte);
		else
			System.out.println("Félicitation!");
   }
	public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
		double nombreReel;
		int resultat;

		nombreReel = Math.random();
		resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
		return resultat;
	}
}