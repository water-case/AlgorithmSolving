package level15_dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class pb13_2565 {

	static int N;
	static int[][] arr;
	static Integer[] ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		arr = new int[N][2];
		ans = new Integer[N];

		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}

		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			max = Math.max(cf(i), max);
		}

		System.out.println(N - max);
	}

	static int cf(int n) {

		if (ans[n] == null) {
			ans[n] = 1;

			for (int i = n + 1; i < ans.length; i++) {
				if (arr[n][1] < arr[i][1]) {
					ans[n] = Math.max(ans[n], cf(i) + 1);
				}
			}
		}

		return ans[n];
	}

}
