/**
 * 
 * @author Janssens Thibaut - IPL - 27/10/2015
 *
 */
public class DessinLosange {
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
		construirePartieSuperieure(n);
   		construirePartieInferieure(n);
	}
	
	private static void construirePartieSuperieure(int n) {
		for (int i=0;i<n;i++){
   			for (int j=0;j<n-i;j++){
   				System.out.print("x");
   			}
   			for (int k=0;k<i*2;k++){
   				System.out.print(" ");
   			}
   			for (int l=0;l<n-i;l++){
   				System.out.print("x");
   			}
   			System.out.println();
   		}
	}
	
	private static void construirePartieInferieure(int n) {
		for (int m=n-1;m>=0;m--){
   			for (int q=0;q<n-m;q++){
   				System.out.print("x");
   			}
   			for (int o=0;o<m*2;o++){
   				System.out.print(" ");
   			}
   			for (int p=0;p<n-m;p++){
   				System.out.print("x");
   			}
   			System.out.println();
   		}
	}
}
