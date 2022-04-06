package a0406;

import java.io.*;
import java.util.*;

public class Main_bj_G4_3055_탈출 {

	static int[] delx=new int[] {-1, 0, 1, 0}; // 상우하좌
	static int[] dely=new int[] { 0, 1, 0,-1}; // 상우하좌
	static int N,M,ans;
	static char[][] map;
	static ArrayDeque<int[]> q, dq;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_3055"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st;
		
		st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new char[N][M];
		for(int i=0; i<N; i++)
			map[i]=br.readLine().toCharArray();
		
		q=new ArrayDeque<>();
		dq=new ArrayDeque<>();
		for(int i=0; i<N; i++)
			for(int j=0; j<M; j++)
					 if(map[i][j]=='S')  q.offer(new int[] {i,j,0});
				else if(map[i][j]=='*') dq.offer(new int[] {i,j});
		
		ans=0;
		bfs();
		
		if(ans!=0) System.out.println(ans);
		else System.out.println("KAKTUS");
		br.close();
	}
	
	static void bfs() {
		while(true) {
			int qs=dq.size();
			for(int i=0; i<qs; i++) {
				int[] now=dq.poll();
				for(int d=0; d<4; d++) {
					int dx=now[0]+delx[d], dy=now[1]+dely[d];
					if(dx<0||dx>=N||dy<0||dy>=M||map[dx][dy]=='*'||map[dx][dy]=='X'||map[dx][dy]=='D') continue;
					map[dx][dy]='*';
					dq.offer(new int[] {dx,dy});
				}
			}
			
			qs=q.size();
			for(int i=0; i<qs; i++) {
				int[] now=q.poll();
				if(map[now[0]][now[1]]=='D') {
					ans=now[2];
					return;
				}
				for(int d=0; d<4; d++) {
					int dx=now[0]+delx[d], dy=now[1]+dely[d];
					if(dx<0||dx>=N||dy<0||dy>=M||map[dx][dy]=='*'||map[dx][dy]=='X'||map[dx][dy]=='S') continue;
					if(map[dx][dy]!='D') map[dx][dy]='S';
					q.offer(new int[] {dx,dy,now[2]+1});
				}
			}
			if(q.isEmpty()) break;
		}
	}
}
