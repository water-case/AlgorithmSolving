package level14_backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb8_14889 {

	static int N;
	static int[][] arr;
	static int ans = Integer.MAX_VALUE;
	static int[] first, second;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(token.nextToken());
			}
		}

		first = new int[N / 2];
		second = new int[N / 2];

		cf(0);

		System.out.println(ans);

	}

	public static void cf(int depth) {
		if (depth == N / 2) {
			int[] tmp = new int[N];
			for (int i = 0; i < N; i++) {
				tmp[i] = i;
			}
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < N; j++) {
					if (first[i] == j) {
						tmp[j] = -1;
					}
				}
			}
			int count = 0;
			for (int i = 0; i < N; i++) {
				if (tmp[i] != -1) {
					second[count++] = i;
				}
			}

			ans = Math.min(ans, Sum());
			return;
		}

		// 팀 나누기 백트래킹
		if (depth == 0) {
			for (int i = 0; i < N / 2; i++) {
				first[depth] = i;
				cf(depth + 1);
			}
		} else {
			for (int i = 0; i < N; i++) {
				if (i > first[depth - 1]) {
					first[depth] = i;
					cf(depth + 1);
				}
			}
		}
	}

	public static int Sum() {
		int v1 = 0, v2 = 0;

		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < N / 2; j++) {
				v1 += arr[first[i]][first[j]];
				v2 += arr[second[i]][second[j]];
			}
		}

		return Math.abs(v1 - v2);
	}

}
