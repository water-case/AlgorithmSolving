package level15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pb01_1003 {

	static int T;
	static int tc[];
	static int ans[] = new int[2];
	static int fibos[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		fibos = new int[41][2];
		fibos[0] = new int[] { 0, 1 };
		fibos[1] = new int[] { 1, 0 };
		fibos[2] = new int[] { 1, 1 };

		for (int i = 3; i <= 40; i++) {
			fibos[i] = null;
		}

		tc = new int[T];
		for (int i = 0; i < T; i++) {
			tc[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < T; i++) {
			ans = fibo(tc[i]);
			System.out.println(ans[1] + " " + ans[0]);
		}

	}

	static int[] fibo(int n) {
		int[] a0 = new int[2];
		int[] a1 = null;
		int[] a2 = null;

		if (n == 0) {
			return fibos[0];
		} else if (n == 1) {
			return fibos[1];
		} else if (n == 2) {
			return fibos[2];
		} else if (fibos[n] != null) {
			return fibos[n];
		}

		if (fibos[n] == null) {
			a1 = fibo(n - 1);
			a2 = fibo(n - 2);
		}

		a0[0] = a1[0] + a2[0];
		a0[1] = a1[1] + a2[1];

		fibos[n] = a0;
		return a0;
	}

}
