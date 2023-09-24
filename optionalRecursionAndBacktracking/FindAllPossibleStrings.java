package optionalRecursionAndBacktracking;

import java.util.Scanner;

public class FindAllPossibleStrings {
	
	// Time Complexity -> O(2^n), Space Complexity -> O(n)
	public static void printAllPossibleStrings(String str) {
		printAllPossibleStrings(str, "");
	}

	private static void printAllPossibleStrings(String str, String ansTillNow){
		if(str.isEmpty()){
			System.out.println(ansTillNow);
			return;
		}
		if(str.charAt(0) == '?'){
			printAllPossibleStrings(str.substring(1), ansTillNow + "0");
			printAllPossibleStrings(str.substring(1), ansTillNow + "1");
		}
		else{
			ansTillNow += str.charAt(0);
			printAllPossibleStrings(str.substring(1), ansTillNow);
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.next();

		printAllPossibleStrings(str);
	}

}
