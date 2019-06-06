/*
 * classe non finie
 */
import java.util.ArrayList;

public class Main {
	private ArrayList<Cartes> carteEnMain;
	
	public Main(){
		carteEnMain = new ArrayList<Cartes>(10);
	}
	
	public boolean piocher()throws TropCarteException{
		if (true)throw new TropCarteException();
			return false;
	}
	
	public Cartes jouer(){
		return null;		// a modif
	}
}