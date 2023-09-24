package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair<T>{
	T vertex;
	T parentVertex;
	Pair(T vertex, T parentVertex){
		this.vertex = vertex;
		this.parentVertex = parentVertex;
	}
}

public class Graph {
	
	public static void dfTraversal(int[][] adjMatrix) {
		int v = adjMatrix.length;
        if(v == 0) {
        	return;
        }
		boolean[] isVisited = new boolean[v];
		// To handle for disconnected graphs
        for(int i = 0; i<v; i++){
            if(!isVisited[i]){
            	dfTraversal(adjMatrix, 0, isVisited);
            }
        }
	}
	
	private static void dfTraversal(int[][] adjMatrix, int sourceVertex, boolean[] isVisited) {
		int v = adjMatrix.length;
		isVisited[sourceVertex] = true;
		System.out.print(sourceVertex + " ");
		for(int newSourceVertex = 0; newSourceVertex<v; newSourceVertex++) {
			if(adjMatrix[sourceVertex][newSourceVertex] == 1 && !isVisited[newSourceVertex]) {
				dfTraversal(adjMatrix, newSourceVertex, isVisited);
			}
		}
	}
	
	/*
	 * Given an undirected and disconnected graph G(V, E), 
	 * print its BFS traversal.
	 * 
	 * Note:
			1. Here you need to consider that you need to print 
			BFS path starting from vertex 0 only. 
			2. V is the number of vertices present in graph G and 
			vertices are numbered from 0 to V-1. 
			3. E is the number of edges present in graph G.
			4. Take graph input in the adjacency matrix.
			5. Handle for Disconnected Graphs as well
	 */
	public static void bfTraversal(int[][] adjMatrix){
        int v = adjMatrix.length;
        if(v == 0) {
        	return;
        }
        boolean[] isVisited = new boolean[v];
        // To handle for disconnected graphs
        for(int i = 0; i<v; i++){
            if(!isVisited[i]){
            	bfTraversal(adjMatrix, i, isVisited);
            }
        }
    }

    public static void bfTraversal(int[][] adjMatrix, int sourceVertex, boolean[] isVisited){
        int v = adjMatrix.length;
        Queue<Integer> que = new LinkedList<>();
        que.add(sourceVertex);
        isVisited[sourceVertex] = true;
        while(!que.isEmpty()){
            int currVertex = que.poll();
            System.out.print(currVertex + " ");
            for(int i = 0; i<v; i++){
                if(adjMatrix[currVertex][i] == 1 && !isVisited[i]){
                    que.add(i);
                    isVisited[i] = true;
                }
            }
        }
    }
    
    // Space complexity in this approach is greater than the previous approach
    public static void bfTraversal2(int[][] adjMatrix, int sourceVertex, boolean[] isVisited){
        int v = adjMatrix.length;
        ArrayList<Integer> que = new ArrayList<>();
        que.add(sourceVertex);
        isVisited[sourceVertex] = true;
        int j = 0;
        while(j < que.size()){
            int currVertex = que.get(j);
            System.out.print(currVertex + " ");
            for(int i = 0; i<v; i++){
                if(adjMatrix[currVertex][i] == 1 && !isVisited[i]){
                    que.add(i);
                    isVisited[i] = true;
                }
            }
            j++;
        }
    }
    
    /*
     * Given an undirected graph G(V, E) and two vertices 
     * v1 and v2 (as integers), check if there exists any path 
     * between them or not. Print true if the path exists and 
     * false otherwise.
	 * 
	 * Note:
			1. V is the number of vertices present in graph G 
			and vertices are numbered from 0 to V-1. 
			2. E is the number of edges present in graph G.
     */
    public static boolean hasPath(int[][] adjMatrix, int v1, int v2){
		int v = adjMatrix.length;
		boolean[] isVisited = new boolean[v];
		return hasPathBFS(adjMatrix, v1, v2, isVisited);
	}

    public static boolean hasPathBFS(int[][] adjMatrix, int v1, int v2, boolean[] isVisited){
		int v = adjMatrix.length;
		// check for invalid inputs
		if(v1 >= v || v2 >= v){
			return false;
		}
		if(adjMatrix[v1][v2] == 1){
			return true;
		}
		Queue<Integer> que = new LinkedList<>();
		que.add(v1);
		isVisited[v1] = true;
		while(!que.isEmpty()){
			int currentVertex = que.poll();
			for(int i = 0; i<v; i++){
				if(adjMatrix[currentVertex][i] == 1 && !isVisited[i]){
					if(i == v2){
						return true;
					}
					else{
						isVisited[i] = true;
						que.add(i);
					}
				}
			}
		}
		return false;
	}
    
