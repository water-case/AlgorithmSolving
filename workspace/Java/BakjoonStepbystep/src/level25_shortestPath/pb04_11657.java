package level25_shortestPath;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class pb04_11657 {

	static class Node {
		int end, weight;

		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
	}

	static int N, M;
	static long[] ans;
	static ArrayList<Node>[] graph;

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			token = new StringTokenizer(br.readLine());
			int a1 = Integer.parseInt(token.nextToken());
			int a2 = Integer.parseInt(token.nextToken());
			int a3 = Integer.parseInt(token.nextToken());
			graph[a1].add(new Node(a2, a3));
		}

		ans = new long[N + 1];
		for (int i = 1; i <= N; i++)
			ans[i] = Long.MAX_VALUE;

		if (bellman(1)) {
			sb.append("-1\n");
		} else {
			for (int i = 2; i <= N; i++) {
				if (ans[i] == Long.MAX_VALUE) {
					sb.append("-1\n");
				} else {
					sb.append(ans[i] + "\n");
				}
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static boolean bellman(int start) {
		ans[start] = 0;
		boolean check = false;

		for (int i = 1; i < N; i++) {
			check = false;
			for (int j = 1; j <= N; j++) {
				for (Node node : graph[j]) {
					if (ans[j] == Long.MAX_VALUE)
						break;
					if (ans[node.end] > ans[j] + node.weight) {
						ans[node.end] = ans[j] + node.weight;
						check = true;
					}
				}
			}
			if (!check) {
				break;
			}
		}
		if (check) {
			for (int i = 1; i <= N; i++) {
				for (Node node : graph[i]) {
					if (ans[i] == Long.MAX_VALUE)
						break;
					if (ans[node.end] > ans[i] + node.weight) {
						return true;
					}
				}
			}
		}
		return false;
	}

//	static void dijkstra(int start) {
//		PriorityQueue<Node> pq = new PriorityQueue<>();
//		pq.add(new Node(start, 0));
//		boolean[] check = new boolean[N + 1];
//		ans[start] = 0;
//		
//		while(!pq.isEmpty()) {
//			Node now = pq.poll();
//			int ne = now.end;
//			if(!check[ne]) {
//				check[ne] = true;
//				for(Node node : graph[ne]) {
//					if(ans[node.end] >= ans[ne] + node.weight) {
//						ans[node.end] = ans[ne] + node.weight;
//						pq.add(new Node(node.end, ans[node.end]));
//					}
////					System.out.println(ne + "->" + node.end + " " + Arrays.toString(ans));
//				}
//			}
//		}
//	}

}
