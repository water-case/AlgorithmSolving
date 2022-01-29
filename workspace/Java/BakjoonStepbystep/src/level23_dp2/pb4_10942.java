package level23_dp2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb4_10942 {

	static int[] nums;
	static int N, M;
	static Integer[][] dp;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		dp = new Integer[N][N];
		StringTokenizer token = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < M; t++) {
			token = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(token.nextToken())-1;
			int b = Integer.parseInt(token.nextToken())-1;
			if (dp[a][b] == null) {
				int tmp1 = a, tmp2 = b;
				while(tmp2 >= tmp1) {
					if(nums[tmp2--] != nums[tmp1++]) {
						dp[a][b] = 0;
						break;
					}
					dp[a][b] = 1;
				}
			}
			sb.append(dp[a][b]+"\n");
		}
		System.out.println(sb);
	}

}
