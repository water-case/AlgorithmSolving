package level38_SegmentTree;

import java.io.*;
import java.util.*;

public class pb04_G1_2357_최솟값과최댓값 {

	static int[] arr;
	static int[][] tree;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 정수의 개수
		int M = Integer.parseInt(st.nextToken()); // a, b 쌍의 수
		arr = new int[N + 1];
		tree = new int[N * 4][2]; // 0번 최소, 1번 최대

		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(br.readLine());

		// 세그먼트트리 초기화
		init(1, N, 1);
//		for(int[] i: tree)
//			System.out.print(i[1] + " ");

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int[] ans = search(1, N, 1, a, b);
			sb.append(ans[0]).append(" ").append(ans[1]).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static int[] search(int start, int end, int node, int left, int right) {
		int[] result = new int[] {1_000_000_000, 1};
		if(left > end || right < start) return result;
		if(left <= start && right >= end) {
			return tree[node];
		}
		
		int mid = (start + end) / 2;
		int[] a = search(start, mid, node * 2, left, right);
		int[] b = search(mid + 1, end, node * 2 + 1, left, right);
		result[0] = a[0] > b[0] ? b[0] : a[0];
		result[1] = a[1] > b[1] ? a[1] : b[1];
		return result;
	}

	static int[] init(int start, int end, int node) {
		if (start == end) {
			tree[node][0] = arr[start];
			tree[node][1] = arr[start];
			return tree[node];
		}

		int mid = (start + end) / 2;
		int[] a = init(start, mid, node * 2);
		int[] b = init(mid + 1, end, node * 2 + 1);
		tree[node][0] = a[0] > b[0] ? b[0] : a[0]; // 최소값
		tree[node][1] = a[1] > b[1] ? a[1] : b[1]; // 최대값
		return tree[node];
	}

}
