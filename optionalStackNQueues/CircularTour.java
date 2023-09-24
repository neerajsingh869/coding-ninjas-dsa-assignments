package optionalStackNQueues;

import java.util.Scanner;

class Fuel_Pair {
	int petrol;
	int distance;

	Fuel_Pair(int petrol, int distance){
		this.petrol=petrol;
		this.distance=distance;
	}
}

public class CircularTour {
	
	/*
	 * There is a circle and there are N petrol pumps on that circle.
You have the following 2 sets of data:
1. Amount of petrol that each petrol pump has.
2. The distance of the next petrol pump from that petrol pump.
Write a function to find the first point from where the truck should start so that it could complete the whole circle. Print -1 if there is no starting point for the truck.
Note: There is no capacity limit of the truck and truck stops at each petrol pump and 1 liter of petrol can help the truck to move 1 unit.
Input Format:
The first line will contain an integer N denoting the number of petrol pumps and in the next line are N space-separated values petrol and distance denoting the amount of petrol every petrol pump has and the distance to the next petrol pump respectively.
Output Format:
The only line of output contains an integer of the starting point from where the truck should start so that it could complete the whole circle.
Constraints:
1 <= N <= 50
1 <= petrol, distance <= 100
Sample Input:
5
1 3 2 4 6 2 5 3 10 3
Sample output:
2
Explanation:
There are 4 petrol pumps with amount of petrol and distance to next petrol pump value pairs as {1, 3}, {2, 4}, {6, 2}, {5, 3} and {10, 3}. The first point from where truck can make a circular tour is 3rd petrol pump. Output in this case is 2 (index of 2nd petrol pump)
	 */
	
	static int findstart(Fuel_Pair[] fp_array, int n) {
		/*
			* Your class should be named Solution.
			* Write your code here
		 */
		return 0;

	}
	
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		Fuel_Pair[] fp_array = new Fuel_Pair[n];

		for(int i=0; i<n; i++) {
			int petrol = scn.nextInt();
			int distance = scn.nextInt();
			fp_array[i]= new Fuel_Pair(petrol, distance);
		}

		System.out.println(findstart(fp_array, n));

	}

}
