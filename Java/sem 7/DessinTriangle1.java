/**
 * 
 * @author Janssens Thibaut - IPL - 27/10/2015
 *
 */
public class DessinTriangle1 {
	public static void main(String[] args) {
		//TO MODIFY
		int start = 4;
		int end = 10;
		int i = start;
		while (i != end) {
			construireDessin(i);
			i++;
			System.out.println();
		}
	}
	
	private static void construireDessin(int n) {
		for (int i=0;i<n;i++){
   			construireUneLigne(i);
   			System.out.println();
   		}
	}
	
	private static void construireUneLigne(int n) {
		for (int i=0;i<n+1;i++)
				System.out.print("x");
	}
}
