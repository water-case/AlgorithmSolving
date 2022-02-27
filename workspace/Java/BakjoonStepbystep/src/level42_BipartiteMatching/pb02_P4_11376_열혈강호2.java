package level42_BipartiteMatching;

import java.io.*;
import java.util.*;

/*
 * 각 직원마다 매칭을 두번해준다
 */

public class pb02_P4_11376_열혈강호2 {

	static ArrayList<Integer>[] graph;
	static int[] work;
	static boolean[] v;
	static int N,M;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		graph=new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			graph[i]=new ArrayList<>();
			st=new StringTokenizer(br.readLine()," ");
			int n=Integer.parseInt(st.nextToken());
			for(int j=0; j<n; j++) graph[i].add(Integer.parseInt(st.nextToken()));
		}
		
		int cnt=0;
		work=new int[M+1];
		for(int i=1; i<=N; i++) {
			for(int j=0;j<2;j++) {
				v=new boolean[M+1];
				if(dfs(i)) cnt++; 
			}
		}
		System.out.println(cnt);
	}
	
	static boolean dfs(int x) {
		for(int next:graph[x]) {
			if(v[next]) continue;
			v[next]=true;
			if(work[next]==0||dfs(work[next])) {
				work[next]=x;
				return true;
			}
		}
		return false;
	}

}
