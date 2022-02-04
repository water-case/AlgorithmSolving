package level27_dpAndTraceback;

import java.io.*;
import java.util.*;

public class pb08_11779 {

	static class Node implements Comparable<Node> {
		int end, price, count;
		String route;

		public Node(int end, int price, int count, String route) {
			this.end = end;
			this.price = price;
			this.count = count;
			this.route = route;
		}

		@Override
		public int compareTo(Node o) {
			return price - o.price;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		ArrayList<Node>[] graph = new ArrayList[N];
		for (int i = 0; i < N; i++)
			graph[i] = new ArrayList<>();

		StringTokenizer token;
		for (int i = 0; i < M; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			int a1 = Integer.parseInt(token.nextToken());
			int a2 = Integer.parseInt(token.nextToken());
			int a3 = Integer.parseInt(token.nextToken());
			graph[a1].add(new Node(a2, a3, 0, ""));
		}

		token = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(token.nextToken());
		int end = Integer.parseInt(token.nextToken());

		boolean[] visit = new boolean[N];
		String results = "";
		int resultc = 0;
		int min = Integer.MAX_VALUE;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0, 0, start + " "));
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			int ne = now.end;
			int np = now.price;
			int nc = now.count;
			String ns = now.route;

			if (ne == end) {
				if(min < np) {
					min = np;
					results = ns + end;
					resultc = nc + 1;
				}
				continue;
			}

			if (!visit[ne]) {
				visit[ne] = true;
				for (Node node : graph[ne]) {
					pq.add(new Node(node.end, np + node.price, nc+1, ns + node + " "));
				}
			}
			System.out.println(ne);
		}
		sb.append(min).append("\n")
		  .append(resultc).append("\n")
		  .append(results);
		System.out.println(sb);
		br.close();
	}

}
