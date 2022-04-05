import java.io.*;
import java.util.*;

public class Main_bj_G1_1194_달이차오른다가자 {

	static class Pos {
		int x,y,cnt,key;
		public Pos(int x, int y, int cnt, int key) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.key = key;
		}
	}
	
	static int[] delx=new int[] {-1, 0, 1, 0}; // 상우하좌
	static int[] dely=new int[] { 0, 1, 0,-1}; // 상우하좌
	static char[][] map;
	static int N,M;
	static boolean[][][] v;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1194"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N=Integer.parseInt(st.nextToken()); // 세로
		M=Integer.parseInt(st.nextToken()); // 가로
		map=new char[N][M];
		v=new boolean[N][M][1<<6]; // 2^6가지의 경우의수(key가 최대 6개)
		
		// 맵 입력 받기
		for(int i=0; i<N; i++) map[i]=br.readLine().toCharArray(); 
		
		// 민식이의 위치찾기
		int x=-1, y=-1;
		for(int i=0; i<N; i++)
			for(int j=0; j<M; j++)
				if(map[i][j]=='0') {
					x=i; y=j;
				}
		
		System.out.println(bfs(x,y));
		br.close();
	}
	
	static int bfs(int x, int y) {
		ArrayDeque<Pos> q=new ArrayDeque<>();
		v[x][y][0]=true;
		q.offer(new Pos(x, y, 0, 0));
		
		while(!q.isEmpty()) {
			Pos now=q.poll();
			for(int d=0; d<4; d++) {
				int dx=now.x+delx[d], dy=now.y+dely[d];
				// 좌표초과,이미방문,벽인경우
				if(dx<0||dx>=N||dy<0||dy>=M||v[dx][dy][now.key]||map[dx][dy]=='#') continue;
				// 출구인 경우
				if(map[dx][dy]=='1') return now.cnt+1;
				// 열쇠인경우
				else if(map[dx][dy]>='a' && map[dx][dy]<='f') {
					int nextkey=(1<<map[dx][dy]-'a') | now.key; // 현재 키상태에서 해당 키세팅
					if(!v[dx][dy][nextkey]) {
						v[dx][dy][nextkey]=true;  // 키를 가진상태 방문처리
						v[dx][dy][now.key]=true; // 재방문을 방지하기위한 처리
						q.offer(new Pos(dx, dy, now.cnt+1, nextkey));
					}
				// 문인경우
				} else if(map[dx][dy]>='A' && map[dx][dy]<='F') {
					// 열쇠있으면
					if(((1<<map[dx][dy]-'A') & now.key) > 0) {
						v[dx][dy][now.key]=true;
						q.offer(new Pos(dx, dy, now.cnt+1, now.key));
					}
				// 평지인경우
				} else {
					v[dx][dy][now.key]=true;
					q.offer(new Pos(dx, dy, now.cnt+1, now.key));
				}
			}
		}
		return -1;
	}
	
}
