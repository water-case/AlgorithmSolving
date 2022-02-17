package level36_LowestCommonAncestor;

import java.io.*;
import java.util.*;

public class pb03_P5_11438_LCA2 {

	static ArrayList<ArrayList<Integer>> tree;
	static int[][] parent;
	static int[] depth;
	static int maxD;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 노드의 개수
		
		tree = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			tree.add(new ArrayList<>()); 
		
		for (int i = 1; i < N; i++) { // 누가 부모고 자식인지 알 수 없으므로
			st = new StringTokenizer(br.readLine()); // 연결된 노드 일단 양방향으로 저장하고	
			int a = Integer.parseInt(st.nextToken()); // 루트노드는 1로 주어졌으므로 트리빌더로
			int b = Integer.parseInt(st.nextToken()); // 트리를 구성한다
			tree.get(a).add(b);
			tree.get(b).add(a);
		}

//		for(ArrayList<Integer> ia : tree) // 트리배열 구조 찍어보기
//			System.out.println(ia);
		int tmp = 1;
		maxD = 0;
		while(tmp <= N) {
			tmp <<= 1;
			maxD++;
		}
		
		parent = new int[N + 1][maxD + 1]; // 부모를 저장할 배열
		depth = new int[N + 1]; // 각 노드의 깊이를 저장할 배열
		
		// 루트노드는 1이라고 주어졌으므로
		treeBuilder(1, 1); // 양방향 그래프를 트리구조로 이동하며 부모배열 구함  
		
		for (int i = 1; i < maxD; i++) // 희소행렬만들기
			for (int j = 1; j <= N; j++)
				parent[j][i] = parent[ parent[j][i - 1] ][i - 1];
//		for (int[] ia : parent) // 희소행렬 구조 찍어보기
//			System.out.println(Arrays.toString(ia));
//		System.out.println(Arrays.toString(depth)); // 깊이배열 찍어보기
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(LCA(a, b)).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	static int LCA(int a, int b) {
		if (depth[a] < depth[b]) { // 다음 for문에서 높이가 큰것에서 작은것을 뺄것이므로
			int tmp = a; // 더 큰 높이를 앞으로 오도록 정렬
			a = b; // 어차피 다음 for문 이후 같은 값이 될것이므로 크게 개의치 말것
			b = tmp;
		}

		for (int i = maxD - 1; i >= 0; i--) // 2의 멱수 형태로 구해진 희소행렬을 이용하여
			if (Math.pow(2, i) <= depth[a] - depth[b]) // 깊이를 맞추며 부모도 찾는다
				a = parent[a][i];

		if (a == b) // 만약에 깊이를 맞추자마자 같은갚이면 그대로 리턴
			return a;

		for (int i = maxD - 1; i >= 0; i--) { // 깊이를 맞춰도 서로 부모가 다르므로
			if(parent[a][i] != parent[b][i]) { // 희소행렬을 이용하여 올라가면서 부모를 맞춰본다
				a = parent[a][i];
				b = parent[b][i];
			}
		}
		// 도출된 부모의 값은 인덱스가 0일때의 값을 기준으로 한다
		return parent[a][0]; // 희소행렬을 처음 도출할때 0번인덱스부터 구한다 
		// main문의 희소행렬 만드는 for문 참고
		
	}

	static void treeBuilder(int now, int d) {
		depth[now] = d; // 깊이 넣기
		for (int next : tree.get(now)) // 현재노드에서 연결된 노드들중에
			if (depth[next] == 0) { // 깊이가 정해지지 않았으면 현재노드 밑으로 넣는다
				treeBuilder(next, d + 1);
				parent[next][0] = now; // 부모 넣기
			}
	}

}
