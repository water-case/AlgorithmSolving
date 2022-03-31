import java.io.*;
import java.util.*;

public class Main_bj_G5_2636_치즈 {

	static int[] delx=new int[] {-1, 0, 1, 0}; // 상우하좌
	static int[] dely=new int[] { 0, 1, 0,-1}; // 상우하좌
	static int[][] map;
	static int r,c;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_2636"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		map=new int[r][c];
		
		for(int i=0; i<r; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<c; j++)
				map[i][j]=Integer.parseInt(st.nextToken());
		}
		
		int time=0;
		while(true) {
			time++;
			
			boolean[][] cheese=new boolean[r][c];
			// 녹일부분 체크
//		dfs(cheese,0,0);
			bfs(cheese,0,0);
			
			int savecnt=0; // 녹기전 개수 세기
			// 닿는부분 녹이기
			for(int i=0; i<r; i++)
				for(int j=0; j<c; j++)
					if(cheese[i][j] && map[i][j]==1) {
						savecnt++;
						map[i][j]=0;
					}
			
			// 다 녹았는지 체크, 다 녹았으면 시간과 이전 치즈수 출력후 종료
			int cnt=0;
			for(int i=0; i<r; i++)
				for(int j=0; j<c; j++)
					if(map[i][j]==1) cnt++;
			
			if(cnt==0) {
				System.out.println(time);
				System.out.println(savecnt);
				break;
			}
		}
		br.close();
	}
	
	static void bfs(boolean[][] cheese, int i, int j) {
		ArrayDeque<int[]> q=new ArrayDeque<>();
		q.add(new int[] {i,j});
		
		while(!q.isEmpty()) {
			int[] now=q.poll();
			
			if(cheese[now[0]][now[1]]) continue;
			cheese[now[0]][now[1]]=true;
			
			for(int d=0; d<4; d++) {
				int dx=now[0]+delx[d], dy=now[1]+dely[d];
				if(dx<0||dx>=r||dy<0||dy>=c||cheese[dx][dy]) continue;
				if(map[dx][dy]==1) {
					cheese[dx][dy]=true;
					continue;
				}
				q.offer(new int[] {dx,dy});
			}
		}
	}

	static void dfs(boolean[][] cheese, int i, int j) {
		cheese[i][j]=true;
		for(int d=0; d<4; d++) {
			int dx=i+delx[d], dy=j+dely[d];
			if(dx<0||dx>=r||dy<0||dy>=c||cheese[dx][dy]) continue;
			if(map[dx][dy]==1) {
				cheese[dx][dy]=true;
				continue;
			}
			dfs(cheese,dx,dy);
		}
	}

}
