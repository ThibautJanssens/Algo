/**
 * 
 * @author JANSSENS Thibaut - IPL - 17/11/2015
 *
 */
public class Etudiant{

	private double[] tableCotes; // table tri�e
	private int matricule;


	// Pour les tests!
	public Etudiant(int matricule, double[] tableARecopier){
		if(tableARecopier.length==0)throw new IllegalArgumentException();
		this.matricule = matricule;
		this.tableCotes = new double[tableARecopier.length];
		for(int i = 0; i < tableARecopier.length; i++) 
			tableCotes[i] = tableARecopier[i];
	}       

	public String toString(){
		String aRenvoyer = "\n";
		for(int i = 0; i < tableCotes.length; i++) 
			aRenvoyer = aRenvoyer + "  " + tableCotes[i];
		return aRenvoyer;
	}


	public double moyenne(){    
		double somme = 0;
		
		for(int i = 0; i < tableCotes.length; i++) 
			somme += tableCotes[i];
		return somme/tableCotes.length;
	}

	public int nombreEchecs(){
		int nombreEchecs = 0;

		for(int i = 0; i < tableCotes.length; i++){ 
			if(tableCotes[i]<10) 
				nombreEchecs++;
			else
				return nombreEchecs;
		}
		return nombreEchecs;
	}


	public double min(){
		return tableCotes[0];
	}


	public double max(){
		return tableCotes[tableCotes.length-1];
	}
}