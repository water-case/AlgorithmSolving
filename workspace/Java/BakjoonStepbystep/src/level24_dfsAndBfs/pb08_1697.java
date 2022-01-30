package level24_dfsAndBfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class pb08_1697 {

	static int N, K;
	static int[] visit = new int[100_001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 수빈이 위치
		K = sc.nextInt(); // 동생 위치

		System.out.println(bfs(N));
	}

	static int bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);

		int idx = start;
		int n = 0;
		visit[idx] = 1;

		while (!q.isEmpty()) {
			n = q.poll();
			if (n == K) return visit[n] - 1;
			if (n - 1 >= 0 && visit[n - 1] == 0) {
				visit[n - 1] = visit[n] + 1;
				q.add(n - 1);
			}
			if (n + 1 <= 100_000 && visit[n + 1] == 0) {
				visit[n + 1] = visit[n] + 1;
				q.add(n + 1);
			}
			if (2 * n <= 100_000 && visit[2 * n] == 0) {
				visit[2 * n] = visit[n] + 1;
				q.add(n * 2);
			}
		}
		return -1;
//		if (q.isEmpty()) return;
//		int tmp = q.size();
//		for (int i = 0; i < tmp; i++) {
//			int a = q.poll();
//			if(a < 0 || a > 100_000) continue;
//			if(arr[a] == -1)
//				return;
//			if(q.contains(a)) continue;
//			if(arr[a] != 0) continue;
//			arr[a] = day;
////			System.out.println(a);
//			if (a > K) {
//				q.add(a - 1);
////			} else if (K / (a + 1) > 5) {
////				q.add(a + 1);
////				q.add(a * 2);
//			} else {
//				q.add(a * 2);
//				q.add(a + 1);
//				q.add(a - 1);
//			}
//		}
	}

}
