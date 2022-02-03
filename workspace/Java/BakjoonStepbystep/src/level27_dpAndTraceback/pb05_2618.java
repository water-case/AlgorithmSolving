package level27_dpAndTraceback;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb05_2618 {

	static int N, M;
	static int[][] acci, dp;

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		acci = new int[M+1][2];
		for (int i = 1; i <= M; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			acci[i][0] = Integer.parseInt(token.nextToken());
			acci[i][1] = Integer.parseInt(token.nextToken());
		}
		dp = new int[M+1][M+1];

		sb.append(cf(1, 0, 0)).append("\n");

		int a1 = 0;
		int a2 = 0;

		for (int i = 1; i <= M; i++) {
			int tmp = dist(1, a1, i);

			if (dp[a1][a2] - tmp == dp[i][a2]) {
				a1 = i;
				sb.append("1\n");
			} else {
				a2 = i;
				sb.append("2\n");
			}
		}

		System.out.println(sb);
	}

	static int cf(int idx, int a, int b) {
		if (idx > M)
			return 0;
		if (dp[a][b] != 0) {
			return dp[a][b];
		}

		int move1 = cf(idx + 1, idx, b) + dist(1, a, idx);
		int move2 = cf(idx + 1, a, idx) + dist(2, b, idx);

		dp[a][b] = Math.min(move1, move2);

		return dp[a][b];
	}

	static int dist(int num, int start, int end) {
		int startX = acci[start][0];
		int startY = acci[start][1];
		int endX = acci[end][0];
		int endY = acci[end][1];

		if (start == 0) {
			if (num == 1) {
				startX = startY = 1;
			} else {
				startX = startY = N;
			}
		}

		return Math.abs(startX - endX) + Math.abs(startY - endY);

	}

}
