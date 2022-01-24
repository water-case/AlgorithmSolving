package level20_divideAndConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb01_2630 {
	static int[][] arr;
	static int N;
	static int[] ans = new int[2];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		cf(N, 0, 0);

		System.out.println(ans[0]);
		System.out.println(ans[1]);
	}

	public static void cf(int size, int x, int y) {
		if (size == 1) {
			ans[arr[x][y]]++;
			return;
		}
		label: for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (arr[x][y] != arr[i][j]) {
					int resize = size / 2;
					cf(resize, x, y);
					cf(resize, x + resize, y);
					cf(resize, x, y + resize);
					cf(resize, x + resize, y + resize);
					break label;
				}
			}
			if (i == x + size - 1) {
				ans[arr[x][y]]++;
			}
		}
	}

}
