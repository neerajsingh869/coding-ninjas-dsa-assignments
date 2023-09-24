package recursion;

public class PairStar {

	/*
	 * Given a string S, compute recursively a new string 
	 * where identical chars that are adjacent in the 
	 * original string are separated from each other by a "*".
	 */
	
	// Time Complexity -> O(n*n), Space Complexity -> O(n)
	public static String addStars1(String s) {
        int n = s.length();
        if(n == 0 || n == 1){
            return s;
        }
        if(s.charAt(0) == s.charAt(1)){
            return s.charAt(0) + "*" + addStars1(s.substring(1));
        }
        else{
            return s.charAt(0) + addStars1(s.substring(1));
        }
	}
	
	// Time Complexity -> O(n), Space Complexity -> O(n)
	public static String addStars2(String s) {
        return addStars2(s, 0);
	}
    
    public static String addStars2(String s, int idx){
        int n = s.length();
        if(idx == n){
            return "";
        }
        if(idx+1 == n){
            return "" + s.charAt(idx);
        }
        if(s.charAt(idx) == s.charAt(idx+1)){
            return s.charAt(idx) + "*" + addStars2(s, idx+1);
        }
        else{
            return s.charAt(idx) + addStars2(s, idx+1);
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
