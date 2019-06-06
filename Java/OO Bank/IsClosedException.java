
public class IsClosedException extends Exception {
	public IsClosedException(){
		System.out.println("Votre compte est cloturé.");
	}
	
	public IsClosedException(String message){
		System.out.println(message);
	}
}
