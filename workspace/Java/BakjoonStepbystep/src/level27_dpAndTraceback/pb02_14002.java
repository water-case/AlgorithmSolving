package level27_dpAndTraceback;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb02_14002 {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer token = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(token.nextToken());

		int[] dp = new int[N];
		int[] trace = new int[N];
		int idx = N - 1;
		dp[N - 1] = 1;
		trace[N - 1] = -1;

		for (int i = N - 2; i >= 0; i--) {
			if (arr[i] < arr[i + 1]) {
				dp[i] = dp[i + 1] + 1;
				trace[i] = i + 1;
			}
			for (int j = i + 1; j < N; j++) {
				if (arr[i] < arr[j] && dp[i] < dp[j]+1) {
					dp[i] = dp[j]+1;
					trace[i] = j;
//						break;
				}
			}
			if(dp[i] == 0) {
				dp[i] = 1;
				trace[i] = -1;
			}
			if(dp[i] > dp[idx])
				idx = i;
		}
//		System.out.println(idx);
//		System.out.println(Arrays.toString(dp));
//		System.out.println(Arrays.toString(trace));
		
		System.out.println(dp[idx]);
		while(idx != -1) {
			sb.append(arr[idx] + " ");
			idx = trace[idx];
		}
		System.out.println(sb);
	}

}
