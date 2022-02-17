package level36_LowestCommonAncestor;

import java.io.*;
import java.util.*;

public class pb04_P4_3176_도로네트워크 {

	static class edge {
		int end, price;

		public edge(int end, int price) {
			this.end = end;
			this.price = price;
		}

	}

	static ArrayList<ArrayList<edge>> list = new ArrayList<>();
	static int N, log, min, max;
	static int[] depth;
	static int[][] parent, minDist, maxDist;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // N개의 도시

		for (int i = 0; i <= N; i++)
			list.add(new ArrayList<>()); // 간선 저장
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()); // 도시a
			int b = Integer.parseInt(st.nextToken()); // 도시b
			int c = Integer.parseInt(st.nextToken()); // a - b 사이의 도로길이
			list.get(a).add(new edge(b, c)); // 누가 루트인지 알 수 없으므로
			list.get(b).add(new edge(a, c)); // 양방향 그래프로 생성
		}
		// 최대깊이 구하기
		int tmp = 1;
		while (tmp <= N) {
			tmp <<= 1;
			log++;
		}
		depth = new int[N + 1];
		parent = new int[N + 1][log];
		minDist = new int[N + 1][log];
		maxDist = new int[N + 1][log];
		// 트리만들면서 깊이와 희소행렬 0번인덱스 채우기
		treeBuilder(1, 1);

		// 도출된 희소행렬 0번인덱스값으로 멱수희소행렬 만들기
		fillArray();


		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()); // a와 b사이에
			int b = Integer.parseInt(st.nextToken()); // 가장 짧은 도로와 긴 도로 구하기
			LCA(a, b);
			sb.append(min).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	static void LCA(int a, int b) {
		max = -1;
		min = Integer.MAX_VALUE;
		// 깊이를 맞춘다
		if (depth[a] < depth[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}

		for (int i = log - 1; i >= 0; i--) {
			if (Math.pow(2, i) <= depth[a] - depth[b]) {
				min = Math.min(min, minDist[a][i]);
				max = Math.max(max, maxDist[a][i]);
				a = parent[a][i];
			}
		}
		// 깊이맞춘뒤 부모가 같으면 리턴
		if (a == b)
			return;
		// 깊이를 내려가며 같은 부모를 찾는다
		for (int i = log - 1; i >= 0; i--) {
			if (parent[a][i] != parent[b][i]) {
				min = Math.min(min, Math.min(minDist[a][i], minDist[b][i]));
				max = Math.max(max, Math.max(maxDist[a][i], maxDist[b][i]));
				a = parent[a][i];
				b = parent[b][i];
			}
		}
		
		min = Math.min(min, Math.min(minDist[a][0], minDist[b][0]));
		max = Math.max(max, Math.max(maxDist[a][0], maxDist[b][0]));


		return;
	}

	static void fillArray() {
		for (int i = 1; i < log; i++)
			for (int j = 0; j <= N; j++) {
				parent[j][i] = parent[parent[j][i - 1]][i - 1];
				// 최소길이 최대길이 비교하며 1번 2번 인덱스 채우기
				minDist[j][i] = Math.min(minDist[parent[j][i - 1]][i - 1], minDist[j][i - 1]);
				maxDist[j][i] = Math.max(maxDist[parent[j][i - 1]][i - 1], maxDist[j][i - 1]);
			}
	}

	static void treeBuilder(int now, int d) {
		depth[now] = d;
		for (edge next : list.get(now)) {
			if (depth[next.end] == 0) {
				treeBuilder(next.end, d + 1);
				parent[next.end][0] = now;
				minDist[next.end][0] = next.price;
				maxDist[next.end][0] = next.price;
			}
		}
	}

}
