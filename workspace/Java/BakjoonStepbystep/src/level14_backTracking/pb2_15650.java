package level14_backTracking;

import java.util.Scanner;

public class pb2_15650 {

	public static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		arr = new int[M];

		cf(N, M, 0);

	}

	public static void cf(int N, int M, int depth) {

		if (depth == M) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (depth == 0) {
				arr[depth] = i + 1;
				cf(N, M, depth + 1);
			}

			if (depth > 0 && i + 1 > arr[depth - 1]) {
				arr[depth] = i + 1;
				cf(N, M, depth + 1);
			}
		}

	}

}
