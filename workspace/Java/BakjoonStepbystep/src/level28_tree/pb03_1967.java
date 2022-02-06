package level28_tree;

import java.io.*;
import java.util.*;

public class pb03_1967 {

	static class Node {
		int end, weight;

		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

	}

	static boolean[] visit;
	static int n, max = 0, node;
	static ArrayList<Node>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		n = Integer.parseInt(br.readLine());
		if(n==1) {
			System.out.println(0);
			return;
		}
		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++)
			graph[i] = new ArrayList<>();

		for (int i = 1; i < n; i++) {
			token = new StringTokenizer(br.readLine());
			int a1 = Integer.parseInt(token.nextToken());
			int a2 = Integer.parseInt(token.nextToken());
			int a3 = Integer.parseInt(token.nextToken());
			graph[a1].add(new Node(a2, a3));
			graph[a2].add(new Node(a1, a3));
		}

		visit = new boolean[n + 1];
		dfs(1, 0);
		
		visit = new boolean[n + 1];
		dfs(node, 0);

		System.out.println(max);
	}

	static void dfs(int v, int sum) {
//		System.out.println(v + " " + sum);
		if (sum > max) {
			max = sum;
			node = v;
		}
		visit[v] = true;
		for (int i = 0; i < graph[v].size(); i++) {
			Node now = graph[v].get(i);
			if (visit[now.end] == false) {
				dfs(now.end, sum + now.weight);
				visit[now.end] = true;
			}
		}
	}

}
