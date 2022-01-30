package level24_dfsAndBfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class pb07_7569 {

	static int[][] deltas = new int[][] {
		{ 0, -1, 0}, // 앞
		{ 0, 0, 1}, // 오른쪽
		{ 0, 1, 0}, // 뒤
		{ 0, 0,-1}, // 왼쪽
		{-1, 0, 0}, // 위
		{ 1, 0, 0}, // 아래
	};
	static int[][][] box;
	static int M, N, H, days;
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		M = Integer.parseInt(token.nextToken());
		N = Integer.parseInt(token.nextToken());
		H = Integer.parseInt(token.nextToken());
		box = new int[H][N][M];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				token = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					box[i][j][k] = Integer.parseInt(token.nextToken());
				}
			}
		}
		bfs(days);
		label:for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if(box[i][j][k] == 0) {
						System.out.println(-1);
						break label;
					}
				}
			}
			if(i == H-1)
				System.out.println(days-1);
		}
//		for(int[][] a:box) {
//			for(int[] b:a)
//				System.out.println(Arrays.toString(b));
//		}
	}
	
	static void bfs(int day) {
		if(days == 0) {
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < M; k++) {
						if (box[i][j][k] == day + 1) {
							q.add(new int[] { i, j, k });
						}
					}
				}
			}
		}
		if(q.isEmpty()) return;
		int qtc = q.size();
		for (int qc = 0; qc < qtc; qc++) {
			int[] tmp = q.poll();
			for (int i = 0; i < 6; i++) {
				int dh = tmp[0] + deltas[i][0];
				int dx = tmp[1] + deltas[i][1];
				int dy = tmp[2] + deltas[i][2];
				if (dh < 0 || dh >= H || dx < 0 || dx >= N || dy < 0 || dy >= M)
					continue;
//				System.out.println(dh + " " + dx + " " + dy);
				if (box[dh][dx][dy] == 0) {
					box[dh][dx][dy] = day + 2;
					q.add(new int[] { dh, dx, dy });
				}
			}
		}
		days++;
		bfs(days);
	}

}
