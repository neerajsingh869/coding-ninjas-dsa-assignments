package optionalHashmaps;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class ShiftedStrings {
	
	/*
	 * You are given an N-sized array of strings, you have to make groups of those strings in such a way that all the strings of a group are shifted versions of each other.
Two strings A and B are placed in the same group if:
Length of A= Length of B
A[i]=B[i]+k
1 <= i <= Length of A or B  for a constant integer K
Note: Order doesn't matter w.r.t to different groups, but it does matter within a particular group(should be printed in same order as present in the given array).
Input Format:
The first line of input contains the length of the array of strings. The second line of input contains the space-separated array elements.
Output Format:
The output contains the groups of different strings in different lines.
Constraints:
0<=N<=1000
Sample Input:
16
asd bte ak dn a v b n qwer rxfs iuy poi iuy poi qwe asd
Sample Output:
a v b n
qwe 
qwer rxfs 
ak dn 
iuy iuy 
asd bte asd 
poi poi 
	 */
	
	public static void grouping(String[] arr, int n) {
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		for(int i = 0; i<n; i++) {
			String getDiffStr = getDiffString(arr[i]);
			ArrayList<String> shiftedStrings = map.getOrDefault(getDiffStr, new ArrayList<>());
			shiftedStrings.add(arr[i]);
			map.put(getDiffStr, shiftedStrings);
		}
		for (Map.Entry<String,ArrayList<String>> ele : map.entrySet()) {
			ArrayList<String> shiftedStrings = ele.getValue();
			for (int i = 0; i<shiftedStrings.size(); i++){
				System.out.print(shiftedStrings.get(i) + " ");
			}
			System.out.println();
		}
	}

	public static String getDiffString(String s) {
        int n = s.length();
		String diffString = "";
		for(int i = 0; i<n-1; i++) {
			int diff = s.charAt(i+1)  - s.charAt(i);
			if(diff < 0) {
				diff += 26;
			}
			diffString +=(char)(diff); 
		}
		return diffString;
    }
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		String[] arr = new String[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.next();
		}

		grouping(arr, n);
	}

}
