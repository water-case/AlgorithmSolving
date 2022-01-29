package level23_dp2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pb2_11049 {

	static int[][] arr;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		for (int t = 0; t < N; t++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			arr[t][0] = Integer.parseInt(token.nextToken());
			arr[t][1] = Integer.parseInt(token.nextToken());
		}
		dp = new int[N][N];
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < N - i; j++) {
				dp[j][j + i] = Integer.MAX_VALUE;
				for (int k = 0; k < i; k++) {
					int cnt = dp[j][j + k] + dp[j + k + 1][j + i] + arr[j][0] * arr[j + k][1] * arr[j + i][1];
					dp[j][j + i] = Math.min(dp[j][j + i], cnt);
				}
			}
		}
		
//		for (int i = 0; i < N; i++)
//			dp[i][i] = arr[i][0] * arr[i][1];
//		for (int i = 0; i < N - 1; i++)
//			dp[i][i + 1] = dp[i][i] * arr[i + 1][1];
//		
//		for (int gap = 2; gap < N; gap++) {
//			for (int i = 0; i + gap < N; i++) {
//				int j = i + gap;
//				dp[i][j] = Integer.MAX_VALUE;
//				for (int k = i; k < j; k++) {
//					dp[i][j] = Math.min(dp[i][j], dp[i][k]+arr[i][0]*dp[k+1][j]);
//					System.out.println(i + " " + j + " " +  k  + ": " + dp[i][j]);
//				}
//			}
//		}
//		for(int[] a:arr) System.out.print(Arrays.toString(a));
//		System.out.println();
//		for(int[] a:dp) System.out.print(Arrays.toString(a));
		System.out.println(dp[0][N-1]);

	}

}
