/**
 * 
 * @author Janssens Thibaut IPL - 21/09/15
 * @version 21/09/15
 *
 */
public class C2 {
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	
	public static void main(String[] args) {
		
		double coteExamenAlgo, coteExamenIOO, coteExamenAnglais;
		
		System.out.println("Quelle est la cote de l'élève (/20) en algo?");
		coteExamenAlgo = scanner.nextDouble();
		System.out.println("Quelle est la cote de l'élève (/20) en IOO?");
		coteExamenIOO = scanner.nextDouble();
		System.out.println("Quelle est la cote de l'élève (/20) en Anglais");
		coteExamenAnglais = scanner.nextDouble();
		
		if(coteExamenAlgo == coteExamenIOO && coteExamenAnglais == coteExamenAlgo)
			System.out.println("L'élève a la même cote dans les trois cours. "+coteExamenAlgo+"/20");
		else{
			if (coteExamenAlgo>coteExamenIOO && coteExamenAlgo == coteExamenAnglais)
				System.out.println("L'élève a sa meilleure cote dans deux cours "+coteExamenAlgo+"/20 en Anglais et en algo.");
			else{
				if (coteExamenAlgo == coteExamenIOO && coteExamenAlgo > coteExamenAnglais)
					System.out.println("L'élève a sa meilleure cote dans deux cours "+coteExamenAlgo+"/20 en IOO et en algo.");
				else{
					if (coteExamenAlgo>coteExamenIOO && coteExamenAlgo > coteExamenAnglais)
						System.out.println("La plus grand cote de l'élève est "+coteExamenAlgo+"/20 en algo.");
					else{
						if (coteExamenIOO > coteExamenAnglais)
							System.out.println("La plus grande cote de l'élève est "+coteExamenIOO+"/20 en IOO.");
						else{					
							if (coteExamenIOO == coteExamenAnglais)
								System.out.println("L'élève a sa meilleure cote dans dezux cours "+coteExamenIOO+"/20 en IOO et en Anglais.");
							else
								System.out.println("La plus grande cote de l'élève est "+coteExamenAnglais+"/20 en Anglais.");
						}
					}
				}
			}
		}
	}
}
