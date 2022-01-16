package level14_backTracking;

import java.util.Scanner;

public class pb3_15651 {

	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		arr = new int[M];
		cf(N, M, 0);

		System.out.println(sb.toString());
	}

	public static void cf(int N, int M, int depth) {
		if (depth == M) {
			for (int i : arr) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			arr[depth] = i + 1;
			cf(N, M, depth + 1);
		}
	}

}
