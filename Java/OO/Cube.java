
public class Cube implements Solide{
	private double cote;
	
	public Cube(double cote){
		this.cote = cote;
	}
	
	public double getCote(){
		return this.cote;
	}
	
	public double calculerVolume(){
		return cote * cote * cote;
	}
	
	public double calculerSurface(){
		return cote * cote;
	}
	
	public boolean equals(Object obj){
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cube cube = (Cube) obj;
		return this.cote == cube.cote;
	}
	
	public int hashCode(){
		return ((Double)cote).hashCode();
	}
}
