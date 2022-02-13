package level33_dp3;

import java.io.*;
import java.util.*;

public class pb06_2482 {

	static int MOD = 1_000_000_003;
	static int N, K;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		if (K * 2 > N) {
			System.out.println(0);
			System.exit(0);
		}
		dp = new int[N + 1][N + 1]; // N개의 색이 있을때 N개 선택할 수 있는 경우의 수
		for (int i = 1; i <= N; i++) {
			dp[i][1] = i; // 1개 선택할 수 있는 경우의수는 선택할 수 있는 색의 개수
			dp[i][0] = 1; // 0개 선택할 수 있는 경우의수는 그 상황 자체이므로 1
		}
		
		// i번째 색을 선택한경우, 선택하지않은 경우로 나누어 메모이제이션
		for(int i = 2; i <= N; i++) {
			for(int j=2; j<=K; j++)
				dp[i][j] = (dp[i-1][j] + dp[i-2][j-1]) % MOD;
		}
		
		// N번쨰 색을 선택한 경우와 선택하지않은 경우를 더함
		// N번째 색을 선택한 경우 N-2가 아닌 N-3인 이유는
		// N번째 색을 선택했으면 첫번째색은 선택할 수 없으므로 N-2개의 색에서 1을 감해주기 때문임
		System.out.println((dp[N-3][K-1] + dp[N-1][K]) % MOD);
		
//		for(int[] a : dp)
//			System.out.println(Arrays.toString(a));
	}

}
