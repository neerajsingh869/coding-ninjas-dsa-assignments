package recursion;

public class RemoveDuplicates {
	
	/*
	 * Given a string S, remove consecutive duplicates from it recursively.
	 */
	
	// Time complexity -> O(n*n), Space complexity -> O(n)
	// Since we have used substring() method
	public static String removeConsecutiveDuplicates1(String s) {
		int n = s.length();
        if(n == 0 || n == 1){
            return s;
        }
        String smallAns = removeConsecutiveDuplicates1(s.substring(1));
        return (s.charAt(0) == s.charAt(1)) ? smallAns :
        		s.charAt(0) + smallAns;
	}
	
	public static String removeConsecutiveDuplicates2(String s) {
        return removeConsecutiveDuplicates2(s, 0);
	}
    
	// Time complexity -> O(n), Space complexity -> O(n)
    public static String removeConsecutiveDuplicates2(String s, int idx){
        int n = s.length();
        if(idx == n){
            return "";
        }
        if(idx+1 == n){
            return "" + s.charAt(idx);
        }
        String smallAns = removeConsecutiveDuplicates2(s, idx+1);
        return (s.charAt(idx) == s.charAt(idx+1)) ? smallAns :
        		s.charAt(idx) + smallAns;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
