package graphs;

import java.util.Scanner;
import java.util.Arrays;

class Edge1 implements Comparable<Edge1> {
	int v1;
	int v2;
	int w;

	Edge1(int v1, int v2, int w) {
		this.v1 = v1;
		this.v2 = v2;
		this.w = w;
	}

	@Override
	public int compareTo(Edge1 edge) {
		return this.w - edge.w;
	}
}

public class KrushalsAlgorithmBest {
	public static Edge1[] krushalsAlgorithm(Edge1[] input, int V) {
		// step2: sort array in ascending order of weight
		Arrays.sort(input);
		Edge1[] output = new Edge1[V - 1];

		// step3: create parent array for union find algorithm
		int[] parent = new int[V];
		for (int i = 0; i < V; i++) {
			parent[i] = i;
		}

		// step4: apply union find and krushal algorithm
		int count = 0;
		int i = 0;
		while (count < V - 1) {
			Edge1 currentEdge = input[i];

			int parentV1 = parent[currentEdge.v1];
			while(parentV1 != parent[parentV1]) {
				parentV1 = parent[parentV1];
			}
			int parentV2 = parent[currentEdge.v2];
			while(parentV2 != parent[parentV2]) {
				parentV2 = parent[parentV2];
			}

			// if parents are not same, there v1 and v2 belong
			// to different component i.e there is no cycle so 
			// it is safer to form edge
			if (parentV1 != parentV2) {
				output[count++] = currentEdge;
				parent[parentV1] = parentV2;
				if (count == V - 1) {
					break;
				}
			}

			i++;
		}

		return output;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();

		// step1: take input
		Edge1[] input = new Edge1[E];
		for (int i = 0; i < E; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int w = sc.nextInt();

			input[i] = new Edge1(v1, v2, w);
		}

		Edge1[] output = krushalsAlgorithm(input, V);

		// step5: print output
		int n = output.length;
		for (int i = 0; i < n; i++) {
			int v1 = output[i].v1;
			int v2 = output[i].v2;
			int w = output[i].w;

			if (v1 <= v2) {
				System.out.println(v1 + " " + v2 + " " + w);
			} else {
				System.out.println(v2 + " " + v1 + " " + w);
			}
		}
	}
}
