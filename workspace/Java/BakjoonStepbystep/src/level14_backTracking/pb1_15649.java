package level14_backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pb1_15649 {

	public static int[] arr;
	public static boolean[] visit;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());

		arr = new int[M];
		visit = new boolean[N];
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
			if (!visit[i]) {
				visit[i] = true;
				arr[depth] = i + 1;
				cf(N, M, depth + 1);
				visit[i] = false;
			}
		}
	}

}
