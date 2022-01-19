package level15_dp;

import java.util.Scanner;

public class pb09_10844 {

	static long[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		arr = new long[N][10];

		long sum = 0;
		for (int i = 1; i <= 9; i++) {
			sum += cf(N - 1, i) % 1000000000;
		}

		System.out.println(sum%1000000000);

	}

	static long cf(int N, int idx) {
		if (N == 0) {
			return 1;
		}

		if (arr[N][idx] == 0) {
			long a = 0;
			if (idx == 0) {
				a = cf(N - 1, idx + 1) % 1000000000;
			} else if (idx == 9) {
				a = cf(N - 1, idx - 1) % 1000000000;
			} else {
				a = (cf(N - 1, idx + 1) + cf(N - 1, idx - 1)) % 1000000000;
			}
			arr[N][idx] = a % 1000000000;
		}

		return arr[N][idx] % 1000000000;
	}

}
