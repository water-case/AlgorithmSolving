package level31_treeDp;

import java.io.*;
import java.util.*;

public class pb02_2213 {

	static int n;
	static int[] arr;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	static PriorityQueue<Integer> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine()); // 트리 정점의 수
		arr = new int[n + 1]; // 정점 가중치 배열
		visited = new boolean[n + 1];

		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
			tree.add(new ArrayList<>());
		}

		StringTokenizer token = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++)
			arr[i] = Integer.parseInt(token.nextToken());

		for (int i = 1; i < n; i++) { // 간선 입력
			token = new StringTokenizer(br.readLine());
			int a1 = Integer.parseInt(token.nextToken());
			int a2 = Integer.parseInt(token.nextToken());
			list.get(a1).add(a2);
			list.get(a2).add(a1);
		}
		
		treeBuilder(1, -1); // 1이 루트노드인 트리만들기
		
		int a1 = dp(1,false);
		int a2 = dp(1,true);
		
		if(a1 > a2)
			visited[1] = false;
		else
			visited[1] = true;
		sb.append(Math.max(a1, a2)).append("\n");
		
		searchNode(1, visited[1]);
		while(!pq.isEmpty())
			sb.append(pq.poll()).append(" ");
		
		System.out.println(sb);
	}
	
	static void searchNode(int now, boolean visit) {
		if(visit) {
			pq.offer(now);
			for(int son : tree.get(now))
				searchNode(son, false);
		} else {
			for(int son : tree.get(now))
				searchNode(son, visited[son]);
		}
	}
	
	static int dp(int now, boolean visit) {
		int result = 0;
		
		if(visit) {
			for(int son : tree.get(now))
				result += dp(son, false);
			return result + arr[now];
		}else {
			for(int son : tree.get(now)) {
				int a1 = dp(son, false);
				int a2 = dp(son, true);
				
				if(a1 > a2)
					visited[son] = false;
				else
					visited[son] = true;
				result += Math.max(a1, a2);
			}
			return result;
		}
	}
	
	static void treeBuilder(int now, int parent) {
		for(int son : list.get(now)) {
			if(son != parent) {
				tree.get(now).add(son);
				treeBuilder(son, now);
			}
		}
	}

}
