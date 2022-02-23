package level38_SegmentTree;

import java.io.*;
import java.util.*;

/*
 * 크게 어려운 부분은 없었지만 자꾸 틀렸습니다가 출력되어서 매우 골치썩었던 문제이다
 * 문제가 되었던 부분은 출력및 삭제할때, 본인은 출력및 삭제를 동시에 진행했다
 * 내려가면서 숫자를 -- 시켜주었는데
 * 이 부분을 출력후 삭제하기로 나누어주니 해결이 되었다
 * 꽤 오랜 시간을 들여 고민하고 데이터크기를 줄여서 테스트 해보았으나 위와같은 방법의 문제점을 찾기 어려웠다
 * 추후에 제대로된 원인분석을 하도록 하겠다
 */

public class pb08_P4_12899_데이터구조 {

	static int[] tree;
	static int n = 2_000_000;
//	static int tree_size = 20, query_size = 5;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 쿼리가 200만번이루어지므로 최대 크기는 800만
		// 추가할 숫자의 크기도 200만, 숫자가 인덱스라고 생각하고 풀이
		int h=(int)Math.ceil(Math.log(n)/Math.log(2));
		tree = new int[1 << h + 1];

		int N = Integer.parseInt(br.readLine()); // 쿼리의 수
		for (int i = 0; i < N; i++) { // 쿼리수행
			st = new StringTokenizer(br.readLine(), " ");
			int mode = Integer.parseInt(st.nextToken()); // 1:추가, 2:출력 및 삭제
			int num = Integer.parseInt(st.nextToken()); // 쿼리 대응 숫자
			if (mode == 1) { // 추가
				update(1, n, 1, num, 1);
			} else { // 출력 및 삭제
				int val = query(1, n, 1, num);
				sb.append(query(1, n, 1, num)).append("\n");
				update(1, n, 1, val, -1);
			}
		}
		System.out.println(sb.toString());
		br.close();
	}

	static int query(int start, int end, int node, int num) {
		if(start == end)
			return start;
		int mid = (start + end) / 2;
		if (num <= tree[node * 2]) { // 왼쪽
			return query(start, mid, node * 2, num);
		} else { // 오른쪽
			return query(mid + 1, end, node * 2 + 1, num - tree[node * 2]);
		}
	}

	static int update(int start, int end, int node, int idx, int diff) {
		if (idx < start || idx > end)
			return tree[node];
		if (start == end)
			return tree[node] += diff;
		int mid = (start + end) / 2;
		return tree[node] = update(start, mid, node * 2, idx, diff) + update(mid + 1, end, node * 2 + 1, idx, diff);
	}

}
