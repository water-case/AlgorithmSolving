package level15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb02_9184 {

	static int N = 0;
	static int[][][] arr = new int[21][21][21];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer token = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			int c = Integer.parseInt(token.nextToken());

			if (a == -1 && b == -1 && c == -1) {
				break;
			}

			sb.append("w(" + a + ", " + b + ", " + c + ") = " + cf(a, b, c) + "\n");
		}
		System.out.println(sb);
	}

	public static int cf(int a, int b, int c) {

		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}

		if ((0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20) && arr[a][b][c] != 0) {
			return arr[a][b][c];
		}

		if (a > 20 || b > 20 || c > 20) {
			return arr[20][20][20] = cf(20, 20, 20);
		}

		if (a < b && b < c) {
			return arr[a][b][c] = cf(a, b, c - 1) + cf(a, b - 1, c - 1) - cf(a, b - 1, c);
		}

		return arr[a][b][c] = cf(a - 1, b, c) + cf(a - 1, b - 1, c) + cf(a - 1, b, c - 1) - cf(a - 1, b - 1, c - 1);
	}

}
