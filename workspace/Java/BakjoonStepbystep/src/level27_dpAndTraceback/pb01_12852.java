package level27_dpAndTraceback;

import java.util.Scanner;

public class pb01_12852 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] dp = new int[N + 1];
		int[] trace = new int[N + 1];

		dp[1] = 0;

		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + 1;
			trace[i] = i - 1;

			if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
				dp[i] = dp[i / 2] + 1;
				trace[i] = i / 2;
			}

			if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
				dp[i] = dp[i / 3] + 1;
				trace[i] = i / 3;
			}
		}

		System.out.println(dp[N]);
		int idx = N;
		for (int i = 0; i <= dp[N]; i++) {
			System.out.print(idx + " ");
			idx = trace[idx];
		}

	}
}
