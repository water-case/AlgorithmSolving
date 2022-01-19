package level15_dp;

import java.util.Arrays;
import java.util.Scanner;

public class pb14_9251 {

	static char[][] arr;
	static Integer[][] ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();

		int s1L = s1.length();
		int s2L = s2.length();

		ans = new Integer[s1L][s2L];
		arr = new char[2][];
		arr[0] = new char[s1L];
		arr[1] = new char[s2L];
		for (int i = 0; i < s1.length(); i++) {
			arr[0][i] = s1.charAt(i);
		}
		for (int i = 0; i < s2.length(); i++) {
			arr[1][i] = s2.charAt(i);
		}

		int a = cf(s1L - 1, s2L - 1);

		System.out.println(a);

	}

	static int cf(int n, int m) {

		if (n == -1 || m == -1) {
			return 0;
		}

		if (ans[n][m] == null) {
			ans[n][m] = 0;

			if (arr[0][n] == arr[1][m]) {
				ans[n][m] = cf(n - 1, m - 1) + 1;
			} else {
				ans[n][m] = Math.max(cf(n - 1, m), cf(n, m - 1));
			}

		}

		return ans[n][m];
	}

}