    public static boolean hasPathDFS(int[][] adjMatrix, int v1, int v2, boolean[] isVisited){
		int v = adjMatrix.length;
		if(v1 >= v || v2 >= v){
			return false;
		}
		// We can't use below condition since, we have to pick the
		// smallest neighbour first
//		if(adjMatrix[v1][v2] == 1){
//			return true;
//		}
		if(v1 == v2){
			return true;
		}
		isVisited[v1] = true;
		boolean ans = false;
		for(int i = 0; i<v; i++){
			if(adjMatrix[v1][i] == 1 && !isVisited[i]){
				ans = (ans || hasPathDFS(adjMatrix, i, v2, isVisited));
			}
		}
		return ans;
	}
    
    /*
     * Given an undirected graph G(V, E) and two vertices v1 and 
     * v2(as integers), find and print the path from v1 to v2 (if exists). 
     * Print nothing if there is no path between v1 and v2.
	 * 
	 * Find the path using DFS & BFS and print the first path that you encountered.
	 * 
	 * Note:
			1. V is the number of vertices present in graph G and vertices 
			are numbered from 0 to V-1. 
			2. E is the number of edges present in graph G.
			3. Print the path in reverse order. That is, print v2 first, 
			then intermediate vertices and v1 at last.
			4. Save the input graph in Adjacency Matrix.
     */
    public static void getPathUsingString(int[][] adjMatrix, int v1, int v2){
		int v = adjMatrix.length;
		if(v == 0){
			return;
		}
		boolean[] isVisited = new boolean[v];
		getPathDFSUsingString(adjMatrix, v1, v2, isVisited, "");
	}

	public static boolean getPathDFSUsingString(int[][] adjMatrix, int v1, int v2, boolean[] isVisited, String ansTillNow){
		int v = adjMatrix.length;
		if(v1 >= v || v2 >= v){
			return false;
		}
		if(v1 == v2){
			System.out.print(v2 + " " + ansTillNow);
			return true;
		}
		boolean gotAns = false;
		isVisited[v1] = true;
		for(int i = 0; i<v; i++){
			if(adjMatrix[v1][i] == 1 && !isVisited[i]){
				// If gotAns become true, then it will not invoke the function again
				gotAns = (gotAns || getPathDFSUsingString(adjMatrix, i, v2, isVisited, v1 + " " + ansTillNow));
				
				// Even though the above statement will give you only one path,
				// but still the better practice is given below-
				if(gotAns == true){
					break;
				}
			}
		}
		return gotAns;
	}
	
	public static void getPathUsingArrayList(int[][] adjMatrix, int v1, int v2){
		int v = adjMatrix.length;
		if(v == 0){
			return;
		}
		boolean[] isVisited = new boolean[v];
		ArrayList<Integer> path = getPathDFSUsingArrayList(adjMatrix, v1, v2, isVisited);
		if(path != null){
			for(int ele : path){
				System.out.print(ele + " ");
			}
		}
	}

	public static ArrayList<Integer> getPathDFSUsingArrayList(int[][] adjMatrix, int v1, int v2, boolean[] isVisited){
		int v = adjMatrix.length;
		ArrayList<Integer> ans = null;
		if(v1 >= v || v2 >= v){
			return ans;
		}
		if(v1 == v2){
			ans = new ArrayList<>();
			ans.add(v2);
			return ans;
		}
		isVisited[v1] = true;
		for(int i = 0; i<v; i++){
			if(adjMatrix[v1][i] == 1 && !isVisited[i]){
				ArrayList<Integer> tempAns = getPathDFSUsingArrayList(adjMatrix, i, v2, isVisited);
				if(tempAns != null){
					tempAns.add(v1);
					ans = tempAns;
					break;
				}
			}
		}
		return ans;
	}
	
