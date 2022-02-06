package level29_unionFind;

import java.io.*;
import java.util.*;

public class pb01_1717 {

	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer token = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++)
			parent[i] = i;

		for (int i = 0; i < m; i++) {
			token = new StringTokenizer(br.readLine());
			int a1 = Integer.parseInt(token.nextToken());
			int a2 = Integer.parseInt(token.nextToken());
			int a3 = Integer.parseInt(token.nextToken());

			if (a1 == 0) { // Union
				union(a2, a3);
			} else { // 출력
				if(isUnion(a2,a3)) {
					sb.append("YES\n");
				}else {
					sb.append("NO\n");
				}
			}
		}

		System.out.println(sb.toString());
		br.close();
	}
	
	static boolean isUnion(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b) return true;
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
		if (parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);
	}

}
