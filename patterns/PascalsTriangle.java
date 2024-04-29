package patterns;

public class PascalsTriangle {
	
	/*
	 * You are given an integer N. Your task is to print the pascal’s triangle 
	 * till the row N.

		A Pascal's triangle is a triangular array constructed by summing adjacent 
		elements in preceding rows. Pascal's triangle contains the values of the 
		binomial coefficient. For example in the figure below.
		
		
		
		For example, given integer N= 4 then you have to print.
		
		1  
		1 1 
		1 2 1 
		1 3 3 1
		
		Here for the third row, you will see that the second element is the 
		summation of the above two-row elements i.e. 2=1+1, and similarly for 
		row three 3 = 1+2 and 3 = 1+2.
		Detailed explanation ( Input/output format, Notes, Images )
		Constraints:
		1 <= T <= 40
		1 <= N <= 50
		
		Time Limit: 1 sec
		Sample Input 1 :
		3
		Sample Output 1:
		  1 
		 1 1 
		1 2 1 
		Sample Output 1 :
		6
		Sample Output 2 :
		     1 
		    1 1 
		   1 2 1 
		  1 3 3 1 
		 1 4 6 4 1
		1 5 10 10 5 1
	 */
	
	public static void pascalsTriangle1(int n) {
		int[] prevPattern = new int[1];
        if (n == 1) {
            System.out.print(n);
            return;
        }

        for (int i = 1; i <= n; i++) {
            // print spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // print pattern
            int[] currPattern = new int[i];
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    System.out.print("1 ");
                    currPattern[j - 1] = 1;
                } else {
                    System.out.print(prevPattern[j - 2] + prevPattern[j - 1] + " ");
                    currPattern[j - 1]  = prevPattern[j - 2] + prevPattern[j - 1];
                }
            }

            System.out.println();
            prevPattern = currPattern;
        }
	}
	
	public static void pascalsTriangle2(int n) {
		for (int i = 1; i <= n; i++) {
            // print spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // print pattern
            int value = 1;
            for (int j = 1; j <= i; j++) {
                System.out.print(value + " ");
                value = value * (i - j) / j;
            }

            System.out.println();
        }
	}

}
