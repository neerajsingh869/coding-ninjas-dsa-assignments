package optionalRecursionAndBacktracking;

import java.util.Scanner;

public class LongestCommonPrefix {
	
	// Time Complexity -> O(m*n) where m = maximum string length
	// and n is the input size
	public static void answer1(String input[]) {
		String ans = answer1(input, 0);
		if(ans == ""){
			ans = "-1";
		}
		System.out.println(ans);
	}

	private static String answer1(String input[], int i){
		int n = input.length;
		if(n-1 == i){
			return input[i];
		}
		String recAns = answer1(input, i+1);
		String finalAns = "";
		int minLength = Math.min(recAns.length(), input[i].length());
		for(int j = 0; j<minLength; j++){
			if(recAns.charAt(j) != input[i].charAt(j)){
				break;
			}
			finalAns += recAns.charAt(j);
		}
		return finalAns;
	}
	
	// Time Complexity -> O(m*n) where m = maximum string length
	// and n is the input size
	public static void answer2(String input[]) {
		int n = input.length;
		if(n == 0){
			return;
		}
		answer2(input, 0, n, input[0]);
	}

	private static void answer2(String input[], int i, int n, String ansTillNow){
		if(i == n){
			ansTillNow = (ansTillNow.isEmpty()) ? "-1" : ansTillNow;
			System.out.println(ansTillNow);
			return;
		}
		ansTillNow = commonPrefix(ansTillNow, input[i]);
		answer2(input, i+1, n, ansTillNow);
	}
	
	// Time Complexity -> O(m*n) where m = maximum string length
	// and n is the input size
	public static void answer3(String input[]) {
		int n = input.length;
		if(n == 0){
			return;
		}
		String ans = input[0];
		for(int i = 1; i<n; i++){
			ans = commonPrefix(input[i], ans);
		}
		if(ans == ""){
			ans = "-1";
		}
		System.out.print(ans);
	}

	private static String commonPrefix(String str1, String str2){
		String ans = "";
		int minLength = Math.min(str1.length(), str2.length());
		for(int j = 0; j<minLength; j++){
			if(str1.charAt(j) != str2.charAt(j)){
				break;
			}
			ans += str1.charAt(j);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();

		String[] inputs = new String[n];
		for(int i = 0; i < n; i++) {
			inputs[i] = s.next();
			
		}
		
		answer3(inputs);
	}

}
