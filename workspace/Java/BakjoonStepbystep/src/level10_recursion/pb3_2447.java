package level10_recursion;

import java.util.Scanner;

public class pb3_2447 {

	static char arr[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();

		arr = new char[N][N];

		star(0, 0, N, false);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.print(sb);
		

	}

	static void star(int x, int y, int n, boolean b) {
		if (b) {
			for (int i = x; i < x + n; i++) {
				for (int j = y; j < y + n; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}

		if (n == 1) {
			arr[x][y] = '*';
			return;
		}

		int count = 0;
		for (int i = x; i < x + n; i += n / 3) {
			for (int j = y; j < y + n; j += n / 3) {
				count++;
				if (count == 5)
					star(i, j, n / 3, true);
				else
					star(i, j, n / 3, false);
			}
		}

	}

}
