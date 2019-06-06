
public class Cylindre implements Solide{
	private double hauteur, rayon;
	
	public Cylindre(double rayon, double hauteur){
		this.rayon = rayon;
		this.hauteur = hauteur;
	}
	
	public double getRayon(){
		return this.rayon;
	}
	
	public double getHauteur(){
		return this.hauteur;
	}

	public double calculerVolume(){
		return Math.PI * rayon * rayon * hauteur;
	}
	
	public double calculerSurface(){
		return (2 * Math.PI * rayon * rayon) + (2 * Math.PI * rayon * hauteur);
	}
	
	public boolean equals(Object obj){
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cylindre cylindre = (Cylindre) obj;
		return (this.hauteur == cylindre.hauteur) && (this.rayon == cylindre.rayon);
	}
	
	public int hashCode(){
		return 31 * ((Double)rayon).hashCode() + ((Double)hauteur).hashCode();
	}
}
