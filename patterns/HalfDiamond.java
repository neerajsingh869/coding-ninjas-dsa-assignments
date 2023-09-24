package patterns;

import java.util.Scanner;

public class HalfDiamond {
	
	private static void halfDiamond1(int n) {
		// Top half
		System.out.println('*');
		int i = 1;
		while(i<=n) {
			System.out.print('*');
			int ele = 1;
			while(ele<=i) {
				System.out.print(ele);
				ele++;
			}
			ele = ele-2;
			while(ele>=1) {
				System.out.print(ele);
				ele--;
			}
			System.out.println('*');
			i++;
		}
		// Bottom half
		int k = n-1;
		while(k>=1) {
			System.out.print('*');
			int ele = 1;
			while(ele<=k) {
				System.out.print(ele);
				ele++;
			}
			ele = ele-2;
			while(ele>=1) {
				System.out.print(ele);
				ele--;
			}
			System.out.println('*');
			k--;
		}
		System.out.println('*');
	}
	
	private static void halfDiamond2(int n) {
		System.out.println("*");
        for(int i = 1; i<=n; i++){
            int num = 1;
            for(int j =  1; j<=2*i+1; j++){
                // for stars
                if(j == 1 || j == 2*i+1){
                    System.out.print("*");
                }
                else{
                    if(j <= i){
                        System.out.print(num++);
                    }
                    else{
                        System.out.print(num--);
                    }
                }
            }
            System.out.println();
        }
        for(int i = n-1; i>=1; i--){
            int num = 1;
            for(int j =  1; j<=2*i+1; j++){
                // for stars
                if(j == 1 || j == 2*i+1){
                    System.out.print("*");
                }
                else{
                    if(j <= i){
                        System.out.print(num++);
                    }
                    else{
                        System.out.print(num--);
                    }
                }
            }
            System.out.println();
        }
        System.out.print("*");
	}
	
	// Best and Simple approach
	private static void halfDiamond3(int n){
        System.out.println("*");
        for(int i = 1; i<=n; i++){
            System.out.print("*");
            for(int j = 1; j<=i; j++){
                System.out.print(j);
            }
            for(int j = i-1; j>=1; j--){
                System.out.print(j);
            }
            System.out.println("*");
        }
        for(int i = n-1; i>=1; i--){
            System.out.print("*");
            for(int j = 1; j<=i; j++){
                System.out.print(j);
            }
            for(int j = i-1; j>=1; j--){
                System.out.print(j);
            }
            System.out.println("*");
        }
        System.out.print("*");
    }

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		halfDiamond3(n);
	}

}
