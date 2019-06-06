
public class TooPoorException extends Exception {
	public TooPoorException(){
		System.out.println("Le solde de votre compte ne permet pas cette operation.");
	}
	
	public TooPoorException(String message){
		System.out.println(message);
	}
}
