package patterns;

import java.util.Scanner;

public class DiamondPattern {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		// Top half pattern
		int i = 1;
		while(i<=n/2+1) {
			int space = 1;
			while(space<=(n/2)-i+1) {
				System.out.print(" ");
				space++;
			}
			int star = 1;
			while(star<=2*i-1) {
				System.out.print('*');
				star++;
			}
			System.out.println();
			i++;
		}
		int k = n/2;
		while(k>=1) {
			int space = 1;
			while(space<=(n/2)-k+1) {
				System.out.print(" ");
				space++;
			}
			int star = 1;
			while(star<=2*k-1) {
				System.out.print('*');
				star++;
			}
			System.out.println();
			k--;
		}
	}
	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = n/2;
//        for(int i = 1; i<=m+1; i++){
//            for(int j = 1; j<=m+1-i; j++){
//                System.out.print(" ");
//            }
//            for(int j = 1; j<=2*i-1; j++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//		for(int i = m; i>=1; i--){
//            for(int j = 1; j<=m+1-i; j++){
//                System.out.print(" ");
//            }
//            for(int j = 1; j<=2*i-1; j++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//	}

}
