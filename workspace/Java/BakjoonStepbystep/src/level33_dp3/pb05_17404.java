package level33_dp3;

import java.io.*;
import java.util.*;

public class pb05_17404 {

	static int N, min;
	static int[][] arr;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) arr[i][j] = Integer.parseInt(token.nextToken());
		}
		
		int min = 1_000_000_000;
		dp = new int[N][3];
		for (int i = 0; i < 3; i++) { // 첫집색깔 고정시킨다
			for(int j=0; j<N; j++) Arrays.fill(dp[j], 1_000_000_000);
			for(int j=0; j < 3; j++)
				if(i == j) dp[0][j] = arr[0][j];
			
			for (int j = 1; j < N; j++) {
				dp[j][0] = Math.min(dp[j-1][1], dp[j-1][2]) + arr[j][0];
				dp[j][1] = Math.min(dp[j-1][0], dp[j-1][2]) + arr[j][1];
				dp[j][2] = Math.min(dp[j-1][0], dp[j-1][1]) + arr[j][2];
			}
			
			for (int j = 0; j < 3; j++)
				if (i != j) min = Math.min(min, dp[N - 1][j]);
		}
		System.out.println(min);
		
	}
}
