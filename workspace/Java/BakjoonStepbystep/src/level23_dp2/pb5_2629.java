package level23_dp2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb5_2629 {
	
	static int N,M;
	static int[] cu;
	static boolean[][] dp;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cu = new int[N+1];
		StringTokenizer token = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) cu[i] = Integer.parseInt(token.nextToken());
		dp = new boolean[31][15001];
		
		cf(0, 0);
		
		M = Integer.parseInt(br.readLine());
		token = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int a = Integer.parseInt(token.nextToken());
			if(a > 15000) sb.append("N ");
			else sb.append(dp[N][a]? "Y ":"N ");
		}
		System.out.println(sb);
	}
	
	static void cf(int idx, int w) {
		if(dp[idx][w]) return;
		dp[idx][w] = true;
		if(idx == N) return;
		
		cf(idx + 1, w + cu[idx+1]);
		cf(idx + 1, w);
		cf(idx + 1, Math.abs(w - cu[idx+1]));
	}
}