
public class TestDate2016 {



	public static void main(String args[]){
		
		Date2016 date;
		
		System.out.println("Test constructeur a 1 parametre");
		try {
			date = new Date2016(367);
			System.out.println(date);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		try {
			date = new Date2016(367);
			System.out.println(date);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		date = new Date2016(1);
		System.out.println(date);
		date = new Date2016(31);
		System.out.println(date);
		date = new Date2016(32);
		System.out.println(date);
		date = new Date2016(366);
		System.out.println(date);
		
		
		System.out.println("\nTest methode donnerJourSuivant");
		try {
			date = new Date2016(366);
			System.out.println(date.donnerJourSuivant());
		} catch (DateHors2016Exception e) {
			System.out.println(e);
		}
		date = new Date2016(1);
		System.out.println(date.donnerJourSuivant());
		date = new Date2016(31);
		System.out.println(date.donnerJourSuivant());
		date = new Date2016(365);
		System.out.println(date.donnerJourSuivant());
		
		//A COMPLETER
	}

}
