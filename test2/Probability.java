package test2;

import java.util.Scanner;

public class Probability {
	
	/*
	 * An urn contains 8 balls : 4 red , 2 blue and 2 green. 
	 * Now n balls are drawn out of the urn. Calculate the 
	 * probability that out of n drawn balls exactly x balls are red.
	 * 
	 * Find your answer multiplied by 100 and return the integer part.
	 * 
	 * All required values for computation will be in integer range.
	 * 
	 * x is always less than equal to 4 and x is always less than equal to n.
	 */
	
	public static int fact(int n){
        int ans = 1;
        for(int i = 1; i<=n; i++){
            ans*=i;
        }
        return ans;
    }
    
    public static int ncr(int n, int r){
        return fact(n)/(fact(n-r)*fact(r));
    }
    
    public static int probability(int n,int x){
        int numerator = ncr(4, x)*ncr(4, n-x);
        float denominator = 1.0f*ncr(8, n);
        int ans = (int)((numerator/denominator)*100);
        return ans;
    }

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int x = s.nextInt();
		System.out.println(probability(n, x));
	}

}
