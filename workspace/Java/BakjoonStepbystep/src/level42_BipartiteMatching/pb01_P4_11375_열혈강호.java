package level42_BipartiteMatching;

import java.io.*;
import java.util.*;

/*
 * 이분그래프에서 A1->B1 정점으로 이어주는데
 * A2정점은 B1으로 이어줄 경우밖에 없을때
 * A1->B1 이아닌 A1->B2 or A1->B3와 같은 경우가 남아있을경우
 * 해당 경우로 교체후 A2->B1을 이어줌
 * 위와 같은 매커니즘으로 최대이을 수 있는 간선을 구하는 문제를 이분매칭문제라고 할 수 있따
 */

public class pb01_P4_11375_열혈강호 {

	static ArrayList<Integer>[] graph;
	static boolean[] v;
	static int[] work;
	static int N,M;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken()); // 직원의 수
		M=Integer.parseInt(st.nextToken()); // 일의 개수
		
		graph=new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			graph[i]=new ArrayList<>();
			st=new StringTokenizer(br.readLine()," ");
			int n=Integer.parseInt(st.nextToken()); // i번 직원이 할 수 있는 일의 개수
			for(int j=0; j<n; j++) graph[i].add(Integer.parseInt(st.nextToken()));
		}
		
		int cnt=0;
		work=new int[M+1]; // 각 일을 담당하기로 정해진 직원 저장배열
		for(int i=1; i<=N; i++) {
			v=new boolean[M+1]; // 각 정점의 간선 방문확인 배열
			if(dfs(i)) cnt++;
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
