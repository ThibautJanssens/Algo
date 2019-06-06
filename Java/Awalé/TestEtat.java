// Thibaut Janssens :
// Sébastien Place :
public class TestEtat {
	public static void main(String args[]){
		
		// test egrene()
		int [] c = {0,0};
		
		// test 1
		int[]p1 = {4,0,0,0,0,0,0,0,0,0,0,0};
		Etat e1 = new Etat(0,p1,c);
		try{
			int trou = e1.egrene(-1);
			System.out.println("plateau apres egrenage "+ e1);
			System.out.println("trou renvoye "+trou);
		}catch (IllegalArgumentException e){
			System.out.println("IllegalArgumentException "+ e.toString());
		}
		
		// test 2
		int[]p2 = {4,0,0,0,0,0,0,0,0,0,0,0};
		Etat e2 = new Etat(0,p2,c);
		try{
			int trou = e2.egrene(12);
			System.out.println("plateau apres egrenage "+ e2);
			System.out.println("trou renvoye "+trou);
		}catch (IllegalArgumentException e){
			System.out.println("IllegalArgumentException "+ e.toString());
		}
		// test 3
		int[]p3 = {4,0,0,0,0,0,0,0,0,0,0,0};
		Etat e3 = new Etat(0,p3,c);
		try{
			int trou = e3.egrene(2);
			System.out.println("plateau apres egrenage "+ e3);
			System.out.println("trou renvoye "+trou);
		}catch (IllegalArgumentException e){
			System.out.println("IllegalArgumentException "+ e.toString());
		}

		// test 4
		int[]p4 = {4,0,0,0,0,0,0,0,0,0,0,0};
		Etat e4 = new Etat(0,p4,c);
		try{
			int trou = e4.egrene(0);
			System.out.println("plateau apres egrenage "+ e4);
			System.out.println("trou renvoye "+trou);
		}catch (IllegalArgumentException e){
			System.out.println("IllegalArgumentException "+ e.toString());
		}
		
		// test 5
		int[]p5 = {0,0,0,0,0,0,0,0,0,0,4,0};
		Etat e5 = new Etat(0,p5,c);
		try{
			int trou = e5.egrene(10);
			System.out.println("plateau apres egrenage "+ e5);
			System.out.println("trou renvoye "+trou);
		}catch (IllegalArgumentException e){
			System.out.println("IllegalArgumentException "+ e.toString());
		}
		
		// test 6
		int[]p6 = {0,14,0,0,0,0,0,0,0,0,0,0};
		Etat e6 = new Etat(0,p6,c);
		try{
			int trou = e6.egrene(1);
			System.out.println("plateau apres egrenage "+ e6);
			System.out.println("trou renvoye "+trou);
		}catch (IllegalArgumentException e){
			System.out.println("IllegalArgumentException "+ e.toString());
		}
	}
}
