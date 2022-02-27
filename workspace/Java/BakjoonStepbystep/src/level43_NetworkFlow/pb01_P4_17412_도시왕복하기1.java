package level43_NetworkFlow;

import java.io.*;
import java.util.*;

public class pb01_P4_17412_도시왕복하기1 {

	static ArrayList<Integer>[] graph;
	static int[][] flow, cap;
	static int[] v;
	static int ans,N,P;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken()); // 도시의 개수
		P=Integer.parseInt(st.nextToken()); // 길의 개수
		cap=new int[N+1][N+1];
		flow=new int[N+1][N+1];
		v=new int[N+1];
		graph=new ArrayList[N+1];
		for(int i=1; i<=N; i++)graph[i]=new ArrayList<>();
		
		for(int i=0; i<P; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
			cap[a][b]=1;
		}
		
		bfs();
		System.out.println(ans);
		
	}
	
	static void bfs() {
		while(true) {
			Queue<Integer> q=new ArrayDeque<>();
			Arrays.fill(v, -1);
			q.offer(1);
			
			while(!q.isEmpty()) {
				int now=q.poll();
				for(int next:graph[now]) {
					if(v[next]!=-1) continue;
					if(cap[now][next]>flow[now][next]) { // 유량이 남아있으면 이어준다
						v[next]=now;
						if(next==2) break;
						q.offer(next);
					}
				}
			}
			if(v[2]==-1) break; // 더 이상 이을 수 없으면 종료
			for(int i=2; i!=1; i=v[i]) {
				flow[v[i]][i]++; // 현재 이어진 경로에 유량을 채움
				flow[i][v[i]]--; // 이어진 경로 역방향에 유량을 뺌, 현재 문제에선 사용을 안하지만 다른 문제에서 사용하게됨
			}
			ans++;
		}
	}

}
