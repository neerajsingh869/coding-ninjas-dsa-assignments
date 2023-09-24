package patterns;

import java.util.Scanner;

public class SumPattern {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int i = 1;
		while(i<=n) {
			int sum = 0, j = 1;
			while(j<=i) {
				sum+=j;
				System.out.print(j);
				if(j!=i) {
					System.out.print("+");
				}
                else{
                    System.out.print("=");
                }
				j++;
			}
			System.out.println(sum);
			i++;
		}
	}

}
