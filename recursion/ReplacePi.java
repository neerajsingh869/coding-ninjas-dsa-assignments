package recursion;

public class ReplacePi {
	
	// Time Complexity -> O(n*n), Space Complexity -> O(n)
	public static String replacePi1(String input) {
		int n = input.length();
		if(n == 0 || n == 1) {
			return input;
		}
		if(input.substring(0, 2) == "pi") {
			return "3.14" + replacePi1(input.substring(2));
		}
		else {
			return input.charAt(0) + replacePi1(input.substring(1));
		}
	}
	
	// Time Complexity -> O(n), Space Complexity -> O(n)
	public static String replacePi2(String input) {
		return replacePi2(input, 0);
	}
	
	public static String replacePi2(String input, int idx) {
		int n = input.length();
		if(idx == n) {
			return "";
		}
		if(idx + 1 == n) {
			return "" + input.charAt(idx);
		}
		if(input.charAt(idx) == 'p' && input.charAt(idx+1) == 'i') {
			return "3.14" + replacePi2(input, idx+2);
		}
		else {
			return replacePi2(input, idx+1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
