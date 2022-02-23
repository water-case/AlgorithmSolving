package level38_SegmentTree;

import java.io.*;
import java.util.*;

/*
 * 8번 문제와 같이 애를 좀 먹었다.
 * 출력과 삭제를 동시에 하려하니 문제가 있었다
 * 출력과 삭제를 따로해주어야한다
 * 찾는 idx순서와, 삭제해야하는 값이 다르기 때문이다
 * 본인은 idx순서와 삭제해야하는 값을 혼동하여 문제가 있었다
 */

public class pb09_P4_1168_요세푸스문제2 {

	static int[] nums, tree;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // N명의 사람
		int K = Integer.parseInt(st.nextToken()); // K번째 사람을 제거

		nums = new int[N + 1];
		tree = new int[N * 4];
		for (int i = 1; i <= N; i++)
			nums[i] = i;
		init(1, N, 1);

		sb.append("<");

		int idx = 1;
		for (int i = 0; i < N; i++) {
			int size = N - i;
			idx += K - 1;
			
			if(idx % size == 0) idx = size;
			else if(idx > size) idx %= size;
			int num = query(1, N, 1, idx);
			update(1, N, 1, num);
//			System.out.println(i + " " + size + " " + idx + " " + num);
			sb.append(num).append(", ");
		}

		sb.delete(sb.length() - 2, sb.length());
		sb.append(">");
		System.out.println(sb.toString());
		br.close();
	}

	static int update(int start, int end, int node, int idx) {
		tree[node]--;
		if (start == end) {
			return 0;
		}
		int mid = (start + end) / 2;
		if (idx <= mid)
			return update(start, mid, node * 2, idx);
		else
			return update(mid + 1, end, node * 2 + 1, idx);
	}

	static int query(int start, int end, int node, int idx) {
		if (start == end) {
			return start;
		}
		int mid = (start + end) / 2;
		if (idx <= tree[node * 2])
			return query(start, mid, node * 2, idx);
		else
			return query(mid + 1, end, node * 2 + 1, idx - tree[node * 2]);
	}

	static int init(int start, int end, int node) {
		if (start == end) {
			return tree[node] = 1;
		}
		int mid = (start + end) / 2;
		return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
	}

}
