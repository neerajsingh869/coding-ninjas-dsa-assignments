package graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KruskalsAlgorithmBrute {
	
	/*
	 * Given an undirected, connected and weighted graph G(V, E) 
	 * with V number of vertices (which are numbered from 0 to V-1) 
	 * and E number of edges.
	 * 
	 * Find and print the Minimum Spanning Tree (MST) using Kruskal's algorithm.
	 * 
	 * For printing MST follow the steps -
			1. In one line, print an edge which is part of MST in the format - 
			v1 v2 w
			where, v1 and v2 are the vertices of the edge which is included 
			in MST and whose weight is w. And v1  <= v2 i.e. print the 
			smaller vertex first while printing an edge.
			2. Print V-1 edges in above format in different lines.
	 * Note : Order of different edges doesn't matter.

	 * Input Format :
	   Line 1: Two Integers V and E (separated by space)
	   Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi (separated by space)
	 
	 * Output Format :
	   Print the MST, as described in the task.
	 
	 * Constraints :
		2 <= V, E <= 10^5
		Time Limit: 1 sec
	 
	 * Sample Input 1 :
		4 4
		0 1 3
		0 3 5
		1 2 1
		2 3 8
		Sample Output 1 :
		1 2 1
		0 1 3
		0 3 5
	 */
	
	public static void printMST(int[][] adjMatrix, int[] edgeWeights) {
		int v = adjMatrix.length;
		int edgeCount = 0;
		int[][] adjMatrix2 = new int[v][v];
		for (int k = 0; k < edgeWeights.length; k++) {
			for (int i = 0; i < v; i++) {
				for (int j = 0; j < v; j++) {
					if (adjMatrix[i][j] == edgeWeights[k]) {
						if (!hasPath(adjMatrix2, i, j)) {
							adjMatrix2[i][j] = 1;
							adjMatrix2[j][i] = 1;
							System.out.println(i + " " + j + " " + edgeWeights[k]);
							edgeCount++;
						}
					}
				}
			}
			if (edgeCount == v - 1) {
				break;
			}
		}
	}

	public static boolean hasPath(int[][] adjMatrix, int v1, int v2) {
		int v = adjMatrix.length;
		boolean[] isVisited = new boolean[v];
		return hasPathBFS(adjMatrix, v1, v2, isVisited);
	}

	public static boolean hasPathBFS(int[][] adjMatrix, int v1, int v2, boolean[] isVisited) {
		int v = adjMatrix.length;
		// check for invalid inputs
		if (v1 >= v || v2 >= v) {
			return false;
		}
		if (adjMatrix[v1][v2] == 1) {
			return true;
		}
		Queue<Integer> que = new LinkedList<>();
		que.add(v1);
		isVisited[v1] = true;
		while (!que.isEmpty()) {
			int currentVertex = que.poll();
			for (int i = 0; i < v; i++) {
				if (adjMatrix[currentVertex][i] == 1 && !isVisited[i]) {
					if (i == v2) {
						return true;
					} else {
						isVisited[i] = true;
						que.add(i);
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int[][] adjMatrix = new int[V][V];
		int[] edgeWeights = new int[E];
		for (int i = 0; i < E; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int e = sc.nextInt();
			edgeWeights[i] = e;
			adjMatrix[v1][v2] = e;
			adjMatrix[v2][v1] = e;
		}
		Arrays.sort(edgeWeights);
		printMST(adjMatrix, edgeWeights);
	}

}
