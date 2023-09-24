package optionalGraphs;

public class CollegeCourses {
	
	/*
	 * In a college there are a total of "N" courses, labelled from "0" to "N-1". You have to return whether it is possible to finish all the courses, if there are some prerequisites given.
The prerequisites are such that to pick course 1, you have to take course 0 first, which is represented as a pair (1 , 0).
Input Format:
The first line of input contains the value of N.
The second line of input gives you the number of prerequisites present.
The last line of input contains all the prerequisites in form of a list.
Output Format:
 The only output line contains 1, if it is possible to complete all the courses else it contains 0.
Constraints:
1<=N<=105
Sample Input 1:
4
3
0 1 1 2 2 0
Sample Output 1:
0
Explanation:
For, 0 pick 1
For, 1 pick 2
For, 2 pick 0
But for 0 you need to pick 1 , for 1 you need to pick 2, for 2 you need to pick 0 and the cycle goes on. So, it's impossible to complete the course.
Sample Input 2:
4
3
0 1 1 2 0 2
Sample Output 2:
1
Explanation:
For, 0 pick 1
For, 1 pick 2
For, 0 pick 2 too.
But for 0 you need to pick 1 and 2, for 1 you need to pick 2 So, it's possible to complete the course.
	 */
	
	public static void main(String[] args) {
		/* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

		// Write your code here

	}

}
