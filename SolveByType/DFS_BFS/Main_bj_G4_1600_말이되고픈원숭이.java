import java.io.*;
import java.util.*;

public class Main_bj_G4_1600_말이되고픈원숭이 {

	static int[] delx=new int[] {-1, 0, 1, 0}; //상우하좌
	static int[] dely=new int[] { 0, 1, 0,-1}; //상우하좌
	static int[] horsex=new int[] {-2,-1, 1, 2, 2, 1,-1,-2}; // 12시부터 시계방향으로 
	static int[] horsey=new int[] { 1, 2, 2, 1,-1,-2,-2,-1}; // 12시부터 시계방향으로
	
	static int K, W, H;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bj_1600"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		K=Integer.parseInt(br.readLine()); // 말이동횟수
		st=new StringTokenizer(br.readLine()," ");
		W=Integer.parseInt(st.nextToken()); // 가로
		H=Integer.parseInt(st.nextToken()); // 세로
		map=new int[H][W];
		for(int i=0; i<H; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<W; j++)
				map[i][j]=Integer.parseInt(st.nextToken());
		}
		
		int cnt=bfs(0,0,0);
		System.out.println(cnt);
	}
	static int bfs(int x, int y, int hcnt) {
		boolean[][][] v=new boolean[K+1][H][W];
		v[0][x][y]=true;
		ArrayDeque<int[]> q=new ArrayDeque<>();
		q.offer(new int[] {x,y,0,0}); // 3번 카운트, 4번 말이동횟수
		while(!q.isEmpty()) {
			int[] now=q.poll();
			
			if(now[0]==H-1 && now[1]==W-1) {
				return now[2];
			}
			
			if(now[3]<K) {
				for(int d=0; d<8; d++) {
					int dx=now[0]+horsex[d], dy=now[1]+horsey[d];
					if(dx<0||dx>=H||dy<0||dy>=W||v[now[3]+1][dx][dy]||map[dx][dy]==1) continue;
					v[now[3]+1][dx][dy]=true;
					q.offer(new int[] {dx,dy,now[2]+1,now[3]+1});
				}
			}
			for(int d=0; d<4; d++) {
				int dx=now[0]+delx[d], dy=now[1]+dely[d];
				if(dx<0||dx>=H||dy<0||dy>=W||v[now[3]][dx][dy]||map[dx][dy]==1) continue;
				v[now[3]][dx][dy]=true;
				q.offer(new int[] {dx,dy,now[2]+1,now[3]});
			}
		}
		return -1;
	}

}
