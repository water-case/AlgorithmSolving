package level15_dp;

import java.util.Scanner;

public class pb03_1904 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		System.out.println(cf(N));

	}

	public static int cf(int N) {
		if (N == 1) {
			return 1;
		}
		if (N == 2) {
			return 2;
		}

		int v1 = 1;
		int v2 = 2;
		int sum = 0;

		for (int i = 2; i < N; i++) {
			sum = (v1 + v2) % 15746;
			v1 = v2;
			v2 = sum;
		}

		return sum;
	}
}
