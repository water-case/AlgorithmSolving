package level38_SegmentTree;

import java.io.*;
import java.util.*;

public class pb02_G1_2042_구간합구하기 {

	static long[] tree, arr;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 수의 개수
		int M = Integer.parseInt(st.nextToken()); // 수의 변경이 일어나는 횟수
		int K = Integer.parseInt(st.nextToken()); // 구간의 합을 구하는 횟수
		arr = new long[N];
		for (int i = 0; i < N; i++)
			arr[i] = Long.parseLong(br.readLine());

		// 세그먼트트리 생성
		tree = new long[N * 4];
		init(0, N - 1, 1);
//		System.out.println(Arrays.toString(tree));

		for (int i = 0; i < M + K; i++) { // 수를 변경하거나, 합을 구한다
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()); // 1이면 수를 변경, 2이면 합을 구하기
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());

			if (a == 1) { // 수 변경
				long diff = c - arr[b - 1];
				treeUpdate(0, N - 1, 1, b - 1, diff);
			} else // 합 구하기
				sb.append(treeSum(0, N - 1, 1, b - 1, c - 1)).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void treeUpdate(int start, int end, int node, int index, long diff) {
		if(index < start || index > end) return;
		
		tree[node] += diff;
		if(start == end) {
			arr[index] = tree[node];
			return;
		}
		int mid = (start + end) / 2;
		treeUpdate(start, mid, node * 2, index, diff);
		treeUpdate(mid + 1, end, node * 2 + 1, index, diff);
	}

	static long treeSum(int start, int end, int node, int left, long right) {
		if (left > end || right < start)
			return 0;
		if (left <= start && right >= end)
			return tree[node];

		int mid = (start + end) / 2;
		return treeSum(start, mid, node * 2, left, right) + treeSum(mid + 1, end, node * 2 + 1, left, right);
	}

	static long init(int start, int end, int node) {
		if (start == end)
			return tree[node] = arr[start];

		int mid = (start + end) / 2;
		return tree[node] += init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
	}

}
