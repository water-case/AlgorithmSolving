package level25_shortestPath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class pb02_1504 {

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

	static int N, E, mid1, mid2;
	static int[] ans;
	static ArrayList<Node>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		E = Integer.parseInt(token.nextToken());
		ans = new int[N + 1];
		for (int i = 1; i <= N; i++)
			ans[i] = Integer.MAX_VALUE;

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			token = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			int c = Integer.parseInt(token.nextToken());

			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}

		token = new StringTokenizer(br.readLine());
		mid1 = Integer.parseInt(token.nextToken());
		mid2 = Integer.parseInt(token.nextToken());

		int tmp1 = 0, tmp2 = 0;
		// 1 회차
		dijkstra(1);
		if (ans[mid1] == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		} else {
			tmp1 += ans[mid1];
			tmp2 += ans[mid2];
		}
		// 1 들렷다가 2
		ans = new int[N + 1];
		for (int i = 1; i <= N; i++)
			ans[i] = Integer.MAX_VALUE;
		dijkstra(mid1);
		if (ans[mid2] == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		} else {
			tmp1 += ans[mid2];
		}
		// 2 들렸다가 끝
		ans = new int[N + 1];
		for (int i = 1; i <= N; i++)
			ans[i] = Integer.MAX_VALUE;
		dijkstra(mid2);
		if (ans[N] == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		} else {
			tmp1 += ans[N];
		}

		// 2 들렷다가 1
		ans = new int[N + 1];
		for (int i = 1; i <= N; i++)
			ans[i] = Integer.MAX_VALUE;
		dijkstra(mid2);
		if (ans[mid1] == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		} else {
			tmp2 += ans[mid1];
		}
		// 1 들렸다가 끝
		ans = new int[N + 1];
		for (int i = 1; i <= N; i++)
			ans[i] = Integer.MAX_VALUE;
		dijkstra(mid1);
		if (ans[N] == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		} else {
			tmp2 += ans[N];
		}

		System.out.println(tmp1 > tmp2 ? tmp2 : tmp1);

	}

	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		boolean[] check = new boolean[N + 1];
		ans[start] = 0;

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			int end = now.end;

			if (check[end] == true)
				continue;
			check[end] = true;

			for (Node n : graph[end]) {
				if (ans[n.end] > ans[end] + n.weight) {
					ans[n.end] = ans[end] + n.weight;
					pq.add(new Node(n.end, ans[n.end]));
				}
			}
		}
	}

}
