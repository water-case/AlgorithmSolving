package level23_dp2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb1_11066 {

	static int[] files;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int K = Integer.parseInt(br.readLine());
			files = new int[K];
			StringTokenizer token = new StringTokenizer(br.readLine());
			for (int i = 0; i < K; i++) files[i] = Integer.parseInt(token.nextToken());
			sb.append(cf() + "\n");
		}
		System.out.println(sb);
	}
	
	static int cf() {
		int size = files.length;
		int[][] dp = new int[size][size];
		int[] sum = new int[size];
		
		sum[0] = files[0];
		for (int i = 1; i < sum.length; i++) sum[i] = sum[i-1]+files[i];
		for (int i = 0; i < size - 1; i++) dp[i][i+1] = files[i]+files[i+1];
		
		for (int f = 2; f < size; f++) {
			for (int i = 0; i + f < size; i++) {
				int j = i + f;
				dp[i][j] = Integer.MAX_VALUE;
				
				for (int k = i; k < j; k++) dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + partSum(sum, i, j));
			}
		}
//		System.out.println(Arrays.toString(sum));
//		for(int[] a:dp)
//			System.out.println(Arrays.toString(a));
		
		return dp[0][size-1];
	}
	
	static int partSum(int[] sum, int first, int end) {
		if (first == 0) return sum[end];
		else return sum[end]-sum[first-1];
	}

}
