package level38_SegmentTree;

import java.io.*;
import java.util.*;

public class pb03_G1_11505_구간곱구하기 {

	static int N, M, K;
	static int[] arr;
	static long[] tree;
	static int MOD = 1_000_000_007;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 수의 개수
		M = Integer.parseInt(st.nextToken()); // 변경 횟수
		K = Integer.parseInt(st.nextToken()); // 곱을 구하는 횟수

		arr = new int[N + 1];
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(br.readLine());

		tree = new long[N * 4];

		init(1, N, 1); // 세그먼트 트리 초기화
//		System.out.println(Arrays.toString(tree));

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()); // 1이면 변경, 2이면 출력
			int b = Integer.parseInt(st.nextToken()); // 인덱스번호
			int c = Integer.parseInt(st.nextToken()); // 1이면 바꿀숫자, 2이면 인덱스

//			System.out.println(Arrays.toString(tree));
			if (a == 1) { // 숫자 변경
				Update(1, N, 1, b, c);
			} else { // 출력
				sb.append(multi(1, N , 1, b, c)).append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	static long Update(int start, int end, int node, int idx, int num) {
		if (idx < start || idx > end)
			return tree[node];
		
		if(start == end) return tree[node] = num;

		int mid = (start + end) / 2;
		return tree[node] = Update(start, mid, node * 2, idx, num) * Update(mid + 1, end, node * 2 + 1, idx, num) % MOD;
	}

	static long multi(int start, int end, int node, int left, int right) {
		if (left > end || right < start)
			return 1;
		if (left <= start && right >= end)
			return tree[node];

		int mid = (start + end) / 2;
		return multi(start, mid, node * 2, left, right) * multi(mid + 1, end, node * 2 + 1, left, right) % MOD;
	}

	static long init(int start, int end, int node) {
		if (start == end)
			return tree[node] = arr[start];

		int mid = (start + end) / 2;
		return tree[node] = init(start, mid, node * 2) * init(mid + 1, end, node * 2 + 1) % MOD;
	}

}
