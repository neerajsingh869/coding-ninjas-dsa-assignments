package optionalGraphs;

import java.util.Scanner;

public class MaximumScore {
	
	/*
	 * You are given a D- dimensional Euclidean space and N lattice points in which you have to play a game and maximise your score. You are given that the points are not connected initially. These points are not guaranteed to be distinct.
Let (A1, A2, ..., AD) and (B1, B2, ..., BD) be the coordinates of the points A and B respectively, then the distance between A and B is defined as ( (A1−B1)2 + (A2−B2)2 + ... + (AD−BD)2 )1/2.
Initially we let that your score is 1 and you can take as many turns as you wants. In every turn you have to connect an unconnected pair of two given points, if this new connection does not form a cycle. That is, you cannot connect the pair of points A and B, if there exist points X1, X2, ..., Xk such that A connected to X1, X1 connected to X2, X2 connected to X3,..., and Xk connected to B.
In every time you connect some points, your score is multiplied by the square of the distance between them.
Now you wonder what is the maximal score you can get. Write a program that will find your score. Since this number can be huge you should output it modulo 747474747.
Input Format:
The first line contains two space-separated-integers N and D. The next N lines contain D space-separated integers, denoting the coordinates of the given lattice points.
Output Format:
Output the maximal score that you can get modulo 747474747.
Constraints:
1 ≤ N ≤ 6666
1 ≤ D ≤ 5
The absolute value of any integer given in the input does not exceed 100000000 (108).
Sample Input:
3 3
0 0 0
1 1 -1
-1 1 1
Sample Output:
24
	 */
	
	static int maximalScore(int end, int ddimspace, long[][] coordinates){
	      // Write your code here
		return 1;
	    }
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int n, d;
        n = s.nextInt();
        d = s.nextInt();
      
        long[][] coordinates= new long[n][d];
    
        for(int i=0;i<n;i++){
          for(int j=0;j<d;j++){
            coordinates[i][j] = s.nextLong();
          }
        }

		System.out.print(maximalScore(n,d,coordinates));
	}	

}
