/**
 * 
 * @author JANSSENS Thibaut - IPL - 23/11/15
 *
 */
	public class QuickSort {
		
		public static void main(String[] args) {
			int[] tableau = new int[20];
			for (int i=0; i<20; i++){
				tableau[i]= (int) (Math.random()*100);
			}
			afficher(tableau);
			quickSort(tableau,0,tableau.length-1);  
			afficher(tableau);  
		}

		public static void quickSort(int[] tableau, int debut, int fin){
			if (fin > debut) {
				int indicePivot = partition (tableau,debut,fin);
				quickSort(tableau, debut, indicePivot-1);
				quickSort(tableau, indicePivot+1, fin);
			}
		}
		
		// renvoie l'indice du point de separation et a pour "effet de bord" de reorganiser la table autour de ce point 
		// en pla�ant a cet indice un certain element appele � pivot �, 
		// avant lui tous les elements inferieurs a ce pivot et 
		// apres lui tous les elements superieurs a ce pivot 
		// (les eventuels elements egaux a la valeur du pivot pouvant etre au choix d'un cote ou de l'autre)
		
		private static int partition (int[] t, int debut, int fin) {
			 int tmp;
	         int pivot=t[debut];
	         while (debut<fin){
	            while(t[debut]<pivot){
	            debut++;
	            }
	            while(t[fin]>pivot){
	            fin--;
	            }
	            if (debut<fin){
	            tmp=t[debut];
	            t[debut]=t[fin];
	            t[fin]=tmp;
	            }
	         }
	         afficher(t);
	         return debut;
		}

		private static void afficher(int[] tableau){
			for (int i = 0; i<tableau.length; i++){
				System.out.print(tableau[i]+" ");
			}
			System.out.println();
		}
}
