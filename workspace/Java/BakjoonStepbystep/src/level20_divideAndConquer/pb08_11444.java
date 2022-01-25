package level20_divideAndConquer;

import java.util.Scanner;

public class pb08_11444 {

	static long[][] start = new long[][] { { 1, 1 }, { 1, 0 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		
		long[][] a = cf(start, n);
		
		System.out.println(a[1][0]);
		sc.close();
	}

	static long[][] matrix(long[][] ar1, long[][] ar2) {
		long[][] result = new long[2][2];
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++)
					result[i][j] += ar1[i][k] * ar2[k][j];
				result[i][j] %= 1_000_000_007;
			}

		return result;
	}

	static long[][] cf(long[][] ar, long b) {
		if (b == 1)
			return ar;

		long[][] tmp = cf(ar, b / 2);
		tmp = matrix(tmp, tmp);

		if (b % 2 == 1)
			return matrix(tmp, start);
		return tmp;
	}

}
