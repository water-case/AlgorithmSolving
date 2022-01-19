package level15_dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class pb12_11054 {

	static Integer[] arr;
	static Integer[] ansR;
	static Integer[] ansL;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		arr = new Integer[N];
		ansR = new Integer[N];
		ansL = new Integer[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int a = 0;
		int b = 0;
		for (int i = 1; i <= N; i++) {
			a = cf(N - i, ansR);
		}

		List<Integer> list = Arrays.asList(arr);
		Collections.reverse(list);
		arr = list.toArray(arr);

		for (int i = 1; i <= N; i++) {
			b = cf(N - i, ansL);
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			int tmp = ansR[i] + ansL[N - i - 1] - 1;

			if (tmp > max) {
				max = tmp;
			}
		}

		System.out.println(max);

	}

	static int cf(int n, Integer[] ans) {
		if (ans[n] == null) {
			ans[n] = 1;
			for (int i = 0; i < n; i++) {
				if (arr[i] < arr[n]) {
					ans[n] = Math.max(cf(i, ans) + 1, ans[n]);
				}
			}
		}

		return ans[n];
	}

}
