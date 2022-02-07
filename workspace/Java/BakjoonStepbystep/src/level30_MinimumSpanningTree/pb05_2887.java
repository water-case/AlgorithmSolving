package level30_MinimumSpanningTree;

import java.io.*;
import java.util.*;

public class pb05_2887 {

	static class Point {
		int num, x, y, z;

		public Point(int num, int x, int y, int z) {
			this.num = num;
			this.x = x;
			this.y = y;
			this.z = z;
		}

	}

	static class Edge implements Comparable<Edge> {
		int start, end, weight;

		public Edge(int start, int end, int weight) {
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
		int N = Integer.parseInt(br.readLine());
		Point[] pa = new Point[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int a1 = Integer.parseInt(token.nextToken());
			int a2 = Integer.parseInt(token.nextToken());
			int a3 = Integer.parseInt(token.nextToken());
			pa[i] = new Point(i, a1, a2, a3);
		}
		
		ArrayList<Edge> list = new ArrayList<>();

		Arrays.sort(pa, (o1, o2) -> { return o1.x - o2.x; });
		for(int i=1; i<N; i++) {
			list.add(new Edge(pa[i-1].num, pa[i].num, Math.abs(pa[i-1].x - pa[i].x)));
		}
		
		Arrays.sort(pa, (o1, o2) -> { return o1.y - o2.y; });
		for(int i=1; i<N; i++) {
			list.add(new Edge(pa[i-1].num, pa[i].num, Math.abs(pa[i-1].y - pa[i].y)));
		}
		
		Arrays.sort(pa, (o1, o2) -> { return o1.z - o2.z; });
		for(int i=1; i<N; i++) {
			list.add(new Edge(pa[i-1].num, pa[i].num, Math.abs(pa[i-1].z - pa[i].z)));
		}
		Collections.sort(list);

		parent = new int[N];
		for (int i = 0; i < N; i++) parent[i] = i;

		int sum = 0;
		for(int i=0; i<list.size(); i++) {
			Edge now = list.get(i);
			
			if(!isUnion(now.start, now.end)) {
				sum += now.weight;
				union(now.start, now.end);
			}
		}
		System.out.println(sum);
		br.close();
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
