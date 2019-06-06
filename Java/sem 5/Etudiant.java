/**
 * 
 * @author Janssens Thibaut - IPL - 13 octobre 2015
 *
 */
public class Etudiant{

	private double[] tableCotes;
	private int matricule;
	
	
	
	// A NE PAS MODIFIER! VA SERVIR POUR LES TESTS
	/**
	 * constructeur par recopie
	 * ce constructeur leve une exception si la table passee en parametre contient aucune cote
	 * @param matricule
	 * @param tableARecopier
	 * @throws IllegalArgumentException
	 */
	public Etudiant(int matricule, double[] tableARecopier)throws IllegalArgumentException{	
		if(tableARecopier.length == 0)
			throw new IllegalArgumentException("aucune cote");
		this.matricule = matricule;
		this.tableCotes = new double[tableARecopier.length];
		for(int i = 0; i < tableCotes.length; i++) 
			tableCotes[i] = tableARecopier[i];
	}

	// A NE PAS MODIFIER! VA SERVIR POUR LES TESTS
	public String toString(){
		String aRenvoyer = "\nMatricule : "+matricule+"\nCotes : ";
                for(int i = 0; i < tableCotes.length; i++) 
			aRenvoyer = aRenvoyer + "  " + tableCotes[i];
		return aRenvoyer;
	}


	/**
	 * calcule la moyenne des cotes
	 * @return la moyenne
	 */
	public double moyenne(){
		double moyenne = 0;
		for (int i=0; i < tableCotes.length;i++){
			moyenne += tableCotes[i];
		}
		moyenne = moyenne / tableCotes.length;
		return moyenne;
	}
	

	/**
	 * repere le nombre de cotes < 10
	 * @return le nombre de cotes < 10
	 */
	public int nombreEchecs(){
		int nombreEchecs = 0; 
		for (int i=0; i < tableCotes.length;i++){
			if (tableCotes[i] < 10)
				nombreEchecs++;
		}
		return nombreEchecs;
	}


	/**
	 * recherche la plus petite cote
	 * @return la plus basse cote
	 */
	public double min(){
		double coteMin = 20;
		for (int i=0; i < tableCotes.length;i++){
			if (tableCotes[i] < coteMin)
				coteMin = tableCotes[i];
		}
		return coteMin;
	}


	/**
	 * recherche la plus haute cote
	 * @return la plus haute cote
	 */
	public double max(){
		double coteMax = 0;
		for (int i=0; i < tableCotes.length;i++){
			if (tableCotes[i] > coteMax)
				coteMax = tableCotes[i];
		}
		return coteMax;
	}

	/**
	 * calcule le nombre d'UE validée
	 * @return le nombre d'UE validée
	 */
	public int nombreUEValidees(){
		int valide = 0, nbreEchecInf9 = 0, nbreEchecA9 = 0;
		for (int i = 0; i < tableCotes.length;i++){
			if (tableCotes[i]<9)
				nbreEchecInf9 ++;
			if (tableCotes[i]<10)
				nbreEchecA9 ++;
			else
				valide ++;
		}
		if (nbreEchecA9 == 1 && nbreEchecInf9 == 0 && moyenne()>=12 )
			valide ++;
		return valide;
	}
}