package level38_SegmentTree;

import java.io.*;
import java.util.*;

public class pb06_P3_9345_디지털비디오디스크 {

	static int[] arr;
	static int[][] tree;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // DVD들의 수
			int K = Integer.parseInt(st.nextToken()); // 대여점에서 일어나는 사건의 수

			arr = new int[N];
			tree = new int[N * 4][2]; // 0번인덱스 최소값, 1번인덱스 최대값
			
			for (int i = 0; i < N; i++)
				arr[i] = i;
			init(0, N-1, 1);
//			for(int i=0; i<N * 4; i++)
//				System.out.print(tree[i][1] + " ");
//			System.out.println();
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int Q = Integer.parseInt(st.nextToken());
				int A = Integer.parseInt(st.nextToken()); // Q가 0이면 A와 B를 바꾼다
				int B = Integer.parseInt(st.nextToken()); // Q가 1이면 A부터 B까지 선반을 가져옴
				
				if(Q == 0) {
					update(0, N-1, 1, A, arr[B]);
					int tmp = arr[A];
					arr[A] = arr[B];
					update(0, N-1, 1, B, tmp);
					arr[B] = tmp;
				} else {
					if(query(0, N-1, 1, A, B)) sb.append("YES");
					else sb.append("NO");
					sb.append("\n");
				}
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
	
	static void update(int start, int end, int node, int target, int num) {
		if(target < start || target > end) return;
		if(start == end) {
			tree[node][0] = num;
			tree[node][1] = num;
			return;
		}
		
		int mid = (start + end) / 2;
		update(start, mid, node * 2, target, num);
		update(mid + 1, end, node * 2 + 1, target, num);
		tree[node][0] = Math.min(tree[node * 2][0], tree[node * 2 + 1][0]);
		tree[node][1] = Math.max(tree[node * 2][1], tree[node * 2 + 1][1]);
	}
	
	static boolean query(int start, int end, int node, int left, int right) {
		if(left > end || right < start) return true;
		if(left <= start && right >= end) return left <= tree[node][0] && right >= tree[node][1];
		
		int mid = (start + end) / 2;
		return query(start, mid, node * 2, left ,right) && query(mid + 1, end, node * 2 + 1, left, right);
	}
	
	static int[] init(int start, int end, int node) {
		if(start == end) {
			tree[node][0] = arr[start];
			tree[node][1] = arr[start];
			return tree[node];
		}
		
		int mid = (start + end) / 2;
		int[] a = init(start, mid, node * 2);
		int[] b = init(mid + 1, end, node * 2 + 1);
		tree[node][0] = a[0];
		tree[node][1] = b[1];
		return tree[node];
	}
}
