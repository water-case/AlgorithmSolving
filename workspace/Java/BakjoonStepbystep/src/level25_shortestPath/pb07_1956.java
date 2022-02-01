package level25_shortestPath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class pb07_1956 {

	static class Node {
		int end, length;

		public Node(int end, int length) {
			this.end = end;
			this.length = length;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(token.nextToken());
		int E = Integer.parseInt(token.nextToken());
		long[][] arr = new long[V + 1][V + 1];
		ArrayList<Node>[] graph = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
			Arrays.fill(arr[i], Integer.MAX_VALUE);
		}
		for (int i = 0; i < E; i++) {
			token = new StringTokenizer(br.readLine());
			int a1 = Integer.parseInt(token.nextToken());
			int a2 = Integer.parseInt(token.nextToken());
			int a3 = Integer.parseInt(token.nextToken());
			graph[a1].add(new Node(a2, a3));
		}

		for (int i = 1; i <= V; i++) {
			for (Node node : graph[i]) {
				arr[i][node.end] = node.length;
			}
		}

//		for (long[] aa : arr)
//			System.out.println(Arrays.toString(aa));

		while (true) {
			boolean check = false;

			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {
					for (int k = 1; k <= V ; k++) {
						arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
					}
				}
			}

			if (!check)
				break;
		}
		
//		System.out.println();
//		for (long[] aa : arr)
//			System.out.println(Arrays.toString(aa));
		int min = Integer.MAX_VALUE;
		for(int i=1; i<=V; i++) {
			min = (int) Math.min(min, arr[i][i]);
		}
		if(min == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(min);
		}

//		PriorityQueue<Node> pq = new PriorityQueue<>();
//		pq.add(new Node(1, 0));
//		while(!pq.isEmpty()) {
//			Node now = pq.poll();
//			
//		}

	}

}
