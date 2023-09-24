package group2Test;

import java.io.*;
import java.util.StringTokenizer;

public class BinaryPlay {
	
	/*
	 * We are given a series of Binary Strings. The first term in this series is 0. Hence, T1 = '0'.
To find the string at any given Ti, we look at Ti - 1 and replace all occurances of '0' with '01' and '1' with '10'.
You are given two integers N and X, your job is to find TN and return its Xth index.
Note: Ti are 1-indexed.
Input Format:
First line of input contains an integer T, representing the number of test cases.
The next T lines contains two space separated integers, N and X.
Constraints:
Output Format:
 Print the Xth index in Nth row
Sample Input:
1
4 5 
Sample Output:
1
Explanation:
T1: '0'
T2: '01'
T3: '0110'
T4: '01101001'
The 5th element in T4 is '1'.
	 */
	
	static public int binarySequence(int N, int X) {
        // Write your code here
		return 0;
    }

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int t = Integer.parseInt(br.readLine().trim());

        while (t != 0)
        {
            StringTokenizer tk = new StringTokenizer(br.readLine().trim());
            int n = Integer.parseInt(tk.nextToken());
            int x = Integer.parseInt(tk.nextToken());
            System.out.println(binarySequence(n, x));
            t--;
        }
        
    }

}
