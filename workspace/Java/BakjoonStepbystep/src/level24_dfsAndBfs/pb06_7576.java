package level24_dfsAndBfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class pb06_7576 { // BFS 문제

	static int[][] deltas = new int[][] {
		{-1, 0}, // 상
		{ 0, 1}, // 우
		{ 1, 0}, // 하
		{ 0,-1}, // 좌
	};
	static int[][] box;
	static int days, N, M;
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		M = Integer.parseInt(token.nextToken());
		N = Integer.parseInt(token.nextToken());
		box = new int[N][M];
		for (int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				box[i][j] = Integer.parseInt(token.nextToken());
		}
		bfs(days);
		label:for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(box[i][j] == 0) {
					System.out.println(-1);
					break label;
				}
			}
			if(i == N-1)
				System.out.println(days-1);
		}
//		for(int[] a:box)System.out.println(Arrays.toString(a));
	}
	
	static void bfs(int day) {
		if(days == 0) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(box[i][j] == day+1) {
						q.add(new int[] {i,j});
					}
				}
			}
		}
		if(q.isEmpty()) return;
		int qtc = q.size();
		for(int qc = 0; qc<qtc; qc++) {
			int[] tmp = q.poll();
			for(int i=0; i<4; i++) {
				int dx = tmp[0]+deltas[i][0];
				int dy = tmp[1]+deltas[i][1];
				if(dx < 0 || dx >= N || dy < 0 || dy >= M) continue;
				if(box[dx][dy] == 0) {
					box[dx][dy] = day+2;
					q.add(new int[] {dx, dy});
				}
			}
		}
		days++;
		bfs(days);
	}

}
