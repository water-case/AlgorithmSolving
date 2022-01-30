package level24_dfsAndBfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class pb01_1260 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		int V = Integer.parseInt(token.nextToken());
		
		DBfs dbfs = new DBfs(N);
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(br.readLine());
			dbfs.add(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
		}
		dbfs.dfs(V);
		dbfs.reset();
		System.out.println();
		dbfs.bfs(V);
	}
}

class DBfs {
	public int v;
	public boolean[] visit;
	public List<Integer> list[];
	public Queue<Integer> q;
	
	public DBfs(int n) {
		v = n+1;
		visit = new boolean[v];
		list = new LinkedList[v];
		for(int i=1; i<v; i++)
			list[i] = new LinkedList<Integer>();
		q = new LinkedList<Integer>();
	}
	
	public void reset() {
		visit = new boolean[v];
	}
	
	public void add(int n, int v) {
		list[n].add(v);
		list[v].add(n);
	}
	
	public void dfs(int v) {
		if(visit[v] == true) return;
		visit[v] = true;
		
		System.out.print(v + " ");
		list[v].sort((o1, o2)->{ return o1-o2; });
		for (int i = 0; i < list[v].size(); i++) {
			dfs(list[v].get(i));
		}
	}
	
	public void bfs(int v) {
		if(visit[v] == false) {
			visit[v] = true;
			System.out.print(v + " ");
		}
		
		list[v].sort((o1, o2)->{ return o1-o2; });
		for (int i = 0; i < list[v].size(); i++) {
			if(visit[list[v].get(i)] == true) continue;
			else {
				visit[list[v].get(i)] = true;
				q.add(list[v].get(i));
				System.out.print(list[v].get(i) + " ");
			}
		}
//		System.out.println();
//		System.out.println(q.size());
//		System.out.println(q.poll());
		if(!q.isEmpty()) {
			bfs(q.poll());
		}
	}
	
}