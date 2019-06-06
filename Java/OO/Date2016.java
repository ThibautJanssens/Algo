
public class Date2016 {
	
	private int numeroJour;		// le 1/1/2016 est le jour n°1, c'est un vendredi
	private int jour;
	private int mois;
	private static final int[] NOMBRE_JOURS_DU_MOIS = {0,31,29,31,30,31,30,31,31,30,31,30,31} ;
	private static final int[] NOMBRE_JOURS_ECOULES_AU_TERME_DU_MOIS = {0,31,60,91,121,152,182,213,244,274,305,335,366};
	// A COMPLETER
	
 	public Date2016(int jour, int mois){
 		// EXCEPTION A COMPLETER. PENSEZ A UTILISER LA METHODE ESTVALIDE()
		this.jour = jour;
		this.mois = mois;
		// A COMPLETER this.numeroJour = ;
	}	
	
	public Date2016(int numeroJour)throws IllegalArgumentException{	
 		if(numeroJour <=0 || numeroJour>366)
 			throw new IllegalArgumentException("numeroJour non valide");
		this.numeroJour = numeroJour;
		this.jour = numeroJour;
		int i = 1;
		while (this.NOMBRE_JOURS_ECOULES_AU_TERME_DU_MOIS[i] < numeroJour){
			i++;
			this.jour = this.jour - this.NOMBRE_JOURS_DU_MOIS[i-1];
		}
		this.mois = i;
	}	
	
	public String toString(){
 		return ""+jour+"/"+mois+"/2016";  
	}

 	public Date2016 donnerJourSuivant(){
 		return null;
 		//A COMPLETER
	}
	

 	
 	// A COMPLETER
	
}
