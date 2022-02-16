package level36_LowestCommonAncestor;

import java.io.*;
import java.util.*;

public class pb01_G4_3584_가장가까운공통조상 {

	static int N, root;
	static int[] parent, depth;
	static LinkedList<Integer>[] tree;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			tree = new LinkedList[N + 1];
			for (int i = 1; i <= N; i++)
				tree[i] = new LinkedList<>();
			parent = new int[N + 1];
			depth = new int[N + 1];
			boolean[] vertex = new boolean[N + 1];
			for (int i = 1; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				vertex[b] = true;
				tree[a].add(b);
				tree[b].add(a);
			}

			root = 0;
			for (int i = 1; i <= N; i++)
				if (vertex[i] == false)
					root = i;
			treeBuilder(root, 0, -1);

			st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			LCA(n1, n2);
		}
	}

	static void treeBuilder(int cur, int d, int p) {
		parent[cur] = p;
		depth[cur] = d;

		for (int next : tree[cur]) {
			if (next != p) {
				treeBuilder(next, d + 1, cur);
			}
		}
	}

	static void LCA(int n1, int n2) {
		int depthN1 = depth[n1];
		int depthN2 = depth[n2];

		while (depthN1 > depthN2) {
			n1 = parent[n1];
			depthN1--;
		}

		while (depthN2 > depthN1) {
			n2 = parent[n2];
			depthN2--;
		}

		while (n1 != n2) {
			n1 = parent[n1];
			n2 = parent[n2];
		}
		System.out.println(n1);
	}

}
