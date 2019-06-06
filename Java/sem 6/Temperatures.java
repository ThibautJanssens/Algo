/**
 * 
 * @author Janssens Thibaut - IPL - 20/10/2015
 *
 */
public class Temperatures {

	private String mois;
	private double[] tableDesTemperatures;
	
	// A NE PAS MODIFIER
	public Temperatures(String mois, double [] tableARecopier) {
		if(tableARecopier == null)
			throw new IllegalArgumentException();
		if(tableARecopier.length == 0)
			throw new IllegalArgumentException();
		this.mois = mois;
		this.tableDesTemperatures = new double[tableARecopier.length];
		for (int i = 0; i < tableARecopier.length; i++) {
			this.tableDesTemperatures[i]=tableARecopier[i];
		}
	}
	
	// A NE PAS MODIFIER
	public String toString(){
		String aRenvoyer = "temperatures du mois de " + this.mois + " : \n";
		for (int i = 0; i < this.tableDesTemperatures.length; i++) {
			aRenvoyer += "\n"+ (i+1) +" : "+this.tableDesTemperatures[i]+" ";
		}
		return aRenvoyer;
	}

	
	/**
	 * renvoie la temperature du jour passe en parametre 
	 * @param jour // le 1er jour porte le n°1, ...
	 * @return la temperature correspondante
	 * @throws IllegalArgumentException dans le cas ou le numero de jour n'est pas prevu dans la table
	 */
	public double getTemperature(int jour){
		// A COMPLETER
		// N'OUBLIEZ PAS DE PREVOIR L'EXCEPTION
		if (jour < 0 || jour >= tableDesTemperatures.length)throw new IllegalArgumentException();
		double temperature = tableDesTemperatures[jour];
		return temperature;
	}
	
	
	/**
	 * calcule la moyenne des temperatures
	 * @return la moyenne
	 */
	public double moyenne(){
		double moyenne = 0;
		for (int i=0; i < tableDesTemperatures.length;i++){
			moyenne += tableDesTemperatures[i];
		}
		moyenne = moyenne / tableDesTemperatures.length;
		return moyenne;
	}
	
	
	/**
	 * recherche la temperature la plus elevee
	 * @return la temperature la plus elevee
	 */
	public double temperatureMax(){
		double temperatureMax = -100;
		for (int i=0; i<tableDesTemperatures.length;i++){
			if (tableDesTemperatures[i] > temperatureMax)
				temperatureMax = tableDesTemperatures[i];
		}
		return temperatureMax;
	}
	
	
	/**
	 * recherche la temperature la plus basse
	 * @return la temperature la plus basse
	 */
	public double temperatureMin(){
		double temperatureMin = 100;
		for (int i=0; i<tableDesTemperatures.length;i++){
			if (tableDesTemperatures[i] < temperatureMin)
				temperatureMin = tableDesTemperatures[i];
		}
		return temperatureMin;
	}

	
	/**
	 * calcule le nombre de temperatures negatives (< 0)
	 * @return le nombre de jours de gel
	 */
	public double nombreJoursDeGel(){
		double nombreJoursDeGel = 0;
		for (int i=0; i<tableDesTemperatures.length;i++){
			if (tableDesTemperatures[i] < 0)
				nombreJoursDeGel ++;
		}
		return nombreJoursDeGel;
	}
	
	
	/**
	 * remplit une table avec les numeros des jours de gel
	 * @return une table avec les jours de gel, la dimension de cette table correspond à ce nombre de jours
	 */
	public int[] joursDeGel(){
		// Attention, la dimension des tables renvoyees doivent TOUJOURS correspondre au nombre de donnees
		int placeTableauGel = 0;
		int[] joursDeGel = new int[(int)nombreJoursDeGel()];
		for (int i=0;i<tableDesTemperatures.length;i++){
			if (tableDesTemperatures[i]<0){
				joursDeGel[placeTableauGel] = i;
				placeTableauGel++;
			}
		}
		return joursDeGel;
	}
	
	
	/**
	 * remplit une table avec les numeros des jours correspondant a la temperature la plus elevee
	 * @return une table avec les jours de haute temperature, la dimension de cette table correspond à ce nombre de jours
	 */
	public int[] joursMax(){
		int nbreJoursMax = 0;
		double temperatureMax = temperatureMax();
		for (int i=0;i<tableDesTemperatures.length;i++){
			if (tableDesTemperatures[i]==(int)temperatureMax)
				nbreJoursMax++;
			
		}
		int[] joursMax = new int[nbreJoursMax];
		int placeDansTableau = 0;
		
		for (int i = 0;i < tableDesTemperatures.length;i++){
			if (tableDesTemperatures[i]==(int)temperatureMax){
				joursMax[placeDansTableau] = i;
				placeDansTableau ++;
			}		
		}
		return joursMax;
	}
	
	/**
	 * remplit une table avec les numeros des jours correspondant a la temperature la plus basse
	 * @return une table avec les jours de basse temperature, la dimension de cette table correspond à ce nombre de jours
	 */
	public int[] joursMin(){
		int nbreJoursMin = 0;
		double temperatureMin = temperatureMin();
		for (int i=0;i<tableDesTemperatures.length;i++){
			if (tableDesTemperatures[i]==(int)temperatureMin)
				nbreJoursMin++;
			
		}
		int[] joursMin = new int[nbreJoursMin];
		int placeDansTableau = 0;
		
		for (int i = 0;i < tableDesTemperatures.length;i++){
			if (tableDesTemperatures[i]==(int)temperatureMin){
				joursMin[placeDansTableau] = i;
				placeDansTableau ++;
			}		
		}
		return joursMin;
	}
	
}
