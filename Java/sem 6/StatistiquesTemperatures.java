/**
 * 
 * @author Janssens Thibaut - IPL - 20/10/2015
 *
 */
public class StatistiquesTemperatures {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	public static Temperatures temperatures;
	
	public static void main(String[] args) {
		chargerTemperatures();
		//System.out.println(temperatures.toString());
		int choix;
		System.out.println("******************************************");
		System.out.println("Programme Test pour la classe Temperatures");
		System.out.println("******************************************");
		do{
			System.out.println();
			System.out.println("1 -> Tester la methode get temperature");
			System.out.println("2 -> Tester la methode moyenne");
			System.out.println("3 -> Tester la methode temperatureMax");
			System.out.println("4 -> Tester la methode temperatureMin");
			System.out.println("5 -> Tester la methode nombreJoursDeGel");
			System.out.println("6 -> Tester la methode joursDeGel");
			System.out.println("7 -> Tester la methode joursMax");
			System.out.println("8 -> Tester la methode joursMin");
			System.out.print("\nEntrez votre choix : ");
			choix=scanner.nextInt();
			switch(choix){
				case 1: verifierGetTemperature(); break;
				case 2: verifierMoyenne(); break;
				case 3: verifierTemperatureMax(); break;
				case 4: verifierTemperatureMin(); break;
				case 5: verifierNombreJoursDeGel(); break;
				case 6:	verifierJoursDeGel(); break;
				case 7: verifierJoursMax(); break;
				case 8: verifierJoursMin(); break;
				}
			}while(choix >=1&&choix<=8);
			System.out.println("Merci pour votre visite.");
		}
	private static void verifierGetTemperature(){
		boolean tousReussis = true;
		double temperature1, temperature2;
		temperature1 = temperatures.getTemperature(14);
		
		if(temperature1 != 5.0){
			System.out.print("\nAttention! Test 1.1 ko : votre methode a trouve la  "+ temperature1);
			tousReussis = false;
		}
		
		temperature2 = temperatures.getTemperature(8);
		if (temperature2 != 0){
			System.out.println("\nAttention! test 1.2 : votre methode a trouve la "+ temperature2);
			tousReussis = false;
		}
		
		if(tousReussis)
			System.out.println("Tous les tests ont reussi.");
	}
	
	
	private static void verifierMoyenne(){
		boolean tousReussis = true;
		int moyenne;
		moyenne = (int)temperatures.moyenne();
		
		if(moyenne != 1){
			System.out.print("\nAttention! Test 2 ko : votre methode a trouve la moyenne "+ moyenne);
			tousReussis = false;
		}
		if(tousReussis)
			System.out.println("Tous les tests ont reussi.");
	}
	
	private static void verifierTemperatureMax(){
		boolean tousReussis = true;
		double temperatureMax;
		temperatureMax = temperatures.temperatureMax();
		
		if (temperatureMax != 5.0){
			System.out.println("\nAttention! Test 3 ko : votre methode a trouve comme temperature maximal "+temperatureMax);
			tousReussis = false;
		}
		if(tousReussis)
			System.out.println("Tous les tests ont reussi.");
	}
	
	private static void verifierTemperatureMin(){
		boolean tousReussis = true;
		double temperatureMin;
		temperatureMin = temperatures.temperatureMin();
		
		if(temperatureMin != -3.0){
			System.out.print("\nAttention! Test 4 ko : votre methode a trouve comme temperature minimal "+ temperatureMin);
			tousReussis = false;
		}
		if(tousReussis)
			System.out.println("Tous les tests ont reussi.");
	}
	
	private static void verifierNombreJoursDeGel(){
		boolean tousReussis = true;
		int nombreJoursDeGel;
		nombreJoursDeGel = (int)temperatures.nombreJoursDeGel();
		
		if(nombreJoursDeGel != 7){
			System.out.print("\nAttention! Test 5 ko : votre methode a trouve comme nombre de jours de gel "+ nombreJoursDeGel );
			tousReussis = false;
		}
		if(tousReussis)
			System.out.println("Tous les tests ont reussi.");
	}
	
	private static void verifierJoursDeGel(){
		boolean tousReussis = true;
		//{ 0,1,2,3, 4, 5, 6, 7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30 
		//{-1,1,0,1,-1,-3,-3,-2,0,-1,0, 1, 1, 3, 5, 4, 2, 0, 1, 1, 5, 3, 2 ,0,-1, 0, 1, 1, 3, 4, 5}
		int[] tableCorrecte = {0,4,5,6,7,9,24};
		int[] tableATestee = temperatures.joursDeGel();
		if(tableATestee.length != tableCorrecte.length){
			System.out.print("\nAttention! Test 6.1 ko : votre methode n'a pas la bonne taille de tableau: "+ tableATestee.length);
			tousReussis = false;
		}
		else
			for (int i=0;i<tableATestee.length;i++){
				if (tableATestee[i] != tableCorrecte[i]){
					System.out.println("\nAtention! Test 6.2 ko : votre methode n'a pas un tableau correcte.");
					tousReussis = false;
				}
			}
		if(tousReussis)
			System.out.println("Tous les tests ont reussi.");
	}
	
	private static void verifierJoursMax(){
		boolean tousReussis = true;
		//{ 0,1,2,3, 4, 5, 6, 7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30 
		//{-1,1,0,1,-1,-3,-3,-2,0,-1,0, 1, 1, 3, 5, 4, 2, 0, 1, 1, 5, 3, 2 ,0,-1, 0, 1, 1, 3, 4, 5}
		int[] tableCorrecte = {14,20,30};
		int[] tableATestee = temperatures.joursMax();

		if(tableATestee.length != tableCorrecte.length){
			System.out.print("\nAttention! Test 7.1 ko : votre methode n'a pas la bonne taille de tableau: "+ tableATestee.length);
			tousReussis = false;
		}
		else
			for (int i=0;i<tableATestee.length;i++){
				if (tableATestee[i] != tableCorrecte[i]){
					System.out.println("\nAtention! Test 7.2 ko : votre methode n'a pas un tableau correcte.");
					tousReussis = false;
				}
			}
		if(tousReussis)
			System.out.println("Tous les tests ont reussi.");
	}
	
	private static void verifierJoursMin(){
		boolean tousReussis = true;
		//{ 0,1,2,3, 4, 5, 6, 7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30 
		//{-1,1,0,1,-1,-3,-3,-2,0,-1,0, 1, 1, 3, 5, 4, 2, 0, 1, 1, 5, 3, 2 ,0,-1, 0, 1, 1, 3, 4, 5}
		int[] tableCorrecte = {5,6};
		int[] tableATestee = temperatures.joursMin();


		if(tableATestee.length != tableCorrecte.length){
			System.out.print("\nAttention! Test 8.1 ko : votre methode n'a pas la bonne taille de tableau: "+ tableATestee.length);
			tousReussis = false;
		}
		else
			for (int i=0;i<tableATestee.length;i++){
				if (tableATestee[i] != tableCorrecte[i]){
					System.out.println("\nAtention! Test 8.2 ko : votre methode n'a pas un tableau correcte.");
					tousReussis = false;
				}
			}
		if(tousReussis)
			System.out.println("Tous les tests ont reussi.");
	}
	
	public static void chargerTemperatures(){
		double[]tableTemperatures = {-1,1,0,1,-1,-3,-3,-2,0,-1,0,1,1,3,5,4,2,0,1,1,5,3,2,0,-1,0,1,1,3,4,5};
		temperatures = new Temperatures("janvier",tableTemperatures);
	}
	
}
