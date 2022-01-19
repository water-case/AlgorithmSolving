package level15_dp;

import java.io.IOException;
import java.util.Scanner;

public class pb04_9461 {

	static long[] ans = new long[101];

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		int[] arr = new int[T];
		for (int i = 0; i < T; i++) {
			arr[i] = sc.nextInt();
		}

		ans[0] = 1;
		ans[1] = 1;
		ans[2] = 1;
		ans[3] = 2;
		ans[4] = 2;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			sb.append(cf(arr[i] - 1)).append("\n");
		}

		System.out.println(sb);
	}

	public static long cf(int n) {
		if (ans[n] != 0)
			return ans[n];

		return ans[n] = cf(n - 1) + cf(n - 5);

	}

}
