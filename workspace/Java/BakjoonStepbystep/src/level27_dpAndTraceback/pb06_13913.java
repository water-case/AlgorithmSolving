package level27_dpAndTraceback;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class pb06_13913 {

	static int N, K;
	static int[] last;
	static Integer[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		N = sc.nextInt();
		K = sc.nextInt();
		last = new int[100002];
		dp = new Integer[100002];

		Queue<Integer[]> q = new LinkedList<>();
		q.add(new Integer[] { N, -1, 0 });
		last[N] = 0;
		while (!q.isEmpty()) {
			Integer[] now = q.poll();
			int n = now[0];
			int c = now[1];
			if (n == K) {
				dp[n] = c + 1;
				last[n] = now[2];
				break;
			}
			if (dp[n] == null) {
				dp[n] = c + 1;
				last[n] = now[2];
				if(n*2 < 100002)
					q.add(new Integer[] { n * 2, c + 1, n });
				if(n+1 < 100002)
					q.add(new Integer[] { n + 1, c + 1, n });
				if(n-1 >= 0)
					q.add(new Integer[] { n - 1, c + 1, n });
			}
		}

		sb.append(dp[K]).append("\n");
//		System.out.println(Arrays.toString(dp));
//		System.out.println(Arrays.toString(last));
		Stack stack = new Stack<>();
		stack.push(K);
		int n = last[K];
		for (int i = 0; i < dp[K]; i++) {
			stack.push(n);
			n = last[n];
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(sb);
	}
}
