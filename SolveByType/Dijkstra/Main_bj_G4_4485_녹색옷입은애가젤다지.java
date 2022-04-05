package a0401;

import java.io.*;
import java.util.*;

public class Main_bj_G4_4485_녹색옷입은애가젤다지 {

	static class Pos implements Comparable<Pos> {
		int x,y,price;

		public Pos(int x, int y, int price) {
			this.x = x;
			this.y = y;
			this.price = price;
		}
		
		@Override
		public int compareTo(Pos o) {
			return Integer.compare(price, o.price);
		}
	}
	
	static int[] delx=new int[] {-1, 0, 1, 0}; // 상우하좌
	static int[] dely=new int[] { 0, 1, 0,-1}; // 상우하좌
	static int N,min;
	static int[][] map, dist;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_4485"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int cnt=1;
		while(true) {
			N=Integer.parseInt(br.readLine());
			if(N==0) break;
			dist=new int[N][N];
			map=new int[N][N];
			for(int i=0; i<N; i++)
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			
			for(int i=0; i<N; i++) {
				st=new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N;j++)
					map[i][j]=Integer.parseInt(st.nextToken());
			}
			dijkstra();
			System.out.println("Problem "+cnt+++": "+dist[N-1][N-1]);
		}

		br.close();
	}

	static void dijkstra() {
		dist[0][0]=map[0][0];
		PriorityQueue<Pos> pq=new PriorityQueue<>();
		pq.add(new Pos(0, 0, map[0][0]));
		
		while(!pq.isEmpty()) {
			Pos now=pq.poll();
			
			for(int d=0; d<4; d++) {
				int dx=now.x+delx[d], dy=now.y+dely[d];
				if(dx<0||dx>=N||dy<0||dy>=N) continue;
				if(dist[dx][dy]>dist[now.x][now.y]+map[dx][dy]) {
					dist[dx][dy]=dist[now.x][now.y]+map[dx][dy];
					pq.add(new Pos(dx, dy, dist[dx][dy]));
				}
			}
		}
	}
	
}
