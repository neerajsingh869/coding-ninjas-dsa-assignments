package optionalStackNQueues;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Pair {
	int x;
	int y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class RottenOranges {
	
	/*
	 * You are given a 2D array of integers of size N * M. Each of the cell contains either of these 3 integers: 0, 1, 2. The integer 2 denotes a rotten orange, 1 denotes a fresh orange and 0 denotes an empty cell.
	Each rotten orange can rot fresh oranges in 4 adjacent cells in 1 unit of time. The 4 cells are left, right, top and bottom cell.
	For a given matrix, find the minimum units of time in which all oranges become rot. Return -1, if it is not possible.
	Input Format:
	The first line of input contains 2 space separated integers, N and M, that denotes size of given 2D array.
	The following N lines contains M space separated integers, that denotes the value of cells of given 2D array.
	Constraints:
	Value of N and M lies in the range: [1, 10000].
	Value of each cell in 2D array can be either 0, 1 or 2.
	Output Format:
	Print the required integer, as described in the problem description.   
	Sample Input 1:
	3 5
	2 1 0 2 1
	1 0 1 2 1
	1 0 0 2 1
	Sample Output 1:
	2
	Explanation:
	 In the first unit of time, fresh oranges at coordinates: (0, 1), (0, 4), (1, 0), (1, 2), (1, 4), (2, 4).
	 In the second unit of time, fresh orange at coordinate: (2, 0) gets rot. Hence, in 2 units of time, all the fresh oranges become rot.
	Sample Input 2:
	3 5
	2 1 0 2 1
	1 0 1 0 1
	1 0 0 0 2
	Sample Output 2:
	-1
	Explanation:
	It is impossible to rot the fresh orange at (1, 2).  
	 */
	
	// Time complexity -> O(n*m), Space complexity -> O(n*m)
	public static int timeToRot(int[][] arr){
		int n = arr.length;
		if(n == 0){
			return -1;
		}
		int m = arr[0].length;
		Queue<Pair> que = new LinkedList<>();
		// Add current rotten oranges in Queue
		for(int i = 0; i<n; i++){
			for(int j = 0; j<m; j++){
				if(arr[i][j] == 2){
					que.add(new Pair(i, j));
				}
			}
		}
		int time = 0;
		que.add(null);
		// To rot oranges
		while(!que.isEmpty()){
			Pair curr = que.poll();
			if(curr == null){
				if(que.isEmpty()){
					break;
				}
				else{
					time++;
					que.add(null);
				}
			}
			else{
				int currX = curr.x;
				int currY = curr.y;
				if(currX+1 < n && arr[currX+1][currY] == 1){
					arr[currX+1][currY] = 2;
					que.add(new Pair(currX+1, currY));
				}
				if(currX-1 >=0 && arr[currX-1][currY] == 1){
					arr[currX-1][currY] = 2;
					que.add(new Pair(currX-1, currY));
				}
				if(currY+1 < m && arr[currX][currY+1] == 1){
					arr[currX][currY+1] = 2;
					que.add(new Pair(currX, currY+1));
				}
				if(currY-1 >=0 && arr[currX][currY-1] == 1){
					arr[currX][currY-1] = 2;
					que.add(new Pair(currX, currY-1));
				}
			}
		}
		// To check whether all oranges are rotten or not
		for(int i = 0; i<n; i++){
			for(int j = 0; j<m; j++){
				if(arr[i][j] == 1){
					return -1;
				}
			}
		}
		// If all oranges are rooten, then only return time
		return time;
	}

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n][m];
		for(int i = 0; i<n; i++){
			for(int j = 0; j<m; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		System.out.println(timeToRot(arr));
	}

}
