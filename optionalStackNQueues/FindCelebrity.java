package optionalStackNQueues;

import java.util.Scanner;

public class FindCelebrity {
	
	/*
	 * There is a party of N people, out of which only one person is known to everyone (known as the celebrity). That person may be present at the party or maybe not. If that person is present he(she) doesn't know anyone present at the party. We can only ask the question "does A know B? “. Find the celebrity in a minimum number of questions.
You will be given a square matrix M[][] where if an element of row i and column j is set to 1 it means the ith person knows the jth person. You need to complete the function which finds the celebrity if present else returns -1.
Note: Here M[i][i]=0
Input Format:
The first line of input contains the size of matrix M[][] and the following line of input contains the space-separated elements of matrix M[][].
Output Format:
The only output line contains an integer denoting the celebrity at the party.
Constraints:
Size of matrix M[][] should lie between the range [2,500].
Sample Input:
3
0 1 0 0 0 0 0 1 0
Sample Output:
1
Explanation;
The matrix for the above input is:
0 1 0
0 0 0 
0 1 0
Here,  the celebrity is the person with index 1. So, output will be 1.
	 */
	
	public static int celebrity(int[][] arr, int n) {
        //Write your code here
		return 0;
    }
	
	public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[][] arr = new int[n][n];

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                arr[i][j] = s.nextInt();
            }
        }

        System.out.print(celebrity(arr, n));
    }

}
