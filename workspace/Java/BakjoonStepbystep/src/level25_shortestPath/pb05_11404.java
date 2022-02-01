package level25_shortestPath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pb05_11404 {

	static class Node {
		int end, price;

		public Node(int end, int price) {
			this.end = end;
			this.price = price;
		}
	}
	
	static int N, M;
	static long[][] ans;
	static ArrayList<Node>[] graph;
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();
		for(int i=0; i<M; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int a1 = Integer.parseInt(token.nextToken());
			int a2 = Integer.parseInt(token.nextToken());
			int a3 = Integer.parseInt(token.nextToken());
			graph[a1].add(new Node(a2, a3));
		}
		ans = new long[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i == j) ans[i][j] = 0;
				else ans[i][j] = Integer.MAX_VALUE;
			}
		}
		
		floydWarshall();
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(ans[i][j] == Integer.MAX_VALUE) {
					sb.append("0 ");
					continue;
				}
				sb.append(ans[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void floydWarshall() {
		
		boolean check = false;
		for(int i=1; i<=N; i++) {
			for(Node node : graph[i]) {
				if(ans[i][node.end] > node.price) {
					ans[i][node.end] = node.price;
				}
			}
		}
		while(true) {
			check = false;
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(i == j) continue;
					for(int k=1;k<=N; k++) {
						if(ans[i][j] > ans[i][k] + ans[k][j]) {
							ans[i][j] = ans[i][k] + ans[k][j];
							check = true;
						}
					}
				}
			}
			if(!check) break;
		}
	}
}
