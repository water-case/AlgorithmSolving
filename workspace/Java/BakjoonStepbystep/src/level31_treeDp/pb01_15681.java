package level31_treeDp;

import java.io.*;
import java.util.*;

public class pb01_15681 {

	static boolean[] visit;
	static Integer[] dp;
	static ArrayList<Integer>[] edge;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int R = Integer.parseInt(token.nextToken());
		int Q = Integer.parseInt(token.nextToken());

		visit = new boolean[N + 1];
		dp = new Integer[N + 1];
		edge = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			edge[i] = new ArrayList<>();

		for (int i = 1; i < N; i++) {
			token = new StringTokenizer(br.readLine());
			int a1 = Integer.parseInt(token.nextToken());
			int a2 = Integer.parseInt(token.nextToken());
			edge[a1].add(a2);
			edge[a2].add(a1);
		}

		cf(0, R);
//		System.out.println(Arrays.toString(dp));
		
		for (int i = 0; i < Q; i++) {
			int a = Integer.parseInt(br.readLine());
			System.out.println(dp[a]);
		}

	}
	
	static int cf(int last, int R) {
		if(dp[R] == null) {
			dp[R] = 1;
			for(int a : edge[R]) {
//				System.out.println(a);
				if(a != last) {
					dp[R] += cf(R, a);
				}
			}
		}
		return dp[R];
	}

}
