/**
 * 
 * @author Janssens Thibaut IPL - 21/09/15
 * @version 21/09/15
 *
 */
public class C1 {
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	
	public static void main(String[] args) {
		
		double coteExamenAlgo, coteExamenIOO;
		
		System.out.println("Quelle est la cote de l'élève (/20) en algo?");
		coteExamenAlgo = scanner.nextDouble();
		System.out.println("Quelle est la cote de l'élève (/20) en IOO?");
		coteExamenIOO = scanner.nextDouble();
		
		if(coteExamenAlgo == coteExamenIOO)
			System.out.println("L'élève a la même cote dans les deux cours. "+coteExamenAlgo+"/20");
		else{
			if (coteExamenAlgo>coteExamenIOO)
				System.out.println("La plus grand cote de l'élève est "+coteExamenAlgo+"/20 en algo.");
			else
				System.out.println("La plus grand cote de l'élève est "+coteExamenIOO+"/20 en IOO.");
		}
		
	}
}
