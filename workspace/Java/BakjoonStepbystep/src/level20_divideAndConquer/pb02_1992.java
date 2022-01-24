package level20_divideAndConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class pb02_1992 {
	static int N;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++)
				arr[i][j] = s.charAt(j) - 48;
		}
//		for(int[] a: arr) System.out.println(Arrays.toString(a));

		cf(N, 0, 0);
		System.out.println(sb);
	}

	static void cf(int size, int x, int y) {
		if (size == 1) {
			sb.append(arr[x][y]);
			return;
		}
		label: for (int i = x; i < size + x; i++) {
			for (int j = y; j < size + y; j++) {
				if (arr[x][y] != arr[i][j]) {
					sb.append("(");
					int resize = size / 2;
					cf(resize, x, y);
					cf(resize, x, y + resize);
					cf(resize, x + resize, y);
					cf(resize, x + resize, y + resize);
					sb.append(")");
					break label;
				}
			}
			if (i == size + x - 1)
				sb.append(arr[x][y]);
		}
	}
}
