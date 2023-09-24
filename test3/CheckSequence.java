package test3;

import java.util.Scanner;

public class CheckSequence {
	
	/*
	 * Given two string s and t, write a function to check 
	 * if s contains all characters of t (in the same order 
	 * as they are in string t).
	 * 
	 * Return true or false.
	 * 
	 * Do it recursively.
	 * 
	 * E.g. : s = “abchjsgsuohhdhyrikkknddg” contains all 
	 * characters of t=”coding” in the same order. So 
	 * function will return true.
	 */
	
	// Time Complexity -> O(nA*nA), Space Complexity -> O(nA)
	public static boolean checkSequence1(String a, String b) {
        int nA = a.length();
        int nB = b.length();
        if(nB == 0){
            return true;
        }
        if(nA == 0){
            return false;
        }
        char ch = b.charAt(0);
        int i = 0;
        for(; i<nA; i++){
            if(a.charAt(i) == ch){
                break;
            }
        }
        if(i == nA){
            return false;
        }
        else{
            return checkSequence1(a.substring(i+1), b.substring(1));
        }
	}
	
	// Time Complexity -> O(nA), Space Complexity -> O(nA)
	public static boolean checkSequence2(String a, String b) {
        return checkSequence2(a, 0, b, 0);
	}
    
    public static boolean checkSequence2(String a, int idxA, String b, int idxB){
        int nA = a.length();
        int nB = b.length();
        if(idxB == nB){
            return idxA != nA;
        }
        char ch = b.charAt(idxB);
        int i = idxA;
        for(; i<nA; i++){
            if(a.charAt(i) == ch){
                break;
            }
        }
        if(i == nA){
            return false;
        }
        else{
            return checkSequence2(a, i + 1, b, idxB + 1);
            
        }
    }
    
    // Time Complexity -> O(nA), Space Complexity -> O(nA)
    public static boolean checkSequence3(String a, String b) {
        int nA = a.length();
        int nB = b.length();
        if(nB == 0){
            return true;
        }
        if(nA == 0){
            return false;
        }
        if(a.charAt(0) == b.charAt(0)){
            return checkSequence3(a.substring(1), b.substring(1));
        }
        else{
            return checkSequence3(a.substring(1), b);
        }
	}
    
    // Time Complexity -> O(n1), Space Complexity -> O(n1)
    public static boolean checkSequence4(String a, String b) {
		return checkSequence4(a, b, 0, 0);
	}

	private static boolean checkSequence4(String a, String b, int i, int j){
		int n1 = a.length();
		int n2 = b.length();
		if(j >= n2){
			return true;
		}
		if(i >= n1){
			return false;
		}
		if(a.charAt(i) == b.charAt(j)){
			return checkSequence4(a, b, i+1, j+1);
		}
		else{
			return checkSequence4(a, b, i+1, j);
		}
	}
    
    // Iterative approach -> Time complexity -> O(n1 + n2), Space complexity -> O(1)
 	public static boolean checkSequence5(String a, String b) {
 		int n1 = a.length();
 		int n2 = b.length();
 		int i = 0, j = 0;
 		while(i < n1 && j < n2){
 			if(a.charAt(i) == b.charAt(j)){
 				i++;
 				j++;
 			}
 			else{
 				i++;
 			}
 		}
 		if(j != n2){
 			return false;
 		}
 		return true;
 	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		String large = s.nextLine();
		String small = s.nextLine();

		System.out.println(checkSequence2(large, small));
	}

}
