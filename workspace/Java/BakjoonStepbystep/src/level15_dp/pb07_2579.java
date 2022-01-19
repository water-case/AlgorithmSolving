package level15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pb07_2579 {

	static int arr[];
	static Integer ans[];
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N + 1];
		ans = new Integer[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		ans[0] = arr[0];
		ans[1] = arr[1];

		if (N >= 2) {
			ans[2] = arr[1] + arr[2];
		}
		
		

		System.out.println(cf(N));

	}

	static int cf(int depth) {
		if (ans[depth] == null) {
			ans[depth] = Math.max(cf(depth - 2), cf(depth - 3) + arr[depth - 1]) + arr[depth];
		}

		return ans[depth];

	}

}
