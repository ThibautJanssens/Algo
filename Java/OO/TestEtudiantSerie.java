
public class TestEtudiantSerie {
	public static void main(String[] args) {
	Serie serie1 = new Serie('1');
	Serie serie2 = new Serie('2');
		
	Etudiant cap = new Etudiant ("19890902-112","Capelle","Alain",serie1);
	Etudiant lep = new Etudiant ("19900623-243","Lepage","David",serie1);
	Etudiant ton = new Etudiant ("19911114-121","Tonneau","Jeremy",serie1);
	Etudiant mim = new Etudiant ("19900101-139","Mimoun","Brahim",serie1);
		
	System.out.println(cap);
	System.out.println(lep);
	System.out.println(ton);
	System.out.println(mim);
	System.out.println(serie1);
	
	
	System.out.println("\nElection 1_____Capelle Alain dans s�rie 1 (ok)");
	serie1.elireDelegue(cap);
	System.out.println(serie1);
	System.out.println(serie1.getDelegue());
	
	System.out.println("\nElection 2________Tonneau Jeremy dans s�rie 2 (crash)");
	try {
		serie2.elireDelegue(ton);
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}{
		
	}
	System.out.println(serie2);
	System.out.println(serie2.getDelegue());
	
	System.out.println("\nElection 3___________Tonneau Jeremy dans s�rie 1 (crash)");
	try{
		serie1.elireDelegue(ton);
	}catch(Exception e){
		System.out.println(e.getMessage());
	}
	System.out.println(serie1);
	System.out.println(serie1.getDelegue());
		
	System.out.println("\nChangement s�rie 1______Mimoun Brahim dans s�rie 2 (ok)");
	System.out.println(mim.getSerie());
	mim.changerSerie(serie2);
	System.out.println("Tentative changement de s�rie 1 vers s�rie 2");
	System.out.println(mim.getSerie());
		
	System.out.println("\nChangement s�rie 2_____Capelle Alain dans s�rie 2 (crash)");
	System.out.println(cap.getSerie());
	System.out.println("Tentative changement de s�rie 1 vers s�rie 2");
	try{
		cap.changerSerie(serie2);
	}catch (Exception e){
		System.out.println(e.getMessage());
	}
	System.out.println(cap.getSerie());
	System.out.println(cap);
     }
}
