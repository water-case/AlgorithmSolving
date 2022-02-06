package level29_unionFind;

import java.io.*;
import java.util.*;

public class pb04_20040 {

	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		for (int t = 1; t <= m; t++) {
			token = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			if(isUnion(a,b)) {
				System.out.println(t);
				break;
			} else {
				union(a,b);
			}
			if(t == m) System.out.println(0);
		}
	}

	static boolean isUnion(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b)
			return false;
		return true;
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
