package level20_divideAndConquer;

import java.util.Scanner;

public class pb07_10830 {

	static int[][] start;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		long B = sc.nextLong();
		start = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				start[i][j] = sc.nextInt() % 1000;

		int[][] ans = cf(start, B);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}

	}

	static int[][] matrix(int[][] ar1, int[][] ar2) {
		int[][] result = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++)
					result[i][j] += ar1[i][k] * ar2[k][j];
				result[i][j] %= 1000;
			}

		return result;
	}

	static int[][] cf(int[][] ar, long b) {
		if (b == 1)
			return ar;
		
		int[][] tmp = cf(ar, b/2);
		tmp = matrix(tmp, tmp);

		if (b % 2 == 1)
			return matrix(tmp, start);
		return tmp;
	}
}
