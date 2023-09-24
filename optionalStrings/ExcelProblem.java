package optionalStrings;

import java.util.Scanner;

public class ExcelProblem {
	
	/*
	 * In MS Excel you have columns pattern as A, B, C, … ,Z, AA, AB, AC,…. ,AZ, BA, BB, … ZZ, AAA, AAB ….. etc. This means, column 1 is named as “A”, column 2 as “B”, column 27 as “AA”.
You are given a column number, and you have to find its corresponding Excel column name
Input Format:
The only input line contains the column number.
Output Format:
The only output line contains the column name corresponding to the column number.
Constraints:
Value of n should lie between [0,999999999]
Sample Input:
23
Sample Output:
W
	 */
	
	private static String getExcelColumn(int n){
		String ans = "";
		while(n != 0){
			int rem = n%26;
			char ch = (char)('A' + rem - 1);
			ans = ch + ans;
			n/=26;
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(getExcelColumn(n));
	}

}
