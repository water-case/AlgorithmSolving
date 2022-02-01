package level25_shortestPath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class pb06_10217 {

	static class Node implements Comparable<Node> {
		int end, price, hour;

		public Node(int end, int price, int hour) {
			this.end = end;
			this.price = price;
			this.hour = hour;
		}

		@Override
		public int compareTo(Node o) {
			return hour - o.hour;
		}
	}

	static int N, M, K;
	static long[][] dp;
	static ArrayList<Node>[] graph;
	static PriorityQueue<Node> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			long answer = Integer.MAX_VALUE;
			StringTokenizer token = new StringTokenizer(br.readLine());
			N = Integer.parseInt(token.nextToken()); // 정점
			M = Integer.parseInt(token.nextToken()); // 비용
			K = Integer.parseInt(token.nextToken()); // 간선
			dp = new long[N + 1][M + 1];
			graph = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				graph[i] = new ArrayList<>();
				Arrays.fill(dp[i], Integer.MAX_VALUE);
			}
			for (int i = 0; i < K; i++) {
				token = new StringTokenizer(br.readLine());
				int a1 = Integer.parseInt(token.nextToken());
				int a2 = Integer.parseInt(token.nextToken());
				int a3 = Integer.parseInt(token.nextToken());
				int a4 = Integer.parseInt(token.nextToken());
				graph[a1].add(new Node(a2, a3, a4));
			}

			pq = new PriorityQueue<>();
			dp[1][0] = 0;
			pq.add(new Node(1, 0, 0));
			
			while(!pq.isEmpty()) {
				Node now = pq.poll();
				
				System.out.println(now.end);
				if(now.end == N) {
					answer = Math.min(answer, now.hour);
					break;
				}
				
				for(Node node : graph[now.end]) {
					int sumPrice = now.price + node.price;
					if(sumPrice > M) continue;
					
					int sumHour = now.hour + node.hour;
					if(dp[node.end][sumPrice] > sumHour) {
						dp[node.end][sumPrice] = sumHour;
						pq.add(new Node(node.end, sumPrice, sumHour));
					}
				}
			}
			
			if(answer == Integer.MAX_VALUE)
				System.out.println("Poor KCM");
			else
				System.out.println(answer);
			
//			ans = new long[N + 1][N + 1][2]; // 0번 배열은 비용, 1번배열은 시간
//			for (int i = 1; i <= N; i++)
//				for (int j = 1; j <= N; j++) {
//					ans[i][j][0] = Integer.MAX_VALUE;
//					ans[i][j][1] = Integer.MAX_VALUE;
//				}
//
//			cf();
//			if(ans[1][N][1] == Integer.MAX_VALUE) {
//				System.out.println("Poor KCM");
//			} else {
//				int min = Integer.MAX_VALUE;
//				for(int i=1; i<=N; i++) {
//					min = (int) Math.min(min, ans[i][N][1]);
//				}
//				System.out.println(min);
//			}
		}
	}

//	static void cf() {
//		PriorityQueue<Node> pq = new PriorityQueue<>();
//		pq.add(new Node(1, 0, 0));
//		ans[1][1][0] = 0;
//		ans[1][1][1] = 0;

//		while(!pq.isEmpty()) {
//			Node now = pq.poll();
//			int ne = now.end;
//			for(Node node : graph[ne]) {
//				
//			}
//		}

//		while (!pq.isEmpty()) {
//			Node now = pq.poll();
//			int ne = now.end;
//			for (Node node : graph[ne]) {
//				long price = ans[ne][node.end][0];
//				long hour = ans[ne][node.end][1];
//				if (now.price + node.price > price && now.hour + node.hour > hour)
//					continue;
//				if (now.price + node.price <= price && now.hour + node.hour <= hour) {
//					ans[ne][node.end][0] = now.price + node.price;
//					ans[ne][node.end][1] = now.hour + node.hour;
//					pq.add(new Node(node.end, ans[ne][node.end][0], ans[ne][node.end][1]));
//				} else {
//					pq.add(new Node(node.end, ans[ne][node.end][0], ans[ne][node.end][1]));
//				}
//			}
//		}
//		System.out.println();
//		System.out.println("비용");
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				if(ans[i][j][0] == Integer.MAX_VALUE)
//					System.out.print("0 ");
//				else
//					System.out.print(ans[i][j][0] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		System.out.println("시간");
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				if(ans[i][j][1] == Integer.MAX_VALUE)
//					System.out.print("0 ");
//				else
//					System.out.print(ans[i][j][1] + " ");
//			}
//			System.out.println();
//		}

//		while (true) {
//			boolean check = false;
//			for (int i = 1; i <= N; i++) {
//				for (int j = i + 2; j <= N; j++) {
//					for (int k = i + 1; k < j; k++) {
//						if(ans[i][k][0] + ans[k][j][0] <= M) {
//							if(ans[i][k][1] + ans[k][j][1] < ans[i][j][1]) {
//								ans[i][j][0] = ans[i][k][0] + ans[k][j][0];
//								ans[i][j][1] = ans[i][k][1] + ans[k][j][1];
//								check = true;
//							}
//						}
//					}
//				}
//			}
//			if(!check) break;
//		}
//		System.out.println();
//		System.out.println("비용");
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				if(ans[i][j][0] == Integer.MAX_VALUE)
//					System.out.print("0 ");
//				else
//					System.out.print(ans[i][j][0] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		System.out.println("시간");
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				if(ans[i][j][1] == Integer.MAX_VALUE)
//					System.out.print("0 ");
//				else
//					System.out.print(ans[i][j][1] + " ");
//			}
//			System.out.println();
//		}
//	}

}
