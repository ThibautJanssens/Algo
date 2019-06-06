
public class testPersonne {
	public static void main(String[] args) {		
		
		Date date1 = new Date(14,10,1993);
		Date date2 = new Date(2,8,1996);
		Date date3 = new Date(14,2,1995);
		
		Adresse adre1 = new Adresse("Rue du uberskill","160","1930","Zaventem");
		Adresse adre2 = new Adresse("Rue du coucou","69","1200","Bruxelles");
		Adresse adre3 = new Adresse("Rue du Touffu","24","1150","Bruxelles");
		
		Personnes pers1 = new Personnes("Janssens","Bicky",date1,adre1);
		Personnes pers2 = new Personnes("Lespinois","Nicolas",date2, adre2);
		Personnes pers3 = new Personnes("Tircher","Kyrill",date3, adre3);
		
		System.out.println(pers1 + " aura "+pers1.donnerAgeEn2014()+" ans à la fin de cette année(2014), et avait "+pers1.donnerAgeEn(2001)+" ans en 2001.");
		System.out.println(pers2 + " aura "+pers2.donnerAgeEn2014()+" ans à la fin de cette année(2014), et avait "+pers2.donnerAgeEn(2001)+" ans en 2001.");
		System.out.println(pers3 + " aura "+pers3.donnerAgeEn2014()+" ans à la fin de cette année(2014), et avait "+pers3.donnerAgeEn(2001)+" ans en 2001.");
		System.out.println("\nPers 1 déménage.");
		
		//Adresse adre4 = new Adresse("Rue lol","1","1111","Ici");
		pers1.demenager("Rue lol","1","1111","Ici");
		System.out.println(pers1 + " aura "+pers1.donnerAgeEn2014()+" ans à la fin de cette année(2014), et avait "+pers1.donnerAgeEn(2001)+" ans en 2001.");
		pers3.demenager("Rue du uberskill", "160", "1930", "Zaventem");
		System.out.println(pers3 + " aura "+pers3.donnerAgeEn2014()+" ans à la fin de cette année(2014), et avait "+pers3.donnerAgeEn(2001)+" ans en 2001.");
	}
}
