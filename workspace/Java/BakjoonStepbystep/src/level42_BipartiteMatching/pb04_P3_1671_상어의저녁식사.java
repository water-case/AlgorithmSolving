package level42_BipartiteMatching;

import java.io.*;
import java.util.*;

public class pb04_P3_1671_상어의저녁식사 {

	static ArrayList<Integer>[] graph;
	static int[] v;
	static int[] eat, eaten;
	static int visitCnt;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N=Integer.parseInt(br.readLine());
		int[][] shark=new int[N][3];
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<3; j++) shark[i][j]=Integer.parseInt(st.nextToken());
		}
		
		graph=new ArrayList[N];
		for(int i=0; i<N; i++) {
			graph[i]=new ArrayList<>();
			for(int j=0; j<N; j++) {
				if(i==j) continue;
				if(shark[i][0]==shark[j][0] && shark[i][1]==shark[j][1] && shark[i][2]==shark[j][2] && i>j) continue;
				if(shark[i][0]>=shark[j][0] && shark[i][1]>=shark[j][1] && shark[i][2]>=shark[j][2])
					graph[i].add(j);
			}
		}
		
		eat=new int[N]; eaten=new int[N];
		Arrays.fill(eat, -1); Arrays.fill(eaten, -1);
		int cnt=0;
		visitCnt=1;
		v=new int[N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<2; j++) {
				visitCnt++;
				if(dfs(i)) cnt++;
			}
		}
		System.out.println(N-cnt);
	}
	
	static boolean dfs(int x) {
		if(v[x]==visitCnt) return false;
		v[x]=visitCnt;
		for(int next:graph[x]) {
			if(eaten[next]==-1||dfs(eaten[next])) {
				eat[x]=next;
				eaten[next]=x;
				return true;
			}
		}
		return false;
	}

}
