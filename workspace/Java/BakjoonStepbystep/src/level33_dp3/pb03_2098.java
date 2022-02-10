package level33_dp3;

import java.io.*;
import java.util.*;

public class pb03_2098 {

	static int N;
	static int[][] arr, dp;
	static final int NO = 17_000_000;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 도시의 수
		arr = new int[N][N]; // 비용 행렬
		dp = new int[N][(1 << N) - 1]; // 비트를 이용하기 위한 메모이제이션 배열
		for(int i=0; i<N; i++)
			Arrays.fill(dp[i], NO);
		
		// 비용 행렬 입력받기
		for (int i = 0; i < N; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				arr[i][j] = Integer.parseInt(token.nextToken());
		}

		System.out.println(cf(0, 1));
		br.close();

	}
	
	static int cf(int n, int bit) {
		if (bit == (1 << N) - 1) {
			if(arr[n][0] == 0) return NO;
			return arr[n][0];
		}
		
		if(dp[n][bit] != NO) return dp[n][bit];
		
		for(int i=0; i<N; i++) {
			if(arr[n][i] != 0 && (bit & (1 << i)) == 0) {
				dp[n][bit] = Math.min(dp[n][bit], arr[n][i] + cf(i, bit | (1 << i)));
			}
		}
		
		return dp[n][bit];
	}

}
