
public class TestCompteEnBanque {
	public static void main(String[] args) {
		Date date1 = new Date(14,10,1933);
		Adresse adre1 = new Adresse("Rue du uberskill","160","1930","Zaventem");
		Personnes pers1 = new Personnes("Janssens","Bicky",date1,adre1);
		CompteEnBanque compte1 = new CompteEnBanque("000-000000089-89",1200,pers1);
		
		Date date2 = new Date(2,8,1996);
		Adresse adre2 = new Adresse("Rue du coucou","69","1200","Bruxelles");
		Personnes pers2 = new Personnes("Tircher","Kyrill",date2, adre2);
		CompteEnBanque compte2 = new CompteEnBanque("000-000000089-90",0,pers2);
		
		//affichage compte 1
		System.out.println(compte1);
		
		//depot de 100€
		System.out.println("Dépot de 100€");
		compte1.depot(100);
		
		//affichage compte1
		System.out.println(compte1);
		
		//retrait 100€
		System.out.println("Retrait de 100€");
		compte1.retrait(100);
		
		//affichage compte1
		System.out.println(compte1);
		
		//affichage compte2
		System.out.println(compte2);
		
		//virement de compte1 vers compte2
		System.out.println("Virement de 600€ du compte 1 vers le compte 2");
		compte1.virement(600, compte2);
		
		//affichage compte 1 & 2
		System.out.println(compte1);
		System.out.println(compte2);
	
	}
}
