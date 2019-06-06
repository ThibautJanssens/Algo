/**
 * 
 * @author Janssens Thibaut - IPL - 20/10/2015
 *
 */
public class Carre {
	
	double coinInfGaucheX, coinInfGaucheY, largeur;
	
	public double getCoinInfGaucheX() {
		return coinInfGaucheX;
	}

	public double getCoinInfGaucheY() {
		return coinInfGaucheY;
	}

	
	public double getLargeur() {
		return largeur;
	}

	public Carre(double coinInfGaucheX, double coinInfGaucheY,double largeur) {
		super();
		this.coinInfGaucheX = coinInfGaucheX;
		this.coinInfGaucheY = coinInfGaucheY;
		this.largeur = largeur;
	}

	public boolean pointIncluDansCarre(double positionX, double positionY){
		if (positionX < coinInfGaucheX)
			return false;
		if (positionX > coinInfGaucheX + largeur)
			return false;
		if (positionY < coinInfGaucheY)
			return false;
		if (positionY > coinInfGaucheY + largeur)
			return false;
		else
			return true;
	}
	
	public boolean carreEnIntersection(Carre carre2){
		if (coinInfGaucheX + largeur < carre2.coinInfGaucheX)
			return false;
		if (coinInfGaucheX > carre2.coinInfGaucheX + carre2.largeur)
			return false;
		if (coinInfGaucheY + largeur < carre2.coinInfGaucheY)
			return false;
		if (coinInfGaucheY > carre2.coinInfGaucheY + carre2.largeur)
			return false;
		else
			return true;
	}
}