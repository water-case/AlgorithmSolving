package level24_dfsAndBfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class pb10_7562 {

	static class Pos {
		int x,y,cnt;
		
		public Pos(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	static int[][] deltas = new int [][] {
		{-2, 1},
		{-1, 2}, // 우상
		{ 1, 2},
		{ 2, 1}, // 우하
		{ 2,-1},
		{ 1,-2}, // 좌하
		{-1,-2},
		{-2,-1}, // 좌상
	};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t < tc; t ++ ) {
			int MSize  = Integer.parseInt(br.readLine());
			int[][] map = new int[MSize][MSize];
			StringTokenizer token = new StringTokenizer(br.readLine());
			Pos start = new Pos(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()), 0);
			token = new StringTokenizer(br.readLine());
			int Rx = Integer.parseInt(token.nextToken());
			int Ry = Integer.parseInt(token.nextToken());
			if(Rx == start.x && Ry == start.y) {
				System.out.println(0);
				continue;
			}
			
			Queue<Pos> q = new LinkedList<>();
			q.add(start);

			end:while (!q.isEmpty()) {
				Pos now = q.poll();
				map[now.x][now.y] = 1;
				for (int i = 0; i < 8; i++) {
					int dx = now.x + deltas[i][0];
					int dy = now.y + deltas[i][1];
					if(dx < 0 || dx >= MSize || dy < 0 || dy >= MSize) continue;
					if(dx == Rx && dy == Ry) {
						System.out.println(now.cnt + 1);
						break end;
					}
					if(map[dx][dy] != 1) {
						q.add(new Pos(dx,dy,now.cnt+1));
						map[dx][dy] = 1;
					}
				}
			}
		}
	}

}
