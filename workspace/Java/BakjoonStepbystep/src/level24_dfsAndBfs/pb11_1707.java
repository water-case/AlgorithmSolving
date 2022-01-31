package level24_dfsAndBfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class pb11_1707 {

	static int V, E;
	static int[] color;
	static List<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			V = Integer.parseInt(token.nextToken()); // 정점, 1부터시작이므로 1을 더해줌
			E = Integer.parseInt(token.nextToken()); // 간선
			color = new int[V+1]; // 1 또는 2
			graph = new ArrayList[V+1]; // 각 정점별 간선배열선언
			for (int i = 0; i <= V; i++)
				graph[i] = new ArrayList<Integer>(); // 간선배열 생성
			for (int i = 0; i < E; i++) { // 각 정점에 인접정점 add
				token = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(token.nextToken());
				int b = Integer.parseInt(token.nextToken());
				graph[a].add(b);
				graph[b].add(a);
			}
			Queue<Integer> q = new LinkedList<Integer>();
			end: for (int i = 1; i <= V; i++) {
				if (color[i] == 0) {
					q.add(i);
					color[i] = 1;
				}

				while (!q.isEmpty()) {
					int now = q.poll();
					for (int j = 0; j < graph[now].size(); j++) {
						if (color[graph[now].get(j)] == 0) {
							q.add(graph[now].get(j));
						}
						if (color[graph[now].get(j)] == color[now]) {
							System.out.println("NO");
							break end;
						}
						if (color[now] == 1 && color[graph[now].get(j)] == 0) {
							color[graph[now].get(j)] = 2;
						} else if (color[now] == 2 && color[graph[now].get(j)] == 0) {
							color[graph[now].get(j)] = 1;
						}
					}
				}
				if (i == V - 1)
					System.out.println("YES");
			}
		}
	}

}
