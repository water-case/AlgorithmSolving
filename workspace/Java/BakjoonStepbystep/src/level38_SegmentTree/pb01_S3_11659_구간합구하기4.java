package level38_SegmentTree;

import java.io.*;
import java.util.*;

public class pb01_S3_11659_구간합구하기4 {

	static int[] arr, tree;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 수의 개수
		int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수

		arr = new int[N];
		tree = new int[N * 4];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		// 세그먼트 트리 만들기
		init(0, N - 1, 1);
//		int a = 1;
//		for(int i=0; i<N; i++) {
//			System.out.print(tree[i] + " ");
//		}
//		System.out.println(Arrays.toString(tree));

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			sb.append(treeSum(0, N - 1, 1, start - 1, end - 1)).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}

	static int treeSum(int start, int end, int node, int left, int right) {
		if (left > end || right < start)
			return 0;
		if (left <= start && right >= end)
			return tree[node];

		int mid = (start + end) / 2;
		return treeSum(start, mid, node * 2, left, right) + treeSum(mid + 1, end, node * 2 + 1, left, right);
	}

	static int init(int start, int end, int node) {
		if (start == end)
			return tree[node] = arr[start];

		int mid = (start + end) / 2;
		return tree[node] += init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
	}

}
