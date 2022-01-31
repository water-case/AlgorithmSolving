package level25_shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class pb01_1753 {
	
	static class Node implements Comparable<Node> {
		int end, weight;
		
		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
	}
	
	static ArrayList<Node>[] graph; // 그래프 배열
	static int[] ans; // 각 정점 최단 가중치 배열
	static int V, E, start;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		V = Integer.parseInt(token.nextToken());
		E = Integer.parseInt(token.nextToken());
		start = Integer.parseInt(br.readLine());
		graph = new ArrayList[V+1];
		for(int i=1; i<=V; i++) graph[i] = new ArrayList<Node>();
		ans = new int[V+1];
		for(int i=0; i<=V; i++) {
			ans[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < E; i++) {
			token = new StringTokenizer(br.readLine());
			int a =Integer.parseInt(token.nextToken());
			int b =Integer.parseInt(token.nextToken());
			int weight =Integer.parseInt(token.nextToken());
			
			graph[a].add(new Node(b, weight));
		}
		
		dijkstra(start);
		
		for(int i=1; i<ans.length; i++) {
			if(ans[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(ans[i]);
			}
		}
		
//		Queue<int[]> q = new LinkedList<>();
//		for(int i=0; i<graph[start].size(); i++) {
//			q.add(new int[] {start, graph[start].get(i)});
//		}
//		ans[start] = 0;
//		while(!q.isEmpty()) {
//			int[] now = q.poll();
//			int a = now[0];
//			int b = now[1];
//			if(ans[b] > ans[a] + value[a][b]) {
//				ans[b] = ans[a] + value[a][b];
//			} else {
//				continue;
//			}
//			for(int i=0; i<graph[b].size(); i++) {
//				q.add(new int[] {b, graph[b].get(i)});
//			}
//		}
//		for(int i=1; i<ans.length; i++) {
//			if(ans[i] == Integer.MAX_VALUE) {
//				System.out.println("INF");
//			} else {
//				System.out.println(ans[i]);
//			}
//		}
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] check = new boolean[V+1];
		pq.add(new Node(start, 0));
		ans[start] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			int ne = now.end;

			if(check[ne] == true) continue;
			check[ne] = true;
			
			for(Node n : graph[ne]) {
				if(ans[n.end] > ans[ne] + n.weight) {
					ans[n.end] = ans[ne] + n.weight;
					pq.add(new Node(n.end, ans[n.end]));
				}
			}
		}
		
	}
}