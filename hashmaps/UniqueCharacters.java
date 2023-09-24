package hashmaps;

import java.util.HashMap;

public class UniqueCharacters {
	
	/*
	 * Given a string S, you need to remove all the duplicates. 
	 * That means, the output string should contain each character 
	 * only once. The respective order of characters should remain 
	 * same, as in the input string.
	 */
	public static String uniqueChar1(String str){
		HashMap<Character, Boolean> map = new HashMap<>();
		for(int i = 0; i<str.length(); i++){
			char c = str.charAt(i);
			map.put(c, true);
		}
		String ans = "";
		for(int i = 0; i<str.length(); i++){
			char c = str.charAt(i);
			if(map.containsKey(c)){
				if(map.get(c) == true){
					ans += c;
					map.put(c, false);
				}
			}
		}
		return ans;
	}
	
	// Better approach
	public static String uniqueChar(String str){
		String ans = "";
		HashMap<Character, Boolean> map = new HashMap<>();
		for(int i = 0; i<str.length(); i++){
			char c = str.charAt(i);
			if(!map.containsKey(c)){
				map.put(c, true);
				ans += c;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
