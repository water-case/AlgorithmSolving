package level38_SegmentTree;

import java.io.*;
import java.util.*;

/*
 * 세그먼트트리 개념자체는 확실하게 이해했지만 응용 부분에서 어려움을 겪은 문제이다.
 * 이해하는데 대략 하루정도 걸린것 같다.
 * 이 문제는 주어진 숫자나열에서 버블정렬로 바꾼 횟수를 구하는것이었다.
 * 주어지는 숫자의 개수는 최대 500_000개, 수의 범위는 1_000_000_000 이하이다
 * 인덱스(입력된숫자나열에서의 순서)와 숫자를 하나의 클래스변수에 넣고, 그 클래스변수의 배열을 만들어서
 * 숫자크기로 정렬을 해주었다.
 * 정렬 후 세그먼트트리에 하나씩 넣으면서 먼저 입력된 숫자들중 뒤에 위치한 갯수를 구한다.
 * 본인은 이것을 머리로 이해하고 작성하려했지만 어려움을 겪었고, 
 * 다른 언어로 작성된 코드를 자바코드로 바꾸면서 이해할 수 있었다.
 * 이해하는데 어려움을 겪는다면 코드작성을 하면서 이해를 해보는것을 추천한다.
 * 
 * 횟수를 누적합하는 변수를 long으로 설정하지않으면 터지므로 주의할것
 * 
 */

public class pb05_P5_1517_버블소트 {

	static class Node implements Comparable<Node> {
		int idx, num;

		public Node(int idx, int num) {
			this.idx = idx;
			this.num = num;
		}

		@Override
		public int compareTo(Node o) {
			return num - o.num;
		}

	}

	static int[] tree;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // N개의 수
		Node[] arr = new Node[N];
		tree = new int[N * 4];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			arr[i] = new Node(i, Integer.parseInt(st.nextToken()));

		Arrays.sort(arr);
		
		long ans = 0;
		for (int i = 0; i < N; i++) {
			int idx = arr[i].idx;
			ans += calTree(0, N - 1, 1, idx + 1, N - 1);
			updateTree(0, N - 1, 1, idx);
		}
		System.out.println(ans);
		System.out.println(Arrays.toString(tree));
	}

	static void updateTree(int start, int end, int node, int idx) {
		if (start == end) {
			tree[node] = 1;
			return;
		}
		int mid = (start + end) / 2;
		if (idx <= mid)
			updateTree(start, mid, node * 2, idx);
		else
			updateTree(mid + 1, end, node * 2 + 1, idx);
		tree[node] = tree[2 * node] + tree[2 * node + 1];
	}

	static int calTree(int start, int end, int node, int left, int right) {
		if (left > end || right < start)
			return 0;
		if (left <= start && right >= end)
			return tree[node];
		int mid = (start + end) / 2;
		return calTree(start, mid, node * 2, left, right) + calTree(mid + 1, end, node * 2 + 1, left, right);
	}

}