	public static ArrayList<Integer> getPathBFSUsingArrayList(int[][] adjMatrix, int v1, int v2, boolean[] isVisited){
		int v = adjMatrix.length;
		if(v1 >= v || v2 >= v){
			return null;
		}
		ArrayList<Pair<Integer>> que = new ArrayList<>();
		que.add(new Pair<>(v1, -1));
		isVisited[v1] = true;
		int j = 0;
		ArrayList<Integer> ans = null;
		while (j < que.size()) {
			Pair<Integer> p = que.get(j);
			int currVertex = p.vertex;
			if(currVertex == v2){
				ans = new ArrayList<>();
				while(p.parentVertex != -1){
					ans.add(p.vertex);
					for(int k = 0; k<j; k++){
						if(que.get(k).vertex.equals(p.parentVertex)){
							p = que.get(k);
							break;
						}
					}
				}
				ans.add(p.vertex);
				break;
			}
			for (int i = 0; i < v; i++) {
				if (adjMatrix[currVertex][i] == 1 && !isVisited[i]) {
					que.add(new Pair<>(i, currVertex));
					isVisited[i] = true;
				}
			}
			j++;
		}
		return ans;
	}
	
	// Optimized version
	public static ArrayList<Integer> getPathBFSUsingArrayListOpt(int[][] adjMatrix, int v1, int v2, boolean[] isVisited){
		int v = adjMatrix.length;
		if(v1 >= v || v2 >= v){
			return null;
		}
		Queue<Integer> que = new LinkedList<>();
		// key -> vertex and value -> parent vertex
		HashMap<Integer, Integer> map = new HashMap<>();
		que.add(v1);
		map.put(v1, -1);
		isVisited[v1] = true;
		ArrayList<Integer> ans = null;
		while (!que.isEmpty()) {
			int currVertex = que.poll();
			if(currVertex == v2){
				ans = new ArrayList<>();
				int i = currVertex;
				while(map.get(i) != -1){
					ans.add(i);
					i = map.get(i);
				}
				ans.add(i);
				break;
			}
			for (int i = 0; i < v; i++) {
				if (adjMatrix[currVertex][i] == 1 && !isVisited[i]) {
					que.add(i);
					map.put(i, currVertex);
					isVisited[i] = true;
				}
			}
		}
		return ans;
	}
	
	public static ArrayList<Integer> getPathBFSUsingArrayListBest(int[][] adjMatrix, int v1, int v2, boolean[] isVisited){
		int v = adjMatrix.length;
		Queue<Integer> que = new LinkedList<>();
		// key -> vertex and value -> parent vertex
		HashMap<Integer, Integer> map = new HashMap<>();
		que.add(v1);
		map.put(v1, -1);
		isVisited[v1] = true;
		while (!que.isEmpty()) {
			int currVertex = que.poll();
			for (int i = 0; i < v; i++) {
				if (adjMatrix[currVertex][i] == 1 && !isVisited[i]) {
					que.add(i);
					map.put(i, currVertex);
					if(i == v2){
						ArrayList<Integer> ans = new ArrayList<>();
						int vertex = i;
						while(map.get(vertex) != -1){
							ans.add(vertex);
							vertex = map.get(vertex);
						}
						ans.add(vertex);
						return ans;
					}
					isVisited[i] = true;
				}
			}
		}
		return null;
	}
	
	/*
	 * Given an undirected graph G(V,E), check if the graph 
	 * G is connected graph or not.
	 * 
	 * Note:
			1. V is the number of vertices present in graph G 
			and vertices are numbered from 0 to V-1. 
			2. E is the number of edges present in graph G.
	 */
	public static boolean isConnected(int[][] adjMatrix){
		int v = adjMatrix.length;
		if(v == 0){
			return true;
		}
		boolean[] isVisited = new boolean[v];
//		dfTraversal(adjMatrix, 0, isVisited);
		bfTraversal(adjMatrix, 0, isVisited);
		for(int i = 0; i<v; i++){
			if(!isVisited[i]){
				return false;
			}
		}
		return true;
	}
	
	/*
	 * Given an undirected graph G(V,E), find and print all the 
	 * connected components of the given graph G.
	 * 
	 * Note:
			1. V is the number of vertices present in graph G and 
			vertices are numbered from 0 to V-1. 
			2. E is the number of edges present in graph G.
			3. You need to take input in main and create a function 
			which should return all the connected components. And 
			then print them in the main, not inside function.
		
		Print different components in new line. And each component 
		should be printed in increasing order (separated by space). 
		Order of different components doesn't matter.
	 */
	public static void printAllConnectedComponents(int[][] adjMatrix) {
		int v = adjMatrix.length;
		if (v == 0) {
			return;
		}
		int[] isVisited = new int[v];
		for(int i = 0; i<v; i++){
			isVisited[i] = -1;
		}
		int currVertex = 0;
		while(currVertex < v){
			modifiedBfTraversal(adjMatrix, currVertex, isVisited);
			int nextVertex = -1;
			boolean isNextVertexFound = false;
			for(int j = 0; j<v; j++){
				if(!isNextVertexFound && isVisited[j] == -1){
					nextVertex = j;
					isNextVertexFound = true;
				}
				if(isVisited[j] == currVertex){
					System.out.print(j + " ");
				}
			}
			System.out.println();
			if(!isNextVertexFound){
				break;
			}
			currVertex = nextVertex;
		}
	}

