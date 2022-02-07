package level30_MinimumSpanningTree;

import java.io.*;
import java.util.*;

public class pb04_1774 {

	static class Point {
		int num, x, y;

		public Point(int num, int x, int y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}

	}

	static class Edge implements Comparable<Edge> {
		int start, end;
		double weight;

		public Edge(int start, int end, double weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return weight < o.weight ? -1 : 1;
		}
	}

	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		Point[] pa = new Point[N + 1];
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++)
			parent[i] = i;

		for (int i = 1; i <= N; i++) {
			token = new StringTokenizer(br.readLine());
			int a1 = Integer.parseInt(token.nextToken());
			int a2 = Integer.parseInt(token.nextToken());
			pa[i] = new Point(i, a1, a2);
		}

		for (int i = 0; i < M; i++) {
			token = new StringTokenizer(br.readLine());
			int a1 = Integer.parseInt(token.nextToken());
			int a2 = Integer.parseInt(token.nextToken());
			union(a1, a2);
		}

		ArrayList<Edge> list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				double weight = Math.sqrt(Math.pow(pa[i].x - pa[j].x, 2) + Math.pow(pa[i].y - pa[j].y, 2));
				list.add(new Edge(i, j, weight));
			}
		}
		Collections.sort(list);
		
		double sum = 0;
		for(int i=0; i<list.size(); i++) {
			Edge now = list.get(i);
			if(!isUnion(now.start, now.end)) {
				sum += now.weight;
				union(now.start, now.end);
			}
		}
		System.out.println(String.format("%.2f", sum));
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
