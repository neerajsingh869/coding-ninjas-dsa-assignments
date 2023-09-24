package arrays2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;

public class QueryAndMatrix {
	
	/*
	 * You are given a binary matrix with ‘M’ rows and ‘N’ columns initially consisting of all 0s. 'Q' queries follow. The queries can be of 4 types:
		Query 1: 1 R index
		Query 2: 1 C index 
		Query 3: 2 R index
		Query 4: 2 C index
		
		In each query, the first input is the type of the query, the second input is whether we have to consider the row ('R') or the column ('C') and the third input is the index of the row/column. 
		
		For each type 1 query, we need to flip the elements of the row/column having the given index. 
		
		For each type 2 query, we have to output the number of zeros present in the row/column having the given index. 
		Note:
		Note that the matrix is a binary matrix, meaning that it only contains either 0 or 1.
		Example :
		Given M = 3, N = 3, 
		Queries : 1R1, 1R2, 2C1
		
		So, in the above example the change in the matrix would look like this:
		Example
		
		Next query 2C1 will return the count of the number of zeroes in the 1st column: 1
		Input Format:
		The first line contains an integer ‘T’ which denotes the number of test cases.
		
		The first line of each test case contains two space-separated integers ‘M’ and ‘N’, denoting the dimensions of the matrix.
		
		The next line contains a single integer ‘Q’ denoting the number of queries.
		
		The next ‘Q’ lines of each test contain the queries.
		Output Format:
		For each test case, return a single integer denoting the number of zeroes according to the given query of type 2.
		
		Print the output of each test case in a separate line.
		Note:
		You don’t need to print anything; It has already been taken care of. Juts implement the given function.
		Constraints:
		1 <= T <= 10
		1 <= M, N  <= 100
		1 <= Q <= 1000
		1 <= R <= M
		1 <= C <= N
		type = 1, 2
		
		Time limit: 1 sec
		Sample Input 1:
		2
		3 3
		3
		1R1
		1R2
		2C1
		2 2
		1
		2R1
		Sample Output 1:
		1
		2
		Explanation of Sample Output 1:
		In test case 1, Next query 2C1 will return the count of the number of zeroes in the 1st column: 1
		
		In test case 2, all the matrix elements are zero and hence the count of zeroes will be 2 for the first row.
		Sample Input 2:
		2
		3 3
		4
		2C1
		1R1
		1R1
		2R1
		2 2
		5
		2C1
		1R1
		1R1
		1R1
		2R1
		Sample Output 2:
		3 3
		2 0
		Explanation of Sample Output 2:
		In test case 1, 
		
		First query 2C1 will return the count of the number of zeroes in the 1st column: 3
		
		Next query 2R1 will return the count of the number of zeroes in the 1st column: 3
		
		The change in the matrix after the second and third queries would look like this:
		Example
		
		In test case 2,
		
		First query 2C1 will return the count of the number of zeroes in the 1st column: 2
		
		Next query 2R1 will return the count of the number of zeroes in the 1st column: 0
	 */
	
	public static ArrayList<Integer> query(ArrayList<ArrayList<Integer>> mat, int m, int n, ArrayList<String> q) {
		int totalQueries = q.size();
		ArrayList<Integer> ans = new ArrayList<>();
		for(int k = 0; k<totalQueries; k++){
			int queryType =(int)(q.get(k).charAt(0)-'0');
			boolean isRow = (q.get(k).charAt(1) == 'R') ? true : false;
			int rowOrColIdx = (int)(q.get(k).charAt(2)-'0');
			if(queryType == 1){
				if(isRow){
					for(int j = 0; j<n; j++){
						int flippedValue = (mat.get(rowOrColIdx).get(j) == 0) ? 1 : 0;
						mat.get(rowOrColIdx).set(j, flippedValue);
					}
				}
				else{
					for(int i = 0; i<m; i++){
						int flippedValue = (mat.get(i).get(rowOrColIdx) == 0) ? 1 : 0;
						mat.get(i).set(rowOrColIdx, flippedValue);
					}
				}
			}
			else{
				int count0 = 0;
				if(isRow){
					for(int j = 0; j<n; j++){
						count0 += (mat.get(rowOrColIdx).get(j) == 0) ? 1 : 0;
					}
				}
				else{
					for(int i = 0; i<m; i++){
						count0 += (mat.get(i).get(rowOrColIdx) == 0) ? 1 : 0;
					}
				}
				ans.add(count0);
			}
		}
		return ans;
	}
	
	private static int t;
	static ArrayList<Integer> allN;
	static ArrayList<Integer> allM;
	static ArrayList<Integer> allQ;
	static ArrayList<ArrayList<String>> allArr;
	static ArrayList<ArrayList<ArrayList<Integer>>> allMat;

	private static void takeInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine().split(" ")[0]);

		allN = new ArrayList<Integer>(t);
		allM = new ArrayList<Integer>(t);
		allQ = new ArrayList<Integer>(t);
		allMat = new ArrayList<ArrayList<ArrayList<Integer>>>(t);
		allArr = new ArrayList<ArrayList<String>>(t);
		for (int i = 0; i < t; i++) {
			String nums[] = br.readLine().split(" ");

			allM.add(Integer.parseInt(nums[0]));
			allN.add(Integer.parseInt(nums[1]));

			ArrayList<ArrayList<Integer>> mat = new ArrayList<ArrayList<Integer>>();
			for (int l = 0; l < allM.get(i); l++) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				for (int r = 0; r < allN.get(i); r++) {
					temp.add(0);
				}
				mat.add(temp);
			}

			allMat.add(mat);
			nums = br.readLine().split(" ");
			allQ.add(Integer.parseInt(nums[0]));

			ArrayList<String> temp = new ArrayList<String>(allQ.get(i));

			for (int j = 0; j < allQ.get(i); j++) {
				nums = br.readLine().split(" ");
				temp.add(nums[0]);
			}

			allArr.add(temp);
		}
	}

	private static void execute() {
		ArrayList<ArrayList<String>> allArrCopy = new ArrayList<ArrayList<String>>(allArr);
		ArrayList<ArrayList<ArrayList<Integer>>> allMatCopy = new ArrayList<ArrayList<ArrayList<Integer>>>(allMat);

		for (int i = 0; i < t; i++) {

			query(allMatCopy.get(i), allM.get(i), allN.get(i), allArrCopy.get(i));
		}
	}

	private static void executeAndPrintOutput() {
		ArrayList<ArrayList<String>> allArrCopy = new ArrayList<ArrayList<String>>(allArr);
		ArrayList<ArrayList<ArrayList<Integer>>> allMatCopy = new ArrayList<ArrayList<ArrayList<Integer>>>(allMat);

		for (int i = 0; i < t; i++) {

			ArrayList<Integer> ans = query(allMatCopy.get(i), allM.get(i), allN.get(i), allArrCopy.get(i));
//			for (int u : ans) {
//				System.out.print(u + " ");
//			}
//			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		takeInput();
		executeAndPrintOutput();
	}

}
