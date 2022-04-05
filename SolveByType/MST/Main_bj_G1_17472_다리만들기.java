package a0401;

import java.io.*;
import java.util.*;

public class Main_bj_G1_17472_다리만들기 {

	static class Edge implements Comparable<Edge> {
		int start, end, dist;

		public Edge(int start, int end, int dist) {
			this.start = start;
			this.end = end;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			return dist - o.dist;
		}

	}

	static int[] delx=new int[] {-1, 0, 1, 0}; // 상우하좌
	static int[] dely=new int[] { 0, 1, 0,-1}; // 상우하좌
	static int N, M;
	static int[][] map, mparent;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		map = new int[N][M];
		mparent = new int[N][M];

		for (int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(token.nextToken());
		}

		// 섬의 개수 세기
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && mparent[i][j] == 0) {
					cnt++;
					mapping(cnt, i, j);
				}
			}
		}

		parent = new int[cnt+1];
		for (int i = 1; i <= cnt; i++)
			parent[i] = i;

		ArrayList<Edge> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (mparent[i][j] != 0) {
					for (int k = 0; k < 4; k++) {
						int count = 0;
						int dx = i + delx[k], dy = j + dely[k];
						if (dx < 0 || dx >= N || dy < 0 || dy >= M) continue;
						if(mparent[dx][dy] == 0) {
							count++;
							dx += delx[k]; dy += dely[k];
							if (dx < 0 || dx >= N || dy < 0 || dy >= M) continue;
							while(true) {
								if(mparent[dx][dy] != 0 && mparent[dx][dy] != mparent[i][j] && count >= 2) {
									list.add(new Edge(mparent[i][j], mparent[dx][dy], count));
									break;
								}
								if(mparent[dx][dy] != 0) break;
								count++;
								dx += delx[k]; dy += dely[k];
							}
						}
					}
				}
			}
		}
		Collections.sort(list);
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			Edge now = list.get(i);
			if(!union(now.start, now.end)) {
				sum += now.dist;
			}
		}
		
		for(int i=2; i<=cnt; i++) {
			if(!union(i-1, i)) {
				System.out.println(-1);
				break;
			}
			if(i == cnt) System.out.println(sum);
		}
	}

	static void mapping(int cnt, int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { x, y });
		mparent[x][y] = cnt;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 0; i < 4; i++) {
				int dx = now[0] + delx[i];
				int dy = now[1] + dely[i];
				if (dx < 0 || dx >= N || dy < 0 || dy >= M)
					continue;
				if (map[dx][dy] == 1 && mparent[dx][dy] == 0) {
					mparent[dx][dy] = cnt;
					q.add(new int[] { dx, dy });
				}
			}
		}
	}

	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) return true;
		parent[b] = a;
		return false;
	}

	static int find(int a) {
		a = parent[a];
		if (a == parent[a])
			return a;
		return parent[a] = find(parent[a]);
	}

}
