package level36_LowestCommonAncestor;

import java.io.*;
import java.util.*;

public class pb05_P3_13511_트리와쿼리2 {

	static class edge {
		int end, price;

		public edge(int end, int price) {
			this.end = end;
			this.price = price;
		}

	}

	static ArrayList<ArrayList<edge>> list = new ArrayList<>();
	static int N, log = 19, u, v, k;
	static int[] depth;
	static long[] psum; // 간선당 값이 100만이하의값이고 노드의 개수가 10만개이므로 long으로 설정하지 않으면 틀림, 
	static int[][] parent;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // 정점의 개수
		for (int i = 0; i <= N; i++)
			list.add(new ArrayList<>()); // 양방향 그래프담을 리스트배열 만듬
		for (int i = 1; i < N; i++) { // 양방향 그래프로 만듬
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.get(a).add(new edge(b, c));
			list.get(b).add(new edge(a, c));
		}

		parent = new int[N + 1][log + 1]; // 희소행렬생성
		depth = new int[N + 1];// 깊이배열생성
		psum = new long[N + 1];// 비용배열생성

		treeBuilder(1, 1); // 루트 노드를 1로하여 트리만들며 깊이,비용,희소행렬 기반 세팅
		fillBuilder(); // 희소행렬과 비용배열 채우기

//		System.out.println("parent------------"); // 깊이, 비용, 희소행렬 찍어보기
//		for (int[] ia : parent)
//			System.out.println(Arrays.toString(ia));
//		System.out.println();
//		System.out.println("depth------------");
//		System.out.println(Arrays.toString(depth));
//		System.out.println();
//		System.out.println("psum------------");
//		System.out.println(Arrays.toString(psum));
//		System.out.println();

		int M = Integer.parseInt(br.readLine()); // 쿼리의 개수
		for (int i = 0; i < M; i++) { // 쿼리의 개수만큼 쿼리 실행
			st = new StringTokenizer(br.readLine(), " ");
			int mode = Integer.parseInt(st.nextToken()); // 1:비용 2:경로 중 k번쨰 정점찾기
			u = Integer.parseInt(st.nextToken()); // 시작노드
			v = Integer.parseInt(st.nextToken()); // 끝노드
			int lca = LCA(u, v);
			if (mode == 1) {
				System.out.println(psum[u] + psum[v] - 2 * psum[lca]);
			} else if (mode == 2) {
				k = Integer.parseInt(st.nextToken()); // 찾을 노드
				System.out.println(cf(lca));
			}
		}
	}

	static int LCA(int x, int y) {
		if (depth[x] < depth[y]) {
			int tmp = x;
			x = y;
			y = tmp;
		}

		for (int i = log - 1; i >= 0; i--)
			if (Math.pow(2, i) <= depth[x] - depth[y])
				x = parent[x][i];

		if (x == y)
			return x;

		for (int i = log - 1; i >= 0; i--) {
			if (parent[x][i] != parent[y][i]) {
				x = parent[x][i];
				y = parent[y][i];
			}
		}

		return parent[x][0];
	}

	static int cf(int lca) { // u에서 v로 가는 경로중에 k번째 정점 출력
		int ans = 0;
		int mid = depth[u] - depth[lca] + 1;

		if (mid == k) {
			return lca;
		} else if (mid > k) {
			k -= 1;
			ans = u;
		} else {
			k = mid + depth[v] - depth[lca] - k;
			ans = v;
		}

		for (int i = log - 1; i >= 0; i--) {
			if ((k & (1 << i)) != 0) {
				k ^= (1 << i);
				ans = parent[ans][i];
			}
		}

		return ans;
	}

	static void fillBuilder() {
		for (int i = 1; i < log; i++)
			for (int j = 1; j <= N; j++) {
				parent[j][i] = parent[parent[j][i - 1]][i - 1];
//				psum[j][i] = psum[j][i - 1] + psum[parent[j][i - 1]][i - 1];
			}
	}

	static void treeBuilder(int now, int d) {
		depth[now] = d;
		for (edge next : list.get(now))
			if (depth[next.end] == 0) {
				parent[next.end][0] = now;
				psum[next.end] = psum[now] + next.price;
				treeBuilder(next.end, d + 1);
			}
	}
}
