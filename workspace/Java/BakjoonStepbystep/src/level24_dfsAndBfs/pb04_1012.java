package level24_dfsAndBfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pb04_1012 {
	
	static int[][] deltas = new int[][] {
		{-1, 0}, // 상
		{ 0, 1}, // 우
		{ 1, 0}, // 하
		{ 0,-1}, // 좌
	};
	static int[][] arr;
	static boolean[][] visit;
	static int N, M, ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			ans = 0;
			StringTokenizer token = new StringTokenizer(br.readLine());
			M = Integer.parseInt(token.nextToken());
			N = Integer.parseInt(token.nextToken());
			arr = new int[N][M];
			visit = new boolean[N][M];
			int K = Integer.parseInt(token.nextToken());
			for (int kc = 0; kc < K; kc++) {
				token = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(token.nextToken()); 
				int y = Integer.parseInt(token.nextToken()); 
				arr[y][x] = 1;
			}
//			System.out.println(arr);
//			for(int[] a:arr) System.out.println(Arrays.toString(a));
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 1 && visit[i][j] == false) {
						dfs(i, j);
						ans++;
					}
				}
			}
//			System.out.println();
//			System.out.println(visit);
//			for(boolean[] a:visit) System.out.println(Arrays.toString(a));
			System.out.println(ans);
		}
	}
	
	static void dfs(int x, int y) {
		if(visit[x][y] == true) return;
		visit[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int dx = x + deltas[i][0];
			int dy = y + deltas[i][1];
			if(dx < 0 || dx > N-1 || dy < 0 || dy > M-1) continue;
			if(arr[dx][dy] == 1)
				dfs(dx, dy);
		}
	}
}
