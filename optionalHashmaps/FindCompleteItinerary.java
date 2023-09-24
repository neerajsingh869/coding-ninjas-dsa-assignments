package optionalHashmaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class places {
	String start;
	String dest;
}

public class FindCompleteItinerary {
	
	/*
	 * You are given a list of input tickets which are not cyclic and there is only one ticket from every given city except the final destination. You have to find the complete itinerary in order using the given list.
Input Format:
The first line of input contains the number of tickets given to you. The second line of input has space-separated tickets with a start and destination city.
Output Format:
The output contains the complete itinerary in order in different lines.
Constraints:
0<=Number of tickets<=70
Sample Input:
6
Jammu Manali Kashmir Jammu Delhi Chandigarh Amritsar Kashmir Manali Jaipur Chandigarh Amritsar
Sample Output:
Delhi -> Chandigarh
Chandigarh -> Amritsar
Amritsar -> Kashmir
Kashmir -> Jammu
Jammu -> Manali
Manali -> Jaipur
Explanation:
6 tickets are given to us:
1. Jammu to Manali
2. Kashmir to Jammu
3. Delhi to Chandigarh 
4. Amritsar to Kashmir 
5. Manali to Jaipur 
6. Chandigarh to Amritsar

So from these tickets the complete itinerary in order will be:

Delhi -> Chandigarh
Chandigarh -> Amritsar
Amritsar -> Kashmir
Kashmir -> Jammu
Jammu -> Manali
Manali -> Jaipur
	 */
	
	// Time complexity -> O(n*n)
	public static void itineary1(HashMap<String, String> input) {
		String startKey = null;
		for(Map.Entry<String, String> e1 : input.entrySet()){
			boolean isNotStart = false;
			for(Map.Entry<String, String> e2 : input.entrySet()){
				if(e1.getKey().equals(e2.getValue())){
					isNotStart = true;
					break;
				}
			}
			if(!isNotStart){
				startKey = e1.getKey();
				break;
			}
		}
		if(startKey == null){
			return;
		}
		for(int i = 1; i<=input.size(); i++){
			System.out.println(startKey + " -> " + input.get(startKey));
			startKey = input.get(startKey);
		}
	}
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static void itineary2(HashMap<String, String> input) {
		HashMap<String, String> rev = new HashMap<>();
		for(Map.Entry<String, String> e : input.entrySet()){
			rev.put(e.getValue(), e.getKey());
		}
		for(Map.Entry<String, String> e : input.entrySet()){
			if(!rev.containsKey(e.getKey())){
				// Starting point of journey found
				String start = e.getKey();
				String to = input.get(start);
				while(to != null){
					System.out.println(start + " -> " + to);
					start = to;
					to = input.get(start);
				}
				break;
			}
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		places[] arr = new places[n];
	
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new places();
			arr[i].start = scn.next();
			arr[i].dest = scn.next();
		}
		
		HashMap<String, String> input=new HashMap<String, String>();
		for(int i=0; i<n; i++) {
			input.put(arr[i].start, arr[i].dest);
		}
		itineary2(input);
	}

}
