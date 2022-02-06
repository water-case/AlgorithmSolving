package level29_unionFind;

import java.io.*;
import java.util.*;

public class pb02_1976 {

	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer token;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++)
			parent[i] = i;

		for (int i = 1; i <= N; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int num = Integer.parseInt(token.nextToken());
				if(num == 1) {
					union(i, j);
				}
			}
		}
//		System.out.println(Arrays.toString(parent));
		token = new StringTokenizer(br.readLine());
		int idx = token.countTokens();
		int a1 = Integer.parseInt(token.nextToken());
		int a2 = Integer.parseInt(token.nextToken());
		for (int i = 2; i <= idx; i++) {
			if(isUnion(a1,a2)) {
				if(i == idx) {
					sb.append("YES");
					break;
				}
			} else {
				sb.append("NO");
				break;
			}
			a1 = a2;
			a2 = Integer.parseInt(token.nextToken());
		}
		System.out.println(sb);
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
		if (a == parent[a])
			return a;
		return parent[a] = find(parent[a]);
	}
}
