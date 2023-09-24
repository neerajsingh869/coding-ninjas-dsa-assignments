package graphs;

import java.util.Scanner;

public class DijkstrasAlgorithm {
	
	/*
	 * Given an undirected, connected and weighted graph G(V, E) 
	 * with V number of vertices (which are numbered from 0 to V-1) 
	 * and E number of edges.
	 * 
	 * Find and print the shortest distance from the source vertex 
	 * (i.e. Vertex 0) to all other vertices (including source vertex also) 
	 * using Dijkstra's Algorithm.
	  
	 * Input Format :
	   Line 1: Two Integers V and E (separated by space)
	   Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi (separated by space)
	
	 * Output Format :
	   For each vertex, print its vertex number and its distance from 
	   source, in a separate line. The vertex number and its distance 
	   needs to be separated by a single space.
	   Note : Order of vertices in output doesn't matter.

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
		0 0
		1 3
		2 4
		3 5
	 */
	
	public static void dijkstras(int[][] adjMatrix) {
		int v = adjMatrix.length;
		boolean[] isVisited = new boolean[v];
		int[] distance = new int[v];
		for (int i = 0; i < v; i++) {
			if (i == 0) {
				distance[i] = 0;
			} else {
				distance[i] = Integer.MAX_VALUE;
			}
		}
		for (int countVisited = 0; countVisited < v; countVisited++) {
			// Finding unvisited vertex having min distance from source
			int minDistVertex = -1;
			for (int i = 0; i < v; i++) {
				if (isVisited[i] == false
						&& (minDistVertex == -1 || (distance[minDistVertex] > distance[i]))) {
					minDistVertex = i;
				}
			}
			isVisited[minDistVertex] = true;
			// Calculating shortest distance
			for (int i = 0; i < v; i++) {
				// Since dijkstra's is only valid for +ve edges
				if (adjMatrix[minDistVertex][i] > 0 && !isVisited[i]) {
					if (distance[i] > distance[minDistVertex] + adjMatrix[minDistVertex][i]) {
						distance[i] = distance[minDistVertex] + adjMatrix[minDistVertex][i];
					}
				}
			}
		}
		// Printing the vertex and their distance from source
		for (int i = 0; i < v; i++) {
			System.out.println(i + " " + distance[i]);
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();
		int[][] adjMatrix = new int[V][V];
		for (int i = 0; i < E; i++) {
			int v1 = s.nextInt();
			int v2 = s.nextInt();
			int w = s.nextInt();
			adjMatrix[v1][v2] = w;
			adjMatrix[v2][v1] = w;
		}
		dijkstras(adjMatrix);
	}

}
