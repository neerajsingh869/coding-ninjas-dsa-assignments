package test1;

import java.util.Scanner;

public class NumberStarPattern {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for(int i = 1; i<=n; i++) {
			for(int j = n; j>=1; j--){
                if(i == j){
                    System.out.print("*");
                }
                else{
                    System.out.print(j);
                }
            }
			System.out.println();
		}
		s.close();
	}

}
