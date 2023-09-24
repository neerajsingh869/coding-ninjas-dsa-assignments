package optionalRecursion;

import java.util.Scanner;

public class SpecialJump {
	
	/*
	 * In the jungle, Mother kangaroo is far away from his child kangaroo while some jungli animal came tries to hurt him. So, mother kangaroo wants to reach to his son as fast as possible. Help her to reach his son
Mother and child kangaroo are on 1D line (x-axis from -infinity to +infinity). Mother kangaroo is at origin(0) and child kangaroo is at some co-ordinate X. Mother kangaroo has special jump. In ith jump, she can take i steps forward or backward.
Help her to reach his son in minimum possible steps.
Input Format
Contains a single integer the position of his child kangaroo X
Output Format
The output contains the minimum no of steps in order to reach his son co-ordinate
Constraints
0 =< X <= 30 
Sample Input 1:
3
Sample Output 1:
2
Explaination
In the Sample case, first jump from 0 - 1 (1 step) and in the second step from 1 - 3 (2 steps) hence reach at co-ordinate after 2 jumps
	 */
	// Time Complexity -> O(2^n)
	public static int minSteps(int currentPosition, int destination, int jumpDistance){
		if(currentPosition == destination){
			return 0;
		}
		if(currentPosition > destination || currentPosition < -destination){
			return -1;
		}
		int forward = minSteps(currentPosition+jumpDistance, destination, jumpDistance + 1);
		int backward = minSteps(currentPosition-jumpDistance, destination, jumpDistance + 1);
		int ans = -1;
		if(forward != -1 && backward != -1){
			ans = 1 + Math.min(forward, backward);
		}
		else if(forward != -1){
			ans = 1 + forward;
		}
		else if(backward != -1){
			ans = 1 + backward;
		}
		else {
			ans = -1;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int ans = minSteps(0, x, 1);
		System.out.println(ans);
	}

}
