
public class testRectangle {
	public static void main(String[] args) {
		Rectangle rec1 = new Rectangle(5,3);
		Rectangle rec2 = new Rectangle(10,6);
		Rectangle rec3 = new Rectangle(8,2);
		
		System.out.println("L'aire du premier rectangle est de "+rec1.calculerAire());
		System.out.println("Le périmetre du deuxieme rectangle est de "+rec2.calculerPerimetre());
		System.out.println("3:"+rec3);
	}
}
