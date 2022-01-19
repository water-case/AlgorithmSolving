package level15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb06_1932 {

	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j <= i; j++) {
				arr[i][j] = Integer.parseInt(token.nextToken());
			}
		}

		cf(n - 2);
		
		System.out.println(arr[0][0]);
	}

	static void cf(int N) {
		if (N == -1) {
			return;
		}

		for (int i = 0; i < N + 1; i++) {
			if(arr[N+1][i] >= arr[N+1][i+1]) {
				arr[N][i] += arr[N+1][i];
			} else {
				arr[N][i] += arr[N+1][i+1];
			}
		}
		
		cf(N-1);

	}
}
