package level15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb05_1149 {

	public static int[][] arr;
	public static int[][] ans;
	public static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N][3];
		ans = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(token.nextToken());
			arr[i][1] = Integer.parseInt(token.nextToken());
			arr[i][2] = Integer.parseInt(token.nextToken());
		}

		ans[0][0] = arr[0][0];
		ans[0][1] = arr[0][1];
		ans[0][2] = arr[0][2];

		System.out.println(Math.min(cf(N - 1, 0), Math.min(cf(N - 1, 1), cf(N - 1, 2))));

	}

	public static int cf(int n, int value) {
		if (ans[n][value] == 0) {
			if (value == 0) {
				ans[n][0] = Math.min(cf(n-1, 1), cf(n-1, 2)) + arr[n][0];
			} else if (value == 1) {
				ans[n][1] = Math.min(cf(n-1, 0), cf(n-1, 2)) + arr[n][1];
			} else {
				ans[n][2] = Math.min(cf(n-1, 0), cf(n-1, 1)) + arr[n][2];
			}
		}

		return ans[n][value];

	}

}
