package level14_backTracking;

import java.util.Scanner;

public class pb5_9663 {

	public static int count = 0;
	public static int N;
	public static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];

		cf(0);
		System.out.println(count);

		sc.close();
	}

	public static void cf(int depth) {
		if (depth == N) {
			count++;
			return;
		}

		for (int i = 0; i < N; i++) {
			arr[depth] = i;
			if (poss(depth)) {
				cf(depth + 1);
			}
		}
	}

	public static boolean poss(int col) {
		for (int i = 0; i < col; i++) {
			if (arr[col] == arr[i]) {
				return false;
			} else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			}
		}

		return true;
	}

}
