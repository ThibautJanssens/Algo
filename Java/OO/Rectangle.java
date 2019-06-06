public class Rectangle {
	private double longueur, largeur;
	   
	public Rectangle (double longueur, double largeur){
		this.longueur = longueur;
	    this.largeur = largeur;
	}
	   
	public double calculerAire() {
	    return longueur*largeur;
	}
	   
	public double calculerPerimetre() {
	    return (longueur+largeur)*2;
	}
	
	public String toString(){
		return "Le rectangle a une longeur de: "+longueur+" une largeur de: "+largeur+".\nSon périmètre est de: "+calculerPerimetre()+" et son aire est de: "+calculerAire()+".";
	}
}
