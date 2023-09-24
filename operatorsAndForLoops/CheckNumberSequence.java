package operatorsAndForLoops;

import java.util.Scanner;

public class CheckNumberSequence {

	/*
	 * You are given S, a sequence of n integers i.e. 
	 * S = s1, s2, ..., sn. Compute if it is possible 
	 * to split S into two parts : s1, s2, ..., si and 
	 * si+1, si+2, ….., sn (0 <= i <= n) in such a way 
	 * that the first part is strictly decreasing while 
	 * the second is strictly increasing one.
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        boolean isIncreasing = false, ans = true;
        for(int i = 0; i<n-1; i++){
            if(arr[i+1] > arr[i]){
                isIncreasing = true;
            }
            if((isIncreasing && arr[i+1] <= arr[i]) || arr[i+1] == arr[i]){
                ans = false;
                break;
            }
        }
        System.out.println(ans);
	}
	
	// Another way of solving the problem
	
//	public static void main(String[] args) {
//		// Write your code here
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int prev = sc.nextInt();
//        boolean isInc = false;
//        while(n > 1){
//            int curr = sc.nextInt();
//            if(prev == curr){
//                System.out.println("false");
//                return;
//            }
//            if(curr > prev){
//                isInc = true;
//            }
//            else{
//                if(isInc){
//					System.out.println("false");
//                	return;
//                }
//            }
//            n--;
//            prev = curr;
//        }
//        System.out.println("true");
//	}

}
