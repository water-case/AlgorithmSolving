package level23_dp2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb6_2293 {

	static int n, k;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		n = Integer.parseInt(token.nextToken());
		k = Integer.parseInt(token.nextToken());
		dp = new int[k + 1];
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			int coin = Integer.parseInt(br.readLine());
			for (int j = coin; j <= k; j++) {
				dp[j] += dp[j-coin];
			}
		}
		System.out.println(dp[k]);
	}

}
