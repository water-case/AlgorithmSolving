package level24_dfsAndBfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class pb09_2206 {

	static class Pos {
		int x, y, cnt;
		boolean destroyed;

		public Pos(int x, int y, int cnt, boolean destroyed) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.destroyed = destroyed;
		}
	}

	static int[][] deltas = new int[][] { { -1, 0 }, // 상
			{ 0, 1 }, // 우
			{ 1, 0 }, // 하
			{ 0, -1 }, // 좌
	};
	static int[][] arr;
	static int N, M, ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++)
				arr[i][j] = s.charAt(j) - 48;
		}

		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(0, 0, 1, false));

		boolean[][][] visit = new boolean[2][N][M];

		while (!q.isEmpty()) {
			Pos now = q.poll();
			if (now.x == N - 1 && now.y == M - 1) {
				System.out.println(now.cnt);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int dx = now.x + deltas[i][0];
				int dy = now.y + deltas[i][1];
				if (dx < 0 || dx >= N || dy < 0 || dy >= M)
					continue;
				int count = now.cnt + 1;

				if (arr[dx][dy] == 0) {
					if (!now.destroyed && !visit[0][dx][dy]) {
						q.add(new Pos(dx, dy, count, false));
						visit[0][dx][dy] = true;
					} else if (now.destroyed && !visit[1][dx][dy]) {
						q.add(new Pos(dx, dy, count, true));
						visit[1][dx][dy] = true;
					}
				} else if (arr[dx][dy] == 1) {
					if(!now.destroyed) {
						q.add(new Pos(dx,dy,count, true));
						visit[1][dx][dy] = true;
					}
				}
			}
		}
		System.out.println(-1);

//		bfs(0, 0);
////		for(int[] a: arr) System.out.println(Arrays.toString(a));
//		if(arr[N-1][M-1] == 0) {
//			System.out.println(-1);
//		} else {
//			System.out.println(ans);
//		}
	}

//	static void bfs(int x, int y) {
//		Queue<int[]> q = new LinkedList<>();
//		q.add(new int[] {x, y});
//		arr[x][y] = 2;
//		int count = 1;
//		if(x == N-1 && y == M-1) ans = Math.min(ans, count);
//		
//		
//		while(!q.isEmpty()) {
//			int qc = q.size();
//			for(int qt = 0; qt<qc; qt++) {
//				int[] tmp = q.poll();
//				for(int i=0; i<4; i++) {
//					int dx = tmp[0]+deltas[i][0];
//					int dy = tmp[1]+deltas[i][1];
//					if(dx < 0 || dx >= N || dy < 0 || dy >= M) continue;
//					if(dx == N-1 && dy == M-1) ans = Math.min(ans, count+1);
//					if(arr[dx][dy] == 1) {
//						bfsW(dx, dy, count+1);
//					} else if(arr[dx][dy] == 0 || arr[dx][dy] > 3) {
//						arr[dx][dy] = 2;
//						q.add(new int[] {dx, dy});
//					}
//				}
//			}
//			count++;
////			for(int[] a: arr) System.out.println(Arrays.toString(a));
////			System.out.println(count);
//		}
//	}
//	
//	static void bfsW(int x, int y, int c) {
//		Queue<int[]> q = new LinkedList<>();
//		q.add(new int[] {x, y});
//		
//		int count = c+1;
//		
//		while(!q.isEmpty()) {
//			int qc = q.size();
//			for(int qt = 0; qt<qc; qt++) {
//				int[] tmp = q.poll();
//				for(int i=0; i<4; i++) {
//					int dx = tmp[0]+deltas[i][0];
//					int dy = tmp[1]+deltas[i][1];
//					if(dx < 0 || dx >= N || dy < 0 || dy >= M) continue;
//					if(dx == N-1 && dy == M-1) ans = Math.min(ans, count);
//					if(arr[dx][dy] == 0 || arr[dx][dy] > count){
//						arr[dx][dy] = count;
//						q.add(new int[] {dx, dy});
//					}
//				}
//			}
////			System.out.println("w");
////			for(int[] a: arr) System.out.println(Arrays.toString(a));
////			System.out.println(count);
//			count++;
//		}
//	}
}
