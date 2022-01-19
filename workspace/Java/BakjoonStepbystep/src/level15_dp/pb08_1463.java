package level15_dp;

import java.util.Scanner;

public class pb08_1463 {

	static int N;
	static Integer[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		arr = new Integer[N + 1];
		arr[0] = 0;
		arr[1] = 0;

		System.out.println(cf(N));

	}

	static int cf(int n) {

		if (arr[n] == null) {
			int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c = 0;
			if (n % 3 == 0) {
				if (n / 3 == 1) {
					arr[n] = 1;
				}
				a = cf(n / 3);
			}
			if (n % 2 == 0) {
				if (n / 2 == 1) {
					arr[n] = 1;
				}
				b = cf(n / 2);
			}
			if (n - 1 == 1) {
				arr[n] = 1;
			}
			c = cf(n - 1);

			if (a >= b) {
				if (b >= c) {
					arr[n] = c + 1;
				} else {
					arr[n] = b + 1;
				}
			} else {
				if (a >= c) {
					arr[n] = c + 1;
				} else {
					arr[n] = a + 1;
				}
			}
		}

		return arr[n];
	}

}
