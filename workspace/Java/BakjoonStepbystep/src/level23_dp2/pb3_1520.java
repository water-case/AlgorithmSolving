package level23_dp2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pb3_1520 {
	
	static int[][] deltas = {
			{-1,  0}, // 상
			{ 0,  1}, // 우
			{ 1,  0}, // 하
			{ 0, -1} // 좌
	};
	static int[][] map;
	static int M, N;
	static Integer[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		M = Integer.parseInt(token.nextToken());
		N = Integer.parseInt(token.nextToken());
		map = new int[M][N];
		dp = new Integer[M][N];
		
		for (int i = 0; i < M; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(token.nextToken());
		}
		
		System.out.println(cf(0, 0, map[0][0], -1));
//		for(Integer[] a : dp) System.out.println(Arrays.toString(a));
	}
	static int cf(int x, int y, int v, int direct) {
		if(x == M-1 && y == N-1) {
			return 1;
		}
		if(dp[x][y] == null) {
			int count = 0;
			for (int i = 0; i < 4; i++) {
				int dx = x+deltas[i][0];
				int dy = y+deltas[i][1];
				if(dx < 0 || dx > M-1 || dy < 0 || dy > N-1) continue;
				if(map[dx][dy] < v) {
					count += cf(dx, dy, map[dx][dy], i);
				}
			}
			dp[x][y] = count;
		}
		return dp[x][y];
	}

}
