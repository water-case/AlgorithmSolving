package level23_dp2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb7_7579 {
	
	static int N, M, sum = 0;
	static int[] memorys, costs, dp;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		memorys = new int[N];
		costs = new int[N];
		token = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) memorys[i] = Integer.parseInt(token.nextToken());
		token = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			costs[i] = Integer.parseInt(token.nextToken());
			sum += costs[i];
		}
		dp = new int[sum+1];
		for (int i = 0; i < N; i++) {
			for (int j = sum; j >= costs[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - costs[i]] + memorys[i]);
			}
		}
		
		for(int i=0; i<=sum; i++) {
			if(dp[i] >= M) {
				System.out.println(i);
				break;
			}
		}
		
	}
}