	public static void modifiedBfTraversal(int[][] adjMatrix, int sourceVertex, int[] isVisited) {
		int v = adjMatrix.length;
		Queue<Integer> que = new LinkedList<>();
		que.add(sourceVertex);
		isVisited[sourceVertex] = sourceVertex;
		while (!que.isEmpty()) {
			int currVertex = que.poll();
			for (int i = 0; i < v; i++) {
				if (adjMatrix[currVertex][i] == 1 && isVisited[i] != sourceVertex) {
					que.add(i);
					isVisited[i] = sourceVertex;
				}
			}
		}
	}
	
	// 2nd and Better approach
	public static void printAllConnectedComponentsBetter(int[][] adjMatrix) {
		int v = adjMatrix.length;
		if (v == 0) {
			return;
		}
		boolean[] isVisited = new boolean[v];
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i = 0; i<v; i++){
			if(!isVisited[i]){
				ArrayList<Integer> component = modifiedBfTraversalBetter(adjMatrix, i, isVisited);
				ans.add(component);
			}
		}
		int n = ans.size();
		for(int i = 0; i<n; i++){
			int m = ans.get(i).size();
			for(int j = 0; j<m; j++){
				System.out.print(ans.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	public static ArrayList<Integer> modifiedBfTraversalBetter(int[][] adjMatrix, int sourceVertex, boolean[] isVisited) {
		int v = adjMatrix.length;
		ArrayList<Integer> comp = new ArrayList<>();
		Queue<Integer> que = new LinkedList<>();
		que.add(sourceVertex);
		comp.add(sourceVertex);
		isVisited[sourceVertex] = true;
		while (!que.isEmpty()) {
			int currVertex = que.poll();
			for (int i = 0; i < v; i++) {
				if (adjMatrix[currVertex][i] == 1 && !isVisited[i]) {
					comp.add(i);
					que.add(i);
					isVisited[i] = true;
				}
			}
		}
		Collections.sort(comp);
		return comp;
	}
	
	/*
	 * Given a graph with N vertices (numbered from 0 to N-1) and 
	 * M undirected edges, then count the distinct 3-cycles in the graph. 
	 * A 3-cycle PQR is a cycle in which (P,Q), (Q,R) and (R,P) are 
	 * connected by an edge.
	 */
	public static int countNumberOf3Cycles(int[][] adjMatrix, int n) {
		int count = 0;
		for(int i = 0; i<n; i++){
			for(int j = i+1; j<n; j++){
				for(int k = j+1; k<n; k++){
					if(adjMatrix[i][k] == 1 && adjMatrix[i][j] == 1 && adjMatrix[j][k] == 1){
						count++;
					}
				}
			}
		}
		return count;
	}
	
	/*
	 * It's Gary's birthday today and he has ordered his favourite square 
	 * cake consisting of '0's and '1's . But Gary wants the biggest piece 
	 * of '1's and no '0's . A piece of cake is defined as a part which 
	 * consist of only '1's, and all '1's share an edge with each other 
	 * on the cake. Given the size of cake N and the cake, can you find 
	 * the count of '1's in the biggest piece of '1's for Gary ?
	 */
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static int largestPiece(String[] edge, int n) {
		boolean[][] isVisited = new boolean[n][n];
		int ans = 0;
		for(int i = 0; i<n; i++){
			for(int j = 0; j<n; j++){
				if(edge[i].charAt(j) == '1' && !isVisited[i][j]){
					ans = Math.max(ans, dfs(edge, isVisited, i, j, n));
				}
			}
		}
		return ans;
	}

	private static int dfs(String[] edge, boolean[][] isVisited, int i, int j, int n){
		if(i < 0 || j < 0 || i >= n || j >= n || isVisited[i][j] || edge[i].charAt(j) != '1'){
			return 0;
		}
		int countVertex = 0;
		isVisited[i][j] = true;
		countVertex++;
		for(int k = 0; k<dir.length; k++){
			int newI = i + dir[k][0];
			int newJ = j + dir[k][1];
			countVertex += dfs(edge, isVisited, newI, newJ, n);
		}
		return countVertex;
	}
	
	/*
	 * Gary has a board of size NxM. Each cell in the board is a 
	 * coloured dot. There exist only 26 colours denoted by 
	 * uppercase Latin characters (i.e. A,B,...,Z). Now Gary 
	 * is getting bored and wants to play a game. The key of 
	 * this game is to find a cycle that contain dots of same 
	 * colour. Formally, we call a sequence of dots d1, d2, ..., 
	 * dk a cycle if and only if it meets the following condition:
	 * 
			1. These k dots are different: if i ≠ j then di is different 
			from dj.
			2. k is at least 4.
			3. All dots belong to the same colour.
			4. For all 1 ≤ i ≤ k - 1: di and di + 1 are adjacent. 
			Also, dk and d1 should also be adjacent. Cells x and y are 
			called adjacent if they share an edge.
	 * 
	 * Since Gary is colour blind, he wants your help. Your task is 
	 * to determine if there exists a cycle on the board.
	 */
	int circleFound = 0;
	int connectingDots(String[] board , int n, int m)
	{
		boolean[][] isVisited = new boolean[n][m];
		for(int i = 0; i<n; i++){
			for(int j = 0; j<m; j++){
				if(!isVisited[i][j]){
					connectingDotsDfs(board, isVisited, i, j, -1, -1, board[i].charAt(j), n, m);
				}
			}
		}
		return circleFound;
	}
	
	void connectingDotsDfs(String[] board, boolean[][] isVisited, int i, int j, int fromI, int fromJ, char dotColor, int n, int m){
		if(i < 0 || j < 0 || i >= n || j >=m || board[i].charAt(j) != dotColor){
			return;
		}
		// Circle found
		if(isVisited[i][j]){
			circleFound = 1;
			return;
		}
		isVisited[i][j] = true;
		for(int k = 0; k<dir.length; k++){
			int newI = i + dir[k][0];
			int newJ = j + dir[k][1];
			if(newI == fromI && newJ == fromJ){
				continue;
			}
			connectingDotsDfs(board, isVisited, newI, newJ, i, j, dotColor, n, m);
		}
	}
	
	/*
	 * An island is a small piece of land surrounded by water. 
	 * A group of islands is said to be connected if we can 
	 * reach from any given island to any other island in the 
	 * same group. Given V islands (numbered from 0 to V-1) 
	 * and E connections or edges between islands. Can you 
	 * count the number of connected groups of islands.
	 */
	public static int numConnected(int[][] edges, int n) {
		int v = n;
		if(v == 0){
			return 0;
		}
		boolean[] isVisited = new boolean[v];
		int count = 0;
		for(int i = 0; i<v; i++){
			if(!isVisited[i]){
				// Can traverse using dfs also
				numConnectedBfs(edges, i, isVisited);
				count++;
			}
		}
		return count;
	}

	public static void numConnectedBfs(int[][] adjMatrix, int sourceVertex, boolean[] isVisited) {
		int v = adjMatrix.length;
		Queue<Integer> que = new LinkedList<>();
		que.add(sourceVertex);
		isVisited[sourceVertex] = true;
		while (!que.isEmpty()) {
			int currVertex = que.poll();
			for (int i = 0; i < v; i++) {
				if (adjMatrix[currVertex][i] == 1 && !isVisited[i]) {
					que.add(i);
					isVisited[i] = true;
				}
			}
		}
	}
	
	/*
	 * Given a NxM matrix containing Uppercase English Alphabets 
	 * only. Your task is to tell if there is a path in the given 
	 * matrix which makes the sentence “CODINGNINJA” .
	 * 
	 * There is a path from any cell to all its neighbouring cells. 
	 * For a particular cell, neighbouring cells are those cells that 
	 * share an edge or a corner with the cell.
	 */
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		int[][] adjMatrix = new int[v][v];
		for(int i = 0; i<e; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			adjMatrix[v1][v2] = 1;
			adjMatrix[v2][v1] = 1;
		}
		int v1 = sc.nextInt();
		int v2 = sc.nextInt();
		// Printing the Adjacency Matrix
		System.out.println();
		for(int i = 0; i<v; i++) {
			for(int j = 0; j<v; j++) {
				System.out.print(adjMatrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
//		dfTraversal(adjMatrix);
		getPathUsingString(adjMatrix, v1, v2);
	}

}
