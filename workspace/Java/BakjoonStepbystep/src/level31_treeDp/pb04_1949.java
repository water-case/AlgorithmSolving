package level31_treeDp;

import java.io.*;
import java.util.*;

public class pb04_1949 {

	static int N;
	static int[] arr;
	static Integer[][] dp;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 마을 개수
		arr = new int[N + 1];
		dp = new Integer[N+1][2];
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(token.nextToken());
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
			tree.add(new ArrayList<>());
		}

		for (int i = 1; i < N; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			int a1 = Integer.parseInt(token.nextToken());
			int a2 = Integer.parseInt(token.nextToken());
			list.get(a1).add(a2);
			list.get(a2).add(a1);
		}

		treeBuilder(1, -1); // 받아온 양방향 간선 그래프에서 루트노드가 1인 트리형식으로 구조변경

		dp[1][0] = dp(1, 0, 0);
		dp[1][1] = dp(1, 1, 0);

		if (dp[1][0] > dp[1][1])
			System.out.println(dp[1][0]);
		else
			System.out.println(dp[1][1]);

	}

	static int dp(int now, int visit, int cnt) {
		int result = 0;

		if(dp[now][visit] == null) {
			if (visit == 1) { // now가 우수 마을인경우 자식들은 무조건 우수마을이 아님
				for (int son : tree.get(now))
					result += dp(son, 0, 1);
				dp[now][visit] = result + arr[now];
			} else { // now가 우수 마을아닌경우 자식들중 하나만 우수마을이면 되므로 우수마을 일수도 아닐수도 있음
				for (int son : tree.get(now)) {
					if (cnt == 2) {	// 3번연속 우수마을이 아닐수는없음
						result += dp(son, 1, 0);
					} else {
						int ans1 = dp(son, 0, 1);
						int ans2 = dp(son, 1, 0);
						
						result += Math.max(ans1, ans2);
					}
				}
				dp[now][visit] = result;
			}
		}
		
		return dp[now][visit];

	}

	static void treeBuilder(int now, int parent) {
		for (int son : list.get(now)) {
			if (son != parent) {
				tree.get(now).add(son);
				treeBuilder(son, now);
			}
		}
	}

}
