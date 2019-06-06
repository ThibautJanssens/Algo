import java.util.ArrayList;

public class ListeSolides {
	private ArrayList<Solide>solides;
	
	public boolean estVide(){
		return solides.size() == 0;
	}
	
	public int nbreSolides(){
		return solides.size();
	}
	
	public boolean ajouterSolide(Solide solide){
		if (contientSolide(solide))
			return false;
		else
			return solides.add(solide);
	}
	
	public boolean retirerSolide(Solide solide){
		if (!contientSolide(solide))
			return false;
		else 
			return solides.remove(solide);
	}
	
	public boolean contientSolide(Solide solide){
		return solides.contains(solide);
	}
	
	public Solide trouverPlusGrandVolume(){
		if (estVide()) return null;
		Solide volumeMax = null;
		double max = 0;
		for(Solide forme : solides){
			if (forme.calculerVolume() > max){
				volumeMax = forme;
				max = forme.calculerVolume();
			}
		}
		return volumeMax;
	}
}
