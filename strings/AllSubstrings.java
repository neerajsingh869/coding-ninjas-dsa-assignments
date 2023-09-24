package strings;

public class AllSubstrings {
	
	/*
	 * For a given input string(str), write a function 
	 * to print all the possible substrings.
	 */
	
	public static void printSubstrings1(String str) {
		int n = str.length();
        for(int i = 0; i<n; i++){
            String s = "";
            for(int j = i; j<n; j++){
                s += str.charAt(j);
                System.out.println(s);
            }
        }
	}
	
	public static void printSubstrings2(String str) {
		int n = str.length();
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<=n; j++){
                System.out.println(str.substring(i, j));
            }
        }
	}
	
	public static void printSubstrings3(String str) {
		int n = str.length();
        for(int i = 0; i<n; i++){
            for(int j = i; j<n; j++){
                for(int k = i; k<=j; k++){
                    System.out.print(str.charAt(k));
                }
                System.out.println();
            }
        }
	}

	public static void main(String[] args) {
		String inp = "pqrs";
		int n = inp.length();
		int l = 1;
		while(l<=n) {
			for(int i = 0; i<n-l+1; i++) {
				for(int j = i; j<i+l; j++) {
					System.out.print(inp.charAt(j));
				}
				System.out.println();
			}
			l++;
		}
	}

}
