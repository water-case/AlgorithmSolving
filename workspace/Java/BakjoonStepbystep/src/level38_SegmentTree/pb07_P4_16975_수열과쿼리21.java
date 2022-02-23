package level38_SegmentTree;

import java.io.*;
import java.util.*;

/*
 * 배열로 풀면 되지 않을까? 잠깐 생각이 들었지만 바보같은 생각이다
 * 수열의 크기가 10만이고, 쿼리가 10만개다.
 * 만약에 10만개에 전부 연산이 들어가야 하는경우 그걸 10만번하면 1000만번의 연산을 해야한다
 * 무조건 다른 방법을 강구해야하는데 문제의 테마는 세그먼트 트리이다
 * 쿼리에 적용되는 범위의 가장 상위 공통 노드에 k를 더해주고
 * 이후 찾을때 거슬러 올라가면서 상위 노드들에 저장된 k연산을 실행해주고 출력하는 방법을 사용했다
 * 
 * 주의할점 : k의 값으로 100만이 주어지는데 쿼리횟수가 10만이므로 int로는 터짐
 * 자료형을 long으로 두고 해야한다
 */

public class pb07_P4_16975_수열과쿼리21 {

	static long[] arr;
	static long[] tree;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 수열의 크기
		arr = new long[N + 1];
		tree = new long[N * 4];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++)
			arr[i] = Long.parseLong(st.nextToken());

		init(1, N, 1);

//		System.out.println(Arrays.toString(tree));
		int M = Integer.parseInt(br.readLine()); // 쿼리의 개수
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int mode = Integer.parseInt(st.nextToken()); // 1:더하기, 2:출력
			int a = Integer.parseInt(st.nextToken());
			if (mode == 1) {
				int b = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				update(1, N, 1, a, b, k);
			} else {
				sb.append(query(1, N, 1, a)).append("\n");
			}
		}
//		System.out.println(Arrays.toString(tree));
		System.out.println(sb.toString());
		br.close();
	}

	static long query(int start, int end, int node, int idx) {
		long result = 0;
		if (idx > end || idx < start)
			return 0;
		if(start == end) return tree[node];
		else result += tree[node];
		int mid = (start + end) / 2;
		result += (long)(query(start, mid, node * 2, idx) + query(mid + 1, end, node * 2 + 1, idx));
		return result;
	}

	static void update(int start, int end, int node, int left, int right, int k) {
		if (left > end || right < start)
			return;
		if (left <= start && right >= end) {
			tree[node] += k;
			return;
		}
		int mid = (start + end) / 2;
		update(start, mid, node * 2, left, right, k);
		update(mid + 1, end, node * 2 + 1, left, right, k);
	}

	static void init(int start, int end, int node) {
		if (start == end) {
			tree[node] = arr[start];
			return;
		}
		int mid = (start + end) / 2;
		init(start, mid, node * 2);
		init(mid + 1, end, node * 2 + 1);
	}

}