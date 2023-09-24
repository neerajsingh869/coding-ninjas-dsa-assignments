package fullTest2;

import java.util.Scanner;

public class RainbowArray {
	
	/*
	 * An array is Rainbow if it has the following structure:
1.  First a1 elements equal 1.
2.  Next a2 elements equal 2.
3.  Next a3 elements equal 3.
4.  Next a4 elements equal 4.
5.  Next a5 elements equal 5.
6.  Next a6 elements equal 6.
7.  Next a7 elements equal 7.
8.  Next a6 elements equal 6.
9.  Next a5 elements equal 5.
10. Next a4 elements equal 4.
11. Next a3 elements equal 3.
12. Next a2 elements equal 2.
13. Next a1 elements equal 1.
(Here a1,a2,a3... are number of elements).
14. ai can be any non-zero positive integer.
15. There are no other elements in array.
Find out if the given array is a Rainbow Array or not.
Input:
The first line of contains an integer N, denoting the number of elements in the given array.
The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of array.
Output:
 Output a line containing "yes" or "no" (without quotes) corresponding to the case if the array is rainbow array or not.
Constraints:
7 ≤ N ≤ 100
1 ≤ Ai ≤ 10
Sample Input 1:
19
1 2 3 4 4 5 6 6 6 7 6 6 6 5 4 4 3 2 1
Sample output 1:
Yes
Sample input 2:
12
1 2 3 4 5 6 6 5 4 3 2 1
Sample output 2:
No
(has no elements with value 7 after elements with value 6.)
Sample output 3:
14
1 1 2 3 4 5 6 7 6 5 4 3 2 1
Sample output 3:
No
(On the left we have two occurrences of 1, whereas on the right only one occurrence ). 
	 */
	
	public static void israinbow(int [] arr){
        // Write your code here
    }
	
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int n=s.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=s.nextInt();
		}
		israinbow(a);
		
	}
}