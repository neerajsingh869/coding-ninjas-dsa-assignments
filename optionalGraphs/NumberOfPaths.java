package optionalGraphs;

public class NumberOfPaths {
	
	/*
	 * A n x n grid is given, you have to traverse this grid from top left corner to the bottom right corner. But you can only move downwards and rightwards and there are some obstacles present in the grid. You have to tell how many paths are there from the start position to the goal position. If there are none, could you have made it to the goal if you could walk upwards and leftwards?
So, you have to write a program to tell the possible number of different ways to move from the top left corner(S) to bottom right(g) by just moving downwards and rightwards. If none, then print "THE GAME IS A LIE" i.e. if you cannot go from s to g going only rightwards and downwards but you can if you are allowed to go left and up as well, or "INCONCEIVABLE" if there simply is no path from s to g.
Input Format:
The first line contains an integer n. Then follows n lines, each with n characters, where each character is one of '.' and '#', where '.' is to be interpreted as a walkable cell and '#' as a non-walkable cell. 
Output Format:
The output line contains the number of different paths starting from s and ending at g (modulo 2^31 - 1) or "THE GAME IS A LIE" if you cannot go from s to g going only rightwards and downwards but you can if you are allowed to go left and up as well, or "INCONCEIVABLE" if there simply is no path from s to g.
Constraints:
1 < n <= 1000
There will never be an obstacle at s, and there will never be an obstacle at g
Sample Input:
4
.#.#
...#
.#..
....
Sample Output:
3
	 */
	
	/*
	 * 5
		..##.
		#....
		...##
		.....
		.##..
		
		12
		....########
		..##########
		#.........##
		..##########
		.###########
		............
		#...........
		##########..
		...........#
		........####
		............
		###.........
	 */
	
	public static void main(String[] args) {
		/* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

		// Write your code here

	}

}
