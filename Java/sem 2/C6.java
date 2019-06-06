/**
 * 
 * @author Janssens Thibaut IPL - 21/09/15
 * @version 21/09/15
 *
 */
public class C6 {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	public static void main(String[] args) {
		
		int a, b, c, delta,racineDelta, rep1, rep2;
		
		System.out.println("Calcule de solutions pour équations de type  ax² + bx + c = 0");
		System.out.println("Donnez la valeur de a:");
		a = scanner.nextInt();
		System.out.println("Donnez la valeur de b");
		b = scanner.nextInt();
		System.out.println("Donnez la valeur de c");
		c = scanner.nextInt();
		
		// delta = b²-4ac 
		//delta = ((int)Math.pow(2, b))-(4*a*c);
		delta = (b*b)-(4*a*c);
		System.out.println("Delta = "+delta);
		if (delta < 0)
			System.out.println("Pas de solution.");
		else if(delta == 0){
			//x1 = -b / 2a
			rep1=(0-b) /(2*a);
			System.out.println("Il n'y a que 1 racine qui est x="+rep1);
		}
		else{
			//x1 = (-b - V delta)/2a    x2 = (-b + V delta)/2a 
			racineDelta = (int)Math.sqrt(delta);
			rep1 = ((0-b)-racineDelta)/(2*a);
			rep2 = ((0-b)+racineDelta)/(2*a);
			System.out.println("Il y a 2 racines qui sont x1="+rep1+" et x2="+rep2);
		}
	}
}