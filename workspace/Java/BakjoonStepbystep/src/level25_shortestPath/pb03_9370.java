package level25_shortestPath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class pb03_9370 {

	static class Node implements Comparable<Node> {
		int end, weight;

		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
	}

	static int n, m, t, s, g, h;
	static int[] hubo, ans;
	static ArrayList<Node>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			n = Integer.parseInt(token.nextToken()); // 정점개수
			graph = new ArrayList[n + 1];
			for (int i = 1; i <= n; i++)
				graph[i] = new ArrayList<>();
			m = Integer.parseInt(token.nextToken()); // 간선개수
			t = Integer.parseInt(token.nextToken()); // 목적지후보개수
			hubo = new int[t];

			token = new StringTokenizer(br.readLine());
			s = Integer.parseInt(token.nextToken()); // 출발정점
			g = Integer.parseInt(token.nextToken()); // 지나간도로 정점
			h = Integer.parseInt(token.nextToken()); // 지나간도로 정점

			for (int i = 0; i < m; i++) {
				token = new StringTokenizer(br.readLine());
				int c1 = Integer.parseInt(token.nextToken());
				int c2 = Integer.parseInt(token.nextToken());
				int c3 = Integer.parseInt(token.nextToken());
				graph[c1].add(new Node(c2, c3));
				graph[c2].add(new Node(c1, c3));
			}

			for (int i = 0; i < t; i++)
				hubo[i] = Integer.parseInt(br.readLine());
			Arrays.sort(hubo);

			ans = new int[n + 1];
			for (int i = 0; i <= n; i++) ans[i] = Integer.MAX_VALUE; // 최단거리 배열 초기화
			
			dijkstra(s);
			int[] tHubo = new int[t]; // 곧바로 목적지 최단거리
			for (int i = 0; i < t; i++) tHubo[i] = ans[hubo[i]]; // 비교를 위해 임시저장
//			System.out.println("ans1: " + Arrays.toString(ans));
			
			int s2length = 0;
			int s2 = 0;
			if(ans[g] > ans[h]) {
				s2length = ans[g];
				s2 = g;
			} else {
				s2length = ans[h];
				s2 = h;
			}

//			System.out.println("s2length: " + s2length);
			ans = new int[n + 1];
			for (int i = 0; i <= n; i++) ans[i] = Integer.MAX_VALUE; // 최단거리 배열 초기화
			
			dijkstra(s2);
//			System.out.println("ans2: " + Arrays.toString(ans));
			
			for (int i = 0; i < t; i++) {
				if(tHubo[i] == ans[hubo[i]] + s2length) {
//					System.out.print("result: " + hubo[i] + " ");
					System.out.print(hubo[i] + " ");
				}
			}
			System.out.println();

		}
	}

	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		boolean[] visit = new boolean[n + 1];
		visit[start] = true;
		ans[start] = 0;

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			int ne = now.end;

			for (Node node : graph[ne]) {
				if(ans[node.end] > ans[ne] + node.weight) {
					ans[node.end] = ans[ne] + node.weight;
					pq.add(new Node(node.end, node.weight));
				}
			}
		}

	}

}
