package level28_tree;

import java.util.*;
import java.io.*;

public class pb02_1167 {

	static class Node {
		int end, dist;

		public Node(int end, int dist) {
			this.end = end;
			this.dist = dist;
		}

	}

	static ArrayList<Node>[] graph;
	static boolean[] visit;
	static int max = 0, node;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token;

		int V = Integer.parseInt(br.readLine());
		graph = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			token = new StringTokenizer(br.readLine());
			int now = Integer.parseInt(token.nextToken());
			while (true) {
				int ne = Integer.parseInt(token.nextToken());
				if (ne == -1)
					break;
				int nd = Integer.parseInt(token.nextToken());
				graph[now].add(new Node(ne, nd));
			}
		}

		visit = new boolean[V + 1];
		dfs(1, 0);

		visit = new boolean[V + 1];
		dfs(node, 0);

		System.out.println(max);

	}

	static void dfs(int v, int sum) {
		if (sum > max) {
			max = sum;
			node = v;
		}
		visit[v] = true;

		for (int i = 0; i < graph[v].size(); i++) {
			Node now = graph[v].get(i);
			if (visit[now.end] == false) {
				dfs(now.end, now.dist + sum);
				visit[now.end] = true;
			}
		}
	}

}
