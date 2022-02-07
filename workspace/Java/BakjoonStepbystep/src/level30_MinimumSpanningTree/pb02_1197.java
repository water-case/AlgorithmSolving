package level30_MinimumSpanningTree;

import java.io.*;
import java.util.*;

public class pb02_1197 {

	static class Node implements Comparable<Node> {
		int start, end, weight;

		public Node(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
	}

	static int[] parent;
	static ArrayList<Node> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(token.nextToken());
		int E = Integer.parseInt(token.nextToken());

		parent = new int[V + 1];
		for (int i = 1; i <= V; i++)
			parent[i] = i;
		list = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			token = new StringTokenizer(br.readLine());
			int a1 = Integer.parseInt(token.nextToken());
			int a2 = Integer.parseInt(token.nextToken());
			int a3 = Integer.parseInt(token.nextToken());
			list.add(new Node(a1, a2, a3));
		}
		Collections.sort(list);

		int sum = 0;
		for (int i = 0; i < E; i++) {
			Node now = list.get(i);
			if (!isUnion(now.start, now.end)) {
				sum += now.weight;
				union(now.start, now.end);
			}
		}
		System.out.println(sum);
	}

	static boolean isUnion(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b)
			return true;
		return false;
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b)
			return;
		parent[b] = a;
	}

	static int find(int a) {
		a = parent[a];
		if (a == parent[a])
			return a;

		return parent[a] = find(parent[a]);
	}

}
