package level28_tree;

import java.io.*;
import java.util.*;

public class pb07_4803 {

	static ArrayList<Integer>[] graph;
	static boolean[] visit;
	static int n, m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = 1;
		while (true) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			n = Integer.parseInt(token.nextToken());
			m = Integer.parseInt(token.nextToken());
			if (n == 0 && m == 0)
				break;

			int ans = 0;
			graph = new ArrayList[n + 1];
			visit = new boolean[n + 1];
			for (int i = 1; i <= n; i++)
				graph[i] = new ArrayList<>();

			for (int i = 0; i < m; i++) {
				token = new StringTokenizer(br.readLine());
				int a1 = Integer.parseInt(token.nextToken());
				int a2 = Integer.parseInt(token.nextToken());
				graph[a1].add(a2);
				graph[a2].add(a1);
			}

			for (int i = 1; i <= n; i++) {
				if (!visit[i]) {
					visit[i] = true;
					if (dfs(i, -1))
						ans++;
				}
			}

			sb.append("Case ").append(tc).append(": ");
			if (ans == 0) {
				sb.append("No trees.\n");
			} else if (ans == 1) {
				sb.append("There is one tree.\n");
			} else {
				sb.append("A forest of ").append(ans).append(" trees.\n");
			}
			tc++;
		}

		System.out.println(sb);
		br.close();
	}

	static boolean dfs(int n, int r) {
		for (int i : graph[n]) {
			if (i == r)
				continue;
			if (visit[i])
				return false;
			visit[i] = true;
			if (!dfs(i, n))
				return false;
		}
		return true;
	}

}
