    public class TestDate{
   	
      public static java.util.Scanner scanner = new java.util.Scanner(System.in);
   
   // année comprise entre 1901 et 2099
	// Dans cette tranche d'années, une année est bissextile ssi elle est divisible par 4
       private static boolean estBissextile(int annee){
         return (annee%4==0);
      }
   
   // année comprise entre 1600 et 3000
	// Une année est bissextile si :
	//	 	- elle est divisible par 4 mais n'est pas une année de siècle
	//	ou si
	//	 	- elle est divisible par 400
	       private static boolean estBissextile2(int annee){
	    	  return ((annee%400==0)||(annee%4==0 && annee%100!=0));
      }
      	
   
   
   // date1 (jour1 mois1 annee1) est antérieure à date2 (jour2 mois2 annee2)
       private static boolean estAnterieure(int jour1, int mois1, int annee1, int jour2, int mois2, int annee2 ){
         return ((annee1 < annee2) || (annee1 == annee2 && mois1 < mois2) || (annee1 == annee2 && mois1 == mois2 && jour1 < jour2));
      }
   
   
   
       public static void main(String [] args){
      
         int choix;			
         do{
            System.out.println();
            System.out.println("1 -> Tester la méthode estBissextile");
            System.out.println("2 -> Tester la méthode estBissextile2");
            System.out.println("3 -> Tester la méthode estAnterieure");
            System.out.println("Entrez votre choix :");
            choix=scanner.nextInt();
            switch(choix){
               case 1: testEstBissextile(); 
                  break;
               case 2: testEstBissextile2(); 
                  break;
               case 3: testEstAnterieure(); 
                  break;
            
            }	
         }while(choix >=1 && choix<=3);
      }
   
   
   
   
       private static void testEstBissextile(){
         if(!estBissextile(2000)){
            System.out.println("Attention test : 2000 a échoué");
            return;
         }
         if(estBissextile(2001)){
            System.out.println("Attention test : 2001 a échoué");
            return;
         }
         System.out.println("Tous les tests ont réussi!");
      
      }
   
       private static void testEstBissextile2(){
         if(!estBissextile2(2000)){
            System.out.println("Attention test : 2000 a échoué");
            return;
         }
         if(!estBissextile2(2004)){
            System.out.println("Attention test : 2004 a échoué");
            return;
         }
         if(estBissextile2(2001)){
            System.out.println("Attention test : 2001 a échoué");
            return;
         }
         if(estBissextile2(1900)){
            System.out.println("Attention test : 1900 a échoué");
            return;
         }
         if(estBissextile2(2100)){
            System.out.println("Attention test : 2100 a échoué");
            return;
         }
         System.out.println("Tous les tests ont réussi!");
      
      }
   
          
       private static void testEstAnterieure(){
      
         if(!estAnterieure(31,12,2011,1,1,2012)){
            System.out.println("Attention test : 31 12 2011 1 1 2012 a échoué");
            return;
         }
         if(!estAnterieure(15,9,2011,15,10,2011)){
            System.out.println("Attention test : 15 9 2011 15 10 2011 a échoué");
            return;
         }
         if(!estAnterieure(15,9,2011,16,9,2011)){
            System.out.println("Attention test : 15 9 2011 16 9 2011 a échoué");
            return;
         }
         if(estAnterieure(1,1,2012,31,12,2011)){
            System.out.println("Attention test :  1 1 2012 31 12 2011a échoué");
            return;
         }
         if(estAnterieure(15,10,2011,15,9,2011)){
            System.out.println("Attention test :  15 10 2011 15 9 2011a échoué");
            return;
         }
         if(estAnterieure(16,9,2011,15,9,2011)){
            System.out.println("Attention test : 16 9 2011 15 9 2011 a échoué");
            return;
         }
         if(estAnterieure(15,9,2011,15,9,2011)){
            System.out.println("Attention test : 15 9 2011 15 9 2011 a échoué");
            return;
         }
         System.out.println("Tous les tests ont réussi!");
      
      }
   
   
   }