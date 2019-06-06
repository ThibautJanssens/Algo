/**
 * 
 * @author Janssens Thibaut - IPL - 27/10/2015
 *
 */
public class TableDEntiers {
	private int[] table;
	
	public TableDEntiers(int[] tableARecopier){
		table = new int[tableARecopier.length];
		for (int i = 0; i < tableARecopier.length; i++) {
			table[i]=tableARecopier[i];
		}
	}
	
	public int nombreOccurrences(int entier){
		
		// version while sans return ni break
		/*
		int i = 0;
		int compteur = 0;
		while(i < table.length){
			if(table[i]==entier)
				compteur++;
         i++;
		}
		return compteur;
		
		*/
		// version for avec return
		int compteur = 0;
		for (int i = 0; i < table.length; i++) {
			if(table[i]==entier)
				compteur++;
		}
		return compteur;
	
	}
	public boolean contient(int entier){
		for (int i=0; i < table.length; i++)
			if(table[i] == entier)
				return true;
		return false;
		/*
		int i = 0;
		while (i<table.length && table[i] != entier){
			i++;
		}
		if(i== table.length) return false;
		return true;
		*/
	}
	
	public boolean contientAuMoins1Negatif(){
		for (int i=0;i<table.length;i++)
			if (table[i]<0)
				return true;
		return false;
		/*
		int i= 0;
		int nombreNegatif = 0;
		while (i<table.length && nombreNegatif !=1){
			if (table[i]<0)
				nombreNegatif +=1;
			i++;
		}
		if (nombreNegatif >= 1) return true;
		return false;
		*/	
	}
	
	public boolean contientAuMoins2Negatifs(){
		int nombreNegatif = 0;
		for (int i=0;i<table.length;i++){
			if (table[i]<0)
				nombreNegatif +=1;
		}
		if (nombreNegatif >= 2)
			return true;
		else		
			return false;
		/*
		int i= 0;
		
		int nombreNegatif = 0;
		while (i<table.length && nombreNegatif !=2){
			if (table[i]<0)
				nombreNegatif +=1;
			i++;
		}
		if (nombreNegatif >= 2) 
			return true;
		return false; 
		*/
	}

	@Override
	public String toString() {
		String aRenvoyer = "tableDEntiers : ";
		for (int i = 0; i < this.table.length; i++) {
			aRenvoyer += this.table[i]+" ";
		}
		return aRenvoyer;
	}
	
	
}
