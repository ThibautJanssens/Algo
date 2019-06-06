/**
 * 
 * @author Janssens Thibaut - IPL 6/10/15
 *
 */
public class C3 {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);	
	
	public static void main(String[] args) {
		char reponse;
		
		System.out.println("Trouvez le signe manquant de l'opération.");
		
		//test du +
		System.out.println("5 ? 4 = 9");
		reponse =lireCharPlusMoinsEgal();
		
		while (reponse != '+'){
			System.out.println("Faux.");
			System.out.println("5 ? 4 = 9");
			reponse =lireCharPlusMoinsEgal();
		}
		System.out.println("Correct.");
		
		//test du -
		System.out.println("9 ? 5 = 9");
		reponse = lireCharPlusMoinsEgal();
		
		while (reponse != '-'){
			System.out.println("Faux.");
			System.out.println("9 ? 5 = 9");
			reponse = lireCharPlusMoinsEgal();
		}
		System.out.println("Correct.");
		
		// test du =
		System.out.println("a(b+c) ? (ab + ac)");
		reponse = lireCharPlusMoinsEgal();
		
		while (reponse != '='){
			System.out.println("Faux");
			System.out.println("a(b+c) ? (ab + ac)");
			reponse = lireCharPlusMoinsEgal();
		}
		System.out.println("Correct.");
	}
	
	public static char lireCharPlusMoinsEgal(){
		char reponse = ' ';
		
		while (reponse != '+' || reponse != '-' || reponse != '='){
			System.out.println("Plus, moins ou égal? (+/-/=)");
			reponse = scanner.next().charAt(0);
			if(reponse == '+' || reponse == '-' || reponse == '=')
				return reponse;
		}
		return reponse;
	}
}
