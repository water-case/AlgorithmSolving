package level24_dfsAndBfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class pb05_2178 {

	static int[][] deltas = new int[][] { { -1, 0 }, // 상
			{ 0, 1 }, // 좌
			{ 1, 0 }, // 하
			{ 0, -1 }, // 우
	};
	static int N, M, ans = Integer.MAX_VALUE;
	static int[][] arr;
	static boolean[][] visit;
//	static Queue<Integer[]> q = new LinkedList<Integer[]>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());

		arr = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++)
				arr[i][j] = s.charAt(j) - 48;
		}

		bfs(0, 0);
		System.out.println(arr[N-1][M-1]);
	}

	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 0; i < 4; i++) {
				int dx = now[0] + deltas[i][0];
				int dy = now[1] + deltas[i][1];
				if (dx < 0 || dx >= N || dy < 0 || dy >= M )
					continue;
				if (arr[dx][dy] == 1 && visit[dx][dy] == false) {
					q.add(new int[] { dx, dy });
					arr[dx][dy] = arr[now[0]][now[1]] + 1;
					visit[dx][dy] = true;
				}
			}
			
		}
		
//		if (x == N - 1 && y == M - 1)
//			ans = Math.min(ans, count);
//		if(ans == N+M-1) return;
//		if (visit[x][y] == true)
//			return;
//		visit[x][y] = true;
//		
//		Queue<Integer[]> q = new LinkedList<Integer[]>();
//		for (int i = 0; i < 4; i++) {
//			int dx = x + deltas[i][0];
//			int dy = y + deltas[i][1];
//			if (dx < 0 || dx > N - 1 || dy < 0 || dy > M - 1)
//				continue;
//			if (arr[dx][dy] == 1 && visit[dx][dy] == false) {
//				q.add(new Integer[] { dx, dy });
//			}
//		}
////		System.out.println(x + " " + y + " " + count + " " + q.size());
//		while (!q.isEmpty()) {
//			Integer[] tmp = q.poll();
//			bfs(tmp[0], tmp[1], count + 1);
//		}
//		visit[x][y] = false;
	}

//	static void dfs(int x, int y, int count) {
//		if (x == N - 1 && y == M - 1) {
//			ans = Math.min(ans, count);
//			return;
//		}
//		for (int i = 0; i < 4; i++) {
//			int dx = x+deltas[i][0];
//			int dy = y+deltas[i][1];
//			if(dx < 0 || dx > N - 1 || dy < 0 || dy > M-1) continue;
//			if(arr[dx][dy] == 1 && ans > count) {
//				arr[dx][dy] = -1;
//				dfs(dx, dy, count + 1);
//				arr[dx][dy] = 1;
//				if(ans == N+M-1) return;
//			}
//		}
//	}

}
