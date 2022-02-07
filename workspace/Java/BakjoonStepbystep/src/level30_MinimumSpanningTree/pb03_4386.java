package level30_MinimumSpanningTree;

import java.io.*;
import java.util.*;

public class pb03_4386 {

	static class Point {
		int num;
		double x, y;

		public Point(int num, double x, double y) {
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

		@Override
		public String toString() {
			return start + " " + end + " " + weight;
		}
	}

	static int[] parent;
	static ArrayList<Edge> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Point[] plist = new Point[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			double d1 = Double.parseDouble(token.nextToken());
			double d2 = Double.parseDouble(token.nextToken());

			plist[i] = new Point(i, d1, d2);
		}

		list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				double weight = Math.sqrt(Math.pow(plist[i].x - plist[j].x, 2) + Math.pow(plist[i].y - plist[j].y, 2));
				list.add(new Edge(plist[i].num, plist[j].num, weight));
			}
		}
		Collections.sort(list);

		parent = new int[n];
		for (int i = 0; i < n; i++)
			parent[i] = i;
		
		double sum = 0;
		for (int i = 0; i < list.size(); i++) {
			Edge now = list.get(i);
			if (!isUnion(now.start, now.end)) {
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
