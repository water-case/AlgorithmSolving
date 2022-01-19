package level15_dp;

import java.util.Arrays;
import java.util.Scanner;

public class pb11_11053 {

	static int[] arr;
	static Integer[] ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		arr = new int[N];
		ans = new Integer[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			int a = cf(N - i);
			if (max < a) {
				max = a;
			}
		}
		System.out.println(max);
	}

	static int cf(int N) {

		if (ans[N] == null) {
			ans[N] = 1;
			for (int i = N - 1; i >= 0; i--) {
				if (arr[i] < arr[N]) {
					ans[N] = Math.max(cf(i) + 1, ans[N]);
				}
			}
		}

		return ans[N];
	}

}
