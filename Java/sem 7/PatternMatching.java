/**
 * 
 * @author Janssens Thibaut - IPL - 27/10/2015
 *
 */
public class PatternMatching {
	public static void main(String[] args) {
		//TO MODIFY
		String s1 = "Tester un programme peut demontrer la presence de bugs, jamais leur absence.";
		String p1 = "leur absence";
		
		char[] s2 = s1.toCharArray();
		char[] p2 = p1.toCharArray();
		
		System.out.println(match(s2, p2));
	}
	
	private static boolean match(char[] s, char[] pattern) {		
		if (pattern.length == 0) 
			return true;
		for (int i = 0; i < s.length; i++){
			if(matchAtIndex(s, pattern, i))
				return true;
		}
		return false;
	}
	
	private static boolean matchAtIndex (char[] s, char[] pattern, int idx) {
		for (int i = 0; i<pattern.length;i++){
			if(s[idx] != pattern[i]) 
				return false;
			else
				idx++;
		}
		return true;
	}
}
