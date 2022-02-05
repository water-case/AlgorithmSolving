package level27_dpAndTraceback;

import java.io.*;
import java.util.*;

public class pb08_11779 {

	static class Node implements Comparable<Node> {
		int end, price;

		public Node(int end, int price) {
			this.end = end;
			this.price = price;
		}

		@Override
		public int compareTo(Node o) {
			return price - o.price;
		}

	}

	static int N, M, count;
	static int[] dist, route;
	static ArrayList<Node>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new ArrayList[N + 1];
		route = new int[N + 1];
		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();

		StringTokenizer token;
		for (int i = 0; i < M; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			int a1 = Integer.parseInt(token.nextToken());
			int a2 = Integer.parseInt(token.nextToken());
			int a3 = Integer.parseInt(token.nextToken());
			graph[a1].add(new Node(a2, a3));
		}

		token = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(token.nextToken());
		int end = Integer.parseInt(token.nextToken());

		dijkstra(start);

		StringBuilder sb = new StringBuilder();
		sb.append(dist[end]).append("\n");

		Stack<Integer> stack = new Stack<>();
		stack.push(end);
		while (route[end] != 0) {
			count++;
			stack.push(route[end]);
			end = route[end];
		}

		sb.append(count + 1).append("\n");
		while (!stack.isEmpty())
			sb.append(stack.pop()).append(" ");

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	static void dijkstra(int start) {
		Queue<Node> q = new PriorityQueue<>();
		dist = new int[N + 1];
		boolean[] visit = new boolean[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[start] = 0;
		q.add(new Node(start, 0));

		while (!q.isEmpty()) {
			Node now = q.poll();
			int ne = now.end;
			if(!visit[ne]) visit[ne] = true;
			else continue;

			for (Node node : graph[ne]) {
				if (dist[node.end] > dist[ne] + node.price) {
					dist[node.end] = dist[ne] + node.price;
					route[node.end] = ne;
					q.add(new Node(node.end, dist[node.end]));
				}
			}
		}
	}

}
