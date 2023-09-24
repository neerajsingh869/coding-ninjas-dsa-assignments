package hashmaps;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UniqueCharacters {
	
	/*
	 * Given a string S, you need to remove all the duplicates. That means, 
	 * the output string should contain each character only once. The 
	 * respective order of characters should remain same, as in the input string.
	 * 
		Input format:
		The first and only line of input contains a string, that denotes the value of S.
		
		Output format :
		The first and only line of output contains the updated string, as described in the task.
		
		Constraints :
		0 <= Length of S <= 10^8
		Time Limit: 1 sec
		
		Sample Input 1 :
		ababacd
		Sample Output 1 :
		abcd
		
		Sample Input 2 :
		abcde
		Sample Output 2 :
		abcde
	 */
	public static String uniqueChar1(String str){
		HashMap<Character, Boolean> map = new HashMap<>();
		
		for (int i = 0; i<str.length(); i++) {
			char c = str.charAt(i);
			map.put(c, true);
		}
		
		String ans = "";
		
		for (int i = 0; i<str.length(); i++) {
			char c = str.charAt(i);
			if( map.containsKey(c) ){
				if(map.get(c) == true){
					ans += c;
					map.put(c, false);
				}
			}
		}
		
		return ans;
	}
	
	// Better approach
	public static String uniqueChar2(String str){
		String ans = "";
		
		HashMap<Character, Boolean> map = new HashMap<>();
		
		for (int i = 0; i<str.length(); i++) {
			char c = str.charAt(i);
			if( !map.containsKey(c) ){
				map.put(c, true);
				ans += c;
			}
		}
		
		return ans;
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static String takeInput() throws IOException {
        String str = br.readLine(); 
        return str;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {


        String str = takeInput();
        System.out.print(uniqueChar2(str));


    }

}
