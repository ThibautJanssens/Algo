/**
 * 
 * @author JANSSENS Thibaut - IPL - 17/11/15
 *
 */
public class TableauTrieDEntiers{

	private int [] tableDEntiers;
	private int nombreDEntiers;
	private static final int TAILLE = 10;

	public TableauTrieDEntiers(){
		this.tableDEntiers = new int[TAILLE];
		this.nombreDEntiers = 0;
	}

	public boolean equals(TableauTrieDEntiers t){
		if(t.nombreDEntiers!=this.nombreDEntiers)return false;
		for(int i = 0; i < nombreDEntiers;i++)		
			if (this.tableDEntiers[i]!=t.tableDEntiers[i]) 
				return false;
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TableauTrieDEntiers t = (TableauTrieDEntiers)obj;
		if(t.nombreDEntiers!=this.nombreDEntiers)return false;
		for(int i = 0; i < nombreDEntiers;i++)		
			if (this.tableDEntiers[i]!=t.tableDEntiers[i]) 
				return false;
		return true;
	}
	
	public boolean estEgalA(TableauTrieDEntiers t){
		for(int i = 0; i < nombreDEntiers;i++)		
			if (this.tableDEntiers[i]!=t.tableDEntiers[i]) 
				return false;
		return true;

	}
	
	public String toString(){
		String aRenvoyer = "\n nombreDEntiers : " + this.nombreDEntiers;
		aRenvoyer += "   tableDEntiers : ";
		for (int i = 0; i < this.nombreDEntiers; i++) {
			aRenvoyer += this.tableDEntiers[i]+" ";
		}
		return aRenvoyer;
	}
	
	/**
	 * constructeur par recopie
	 * ce constructeur leve une exception si la table passee en parametre contient plus de 10 entiers
	 * utile pour les tests!!!
	 * @param tableARecopier
	 */

	public TableauTrieDEntiers(int[] tableARecopier){
		if(tableARecopier.length>TAILLE)throw new IllegalArgumentException();
		this.nombreDEntiers = tableARecopier.length;
		tableDEntiers= new int[TAILLE];
		for(int i = 0; i<nombreDEntiers; i++){
			tableDEntiers[i] = tableARecopier[i];
		}     	
	}

	public int getNombreDEntiers(){
		return this.nombreDEntiers;
	}


	/** methode qui ajoute un entier si la table n'est pas encore pleine. La table doit rester triee!
   @param unEntier l'entier a ajouter
   @return boolean signale si l'entier a pu etre ajoute
	 */

	public boolean ajouterUnEntier(int unEntier){
		int i= nombreDEntiers - 1;
		
		if (nombreDEntiers >= TAILLE) 
			return false;
		
		while (i >= 0 && tableDEntiers[i] > unEntier){
			tableDEntiers[i+1] = tableDEntiers[i];
			i--;
		}
		tableDEntiers[i+1] = unEntier;
		nombreDEntiers ++;
		return true;    
	}

	/**
	 * methode qui recherche l'indice correspondant a la premiere occurrence de l'entier passe en parametre
	 * @param unEntier l'entier dont on desire conna�tre l'indice
	 * @return indice correspondant a unEntier, -1 s'il n'y est pas
	 */
	private int trouverIndice(int unEntier){
		//recherche sequentielle
		for (int i = 0; i < this.nombreDEntiers; i++) {
			if(this.tableDEntiers[i]==unEntier)
				return i;
			if(this.tableDEntiers[i]>unEntier)
				return -1;
		}
		return -1;
	}

	/** methode qui verifie si la table contient l'entier passe en parametre
   	@param unEntier l'entier dont on desire tester la presence
   	@return boolean true si l'entier est present dans la table
	 */
	public boolean contient(int unEntier){
		if (trouverIndice(unEntier)!= -1)
			return true;
		return false;
	}  

	/** methode qui supprime une occurrence d'un entier. La table doit rester triee!
   @param unEntier l'entier a supprimer
   @return boolean signale si l'entier a pu etre supprime
	 */
	public boolean supprimerUneOccurrence(int unEntier){
		int position = trouverIndice(unEntier);
		
		if (position != -1){
			for(int i = position; i < nombreDEntiers-1;i ++)
				tableDEntiers[i] = tableDEntiers[i+1];
		nombreDEntiers --;
		return true;
		}
		return false;
	} 

	/** methode qui supprime toutes les occurrences d'un entier
   @param unEntier l'entier a supprimer
   @return int le nombre de suppressions effectuees
	 */
	public int supprimerToutesLesOccurrences(int unEntier){
		int nbreSuppression = 0;
		
		while( contient(unEntier)){
			supprimerUneOccurrence(unEntier);
			nbreSuppression++;
		}
		return nbreSuppression;
	}

	/** methode qui verifie si la table contient des ex-aequos
	@return boolean true si la table contient des ex-aequos, false sinon
	 */
	public boolean contientExAequo(){
		for(int i = 0; i< nombreDEntiers-1;i++){
			if (tableDEntiers[i]==tableDEntiers[i+1])
				return true;
		}
		return false;
	}

	/** methode qui supprime tous les ex-aequos
    @return int le nombre de suppressions effectuees
	 */
	public int supprimerTousLesExAequos(){
        if(!contientExAequo())
        	return 0;
        
        int nombreSuppression = 0;

        for(int i = 0; i < nombreDEntiers-1 ; i++){
            if(tableDEntiers[i] == tableDEntiers[i+1]){
                for(int j = i; j < nombreDEntiers-1; j++){
                    tableDEntiers[j] = tableDEntiers[j+1];
                }
                i--;
                nombreDEntiers--;
                nombreSuppression++;
            }
        }
         
 
        return nombreSuppression;
     
    }
}