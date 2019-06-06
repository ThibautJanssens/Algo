
public class Sphere implements Solide{
	private double rayon;
	
	public Sphere(double rayon){
		this.rayon = rayon;
	}
	
	public double getRayon(){
		return this.rayon;
	}
	public double calculerVolume(){
		return (4 * Math.PI * rayon * rayon * rayon) / 3;
	}
	
	public double calculerSurface(){
		return (4 * Math.PI * rayon * rayon) ;
	}
	
	public boolean equals(Object obj){
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sphere sphere = (Sphere) obj;
		return this.rayon == sphere.rayon;
	}
	
	public int hashCode(){
		return ((Double)rayon).hashCode();
	}
}
