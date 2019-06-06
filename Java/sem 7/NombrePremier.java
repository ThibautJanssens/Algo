/**
 * 
 * @author Janssens Thibaut - IPL - 27/10/2015
 *
 */
public class NombrePremier {
	public static void main(String[] args) {
		int[] t = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
		int n = countPrimeNumber(t);
		System.out.println(n);
	}
	
	private static int countPrimeNumber(int[] t) {		
		int compteur = 0;
		for (int i = 0; i < t.length; i++) {
			if (isPrime(t[i]))
				compteur ++;
		}
		return compteur;
	}
	
	private static boolean isPrime(int n) {
		if(n<=1) return false;
        for(int i = 2;i*i<=n;i++)
        {
            if (n%i == 0)
            return false;
        }
        return true;
	}
}
