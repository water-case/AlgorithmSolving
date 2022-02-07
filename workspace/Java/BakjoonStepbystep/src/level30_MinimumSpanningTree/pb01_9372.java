package level30_MinimumSpanningTree;

import java.io.*;
import java.util.*;

public class pb01_9372 {

	static int[] parent;
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(token.nextToken());
			int M = Integer.parseInt(token.nextToken());

			parent = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				parent[i] = i;
			}
			count = 0;

			for (int i = 0; i < M; i++) {
				token = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(token.nextToken());
				int b = Integer.parseInt(token.nextToken());
				if (isUnion(a, b)) {
					continue;
				} else {
					union(a, b);
					count++;
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
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
