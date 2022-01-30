package level24_dfsAndBfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class pb02_2606 {
	
	static int count = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());
		int L = Integer.parseInt(br.readLine());
		Dfs dfs = new Dfs(C);
		for(int i=0; i<L; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			dfs.add(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
		}
		dfs.dfs(1);
		System.out.println(count);
	}
	
	static class Dfs {
		private int v;
		private boolean[] visit;
		private LinkedList<Integer>[] list;
		
		public Dfs(int n) {
			v = n + 1;
			visit = new boolean[v];
			list = new LinkedList[v];
			for(int i=0; i<v; i++) {
				list[i] = new LinkedList<Integer>();
			}
		}
		
		public void add(int n, int v) {
			list[n].add(v);
			list[v].add(n);
		}
		public void dfs(int v) {
			if(visit[v] == true) return;
			visit[v] = true;
			
			list[v].sort((o1, o2)->{ return o1-o2; });
			for(int i=0; i<list[v].size(); i++) {
				if(visit[list[v].get(i)] == true) {
					dfs(list[v].get(i));
				} else {
					count++;
					dfs(list[v].get(i));
				}
			}
		}
	}
}
